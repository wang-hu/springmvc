package demo.strategyDemo.example;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * 策略工厂
 *
 * @author:wh
 * @create in 18-3-13 下午3:37
 */
public class CalPriceFactory {
    private static final String CAL_PRICE_PACKAGE = "demo.strategyDemo.example";//这里是一个常量，表示我们扫描策略的包

    private ClassLoader classLoader = getClass().getClassLoader();

    private List<Class<? extends CalPrice>> calPriceList;//策略列表


    public CalPrice getCalPrice(Customer customer) {
        //在策略列表中查找策略
        for (Class<? extends CalPrice> clazz : calPriceList) {
            PriceRegion validRegion = handleAnnotation(clazz);//获取该策略的注解

            if (customer.getTotalAmount() > validRegion.min() && customer.getTotalAmount() < validRegion.max()) {
                try {
                    return clazz.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("策略获取失败");
                }
            }
        }
        throw new RuntimeException("策略获取失败");

    }

    private PriceRegion handleAnnotation(Class<? extends CalPrice> clazz) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (StringUtils.isEmpty(annotations))
            return null;
        for (Annotation annotation : annotations) {
            if (annotation instanceof PriceRegion) {
                return (PriceRegion) annotation;
            }
        }

        return null;

    }

    //单例
    private CalPriceFactory() {
        initObj();
    }

    public static CalPriceFactory getInstance() {
        return calPriceFactoryInstance.calPriceFactory;
    }

    private static class calPriceFactoryInstance {
        private static CalPriceFactory calPriceFactory = new CalPriceFactory();
    }


    //在工厂初始化的时候要初始化策略列表
    private void initObj() {
        calPriceList = new ArrayList<>();
        File[] files = getResources();//获取包下面的所有class文件
        Class<CalPrice> calPriceClass = null;
        try {
            calPriceClass = (Class<CalPrice>) classLoader.loadClass(CalPrice.class.getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("未找到策略接口");
        }

        for (File file : files) {
            try {
                Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE+"."+file.getName().replace(".class",""));
                //isAssignableFrom 判断一个类/接口是否和另一个类/接口的类型相同
                if (CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClass) {
                    calPriceList.add((Class<? extends CalPrice>) clazz);
                }


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }

    //获取扫描的包下面所有的class文件
    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(pathname -> {
                if (pathname.getName().endsWith(".class")) {//我们只扫描class文件
                    return true;
                }
                return false;
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }
}
