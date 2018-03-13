package demo.strategyDemo;

import org.apache.log4j.Logger;

/**
 * 策略算法A
 *
 * @author:wh
 * @create in 18-3-13 下午2:30
 */
public class StrategyA implements Strategy {
    Logger logger = Logger.getLogger(StrategyA.class);

    @Override
    public void testStrategy() {
        logger.info("this is a StrategyA");
    }
}
