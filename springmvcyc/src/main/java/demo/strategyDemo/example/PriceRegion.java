package demo.strategyDemo.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//有效价格区间的注解
@Target(ElementType.TYPE)//表示只能给类添加注解
@Retention(RetentionPolicy.RUNTIME)//这个必须要将注解保留在运行时
public @interface PriceRegion {
    int max() default Integer.MAX_VALUE;
    int min() default Integer.MIN_VALUE;
}
