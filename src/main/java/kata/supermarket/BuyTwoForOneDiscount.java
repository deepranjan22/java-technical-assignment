package kata.supermarket;

import java.math.BigDecimal;

public class BuyTwoForOneDiscount implements DiscountByUnit{
    @Override
    public BigDecimal apply(Product product, BigDecimal units) {
        BigDecimal div = units.divideToIntegralValue(BigDecimal.valueOf(2));
        return product.pricePerUnit().multiply(div);
    }
}

