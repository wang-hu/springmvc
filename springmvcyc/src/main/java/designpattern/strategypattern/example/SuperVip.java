package designpattern.strategypattern.example;/**
 * @author:wh
 * @date:create in 18-3-13 下午3:10
 */

/**
 *
 * @author:wh
 * @create in 18-3-13 下午3:10    
 */
@PriceRegion(min=20000,max = 30000)
public class SuperVip implements CalPrice {
    @Override
    public Double calPrice(Double price) {
        return price * 0.8;
    }
}
