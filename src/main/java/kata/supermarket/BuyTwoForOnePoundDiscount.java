package kata.supermarket;

import java.math.BigDecimal;

public class BuyTwoForOnePoundDiscount implements DiscountByUnit{
    @Override
    public BigDecimal apply(Product product, BigDecimal units) {
        BigDecimal reminder = units.remainder(BigDecimal.valueOf(2));
        if (reminder.compareTo(BigDecimal.ZERO)==0) {
            BigDecimal totalChargeToCust = units.divide(BigDecimal.valueOf(2));
            BigDecimal withoutDiscount = product.pricePerUnit().multiply(units);
            return withoutDiscount.subtract(totalChargeToCust);
        } else {
            BigDecimal discountEligibility = units.subtract(reminder);
            BigDecimal totalChargeToCust = discountEligibility.divide(BigDecimal.valueOf(2));
            BigDecimal withoutDiscount = product.pricePerUnit().multiply(units);
            return withoutDiscount.subtract(totalChargeToCust);
        }
    }
}

