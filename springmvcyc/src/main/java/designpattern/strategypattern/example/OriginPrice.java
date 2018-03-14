package designpattern.strategypattern.example;/**
 * @author:wh
 * @date:create in 18-3-13 下午3:15
 */

/**
 *
 * @author:wh
 * @create in 18-3-13 下午3:15    
 */
@PriceRegion(max = 10000)
public class OriginPrice implements CalPrice{
    @Override
    public Double calPrice(Double price) {
        return price;
    }
}
