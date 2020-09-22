package kata.supermarket;

import java.math.BigDecimal;

public class ThreeItemsForThePriceOfTwo implements DiscountByUnit {
    @Override
    public BigDecimal apply(Product product, BigDecimal units) {
        BigDecimal reminder = units.remainder(BigDecimal.valueOf(3));
        if (reminder.compareTo(BigDecimal.ZERO) == 0) {
            BigDecimal discunits = units.multiply(BigDecimal.valueOf(2)).divide(BigDecimal.valueOf(3));
            return product.pricePerUnit().multiply(units.subtract(discunits));
        } else {
            BigDecimal discountedUnits = units.subtract(reminder);
            BigDecimal discunits = discountedUnits.multiply(BigDecimal.valueOf(2)).divide(BigDecimal.valueOf(3));
            BigDecimal discountedPrice =
                    product.pricePerUnit().multiply(units.subtract(discunits));
            return discountedPrice;
        }
    }
}
