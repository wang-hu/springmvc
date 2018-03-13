package demo.strategyDemo.example;
/**
 *
 * @author:wh
 * @create in 18-3-13 下午3:20    
 */
public class Client {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.buy(5000D);
        System.out.println("玩家需要付钱：" + customer.calcAmount());
        customer.buy(12000D);
        System.out.println("玩家需要付钱：" + customer.calcAmount());
        customer.buy(12000D);
        System.out.println("玩家需要付钱：" + customer.calcAmount());
        customer.buy(12000D);
        System.out.println("玩家需要付钱：" + customer.calcAmount());
    }
}
