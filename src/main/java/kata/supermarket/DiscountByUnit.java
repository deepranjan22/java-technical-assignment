package kata.supermarket;

import java.math.BigDecimal;

public interface DiscountByUnit {
    BigDecimal apply(Product product, BigDecimal units);
}
