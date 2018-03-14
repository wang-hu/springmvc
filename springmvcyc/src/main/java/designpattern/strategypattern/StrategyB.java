package designpattern.strategypattern;

import org.apache.log4j.Logger;

/**
 * 策略算法B
 *
 * @author:wh
 * @create in 18-3-13 下午2:30
 */
public class StrategyB implements Strategy {
    Logger logger = Logger.getLogger(StrategyA.class);

    @Override
    public void testStrategy() {
        //logger.info("this is a StrategyB");
        System.out.println("this is a StrategyB");
    }
}
