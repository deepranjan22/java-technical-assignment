package kata.supermarket;

import java.math.BigDecimal;

public class HalfPriceDiscountByUnit implements DiscountByUnit{
    @Override
    public BigDecimal apply(Product product, BigDecimal units) {
        return product.pricePerUnit().multiply(units).divide(BigDecimal.valueOf(2));
    }
}
