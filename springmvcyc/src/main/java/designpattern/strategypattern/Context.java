package designpattern.strategypattern;/**
 * @author:wh
 * @date:create in 18-3-13 下午2:30
 */

/**
 *环境角色类
 * @author:wh
 * @create in 18-3-13 下午2:30    
 */
public class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doStrategy() {
        strategy.testStrategy();
    }
}
