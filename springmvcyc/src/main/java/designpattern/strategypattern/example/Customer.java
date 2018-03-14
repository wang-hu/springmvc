package designpattern.strategypattern.example;
/**
 *
 * @author:wh
 * @create in 18-3-13 下午3:12    
 */
public class Customer {
    private Double totalAmount = 0D;//消费总金额
    private Double amount;//单次消费金额
    private CalPrice calPrice = new OriginPrice();//默认是原价

    public void buy(Double amount) {
        this.amount = amount;
        totalAmount += amount;

        calPrice = CalPriceFactory.getInstance().getCalPrice(this);
    }

    /**
     * 根据身份计算价格
     * @return
     */
    public Double calcAmount() {
        return calPrice.calPrice(amount);
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
