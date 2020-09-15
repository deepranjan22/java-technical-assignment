package kata.supermarket;

import java.math.BigDecimal;

public interface DiscountByWeight {
    BigDecimal apply(WeighedProduct product, BigDecimal weigth);
}
