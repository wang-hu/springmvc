package designpattern.strategypattern;

/**
 * 测试策略模式
 * @author:wh
 * @create in 18-3-13 下午2:36
 */
public class TestStrategy {

    public static void main(String[] args) {
        Strategy strategy = new StrategyA();
        Context context = new Context(strategy);
        context.doStrategy();
    }
}
