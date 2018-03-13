package demo.strategyDemo.example;/**
 * @author:wh
 * @date:create in 18-3-13 下午3:10
 */

/**
 *
 * @author:wh
 * @create in 18-3-13 下午3:10    
 */
@PriceRegion(max = 42000)
public class GoldVip implements CalPrice{
    @Override
    public Double calPrice(Double price) {
        return price * 0.7;
    }
}
