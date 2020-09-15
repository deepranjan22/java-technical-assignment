package kata.supermarket;

import java.math.BigDecimal;

public class HalPriceDiscountPerOneKilo implements DiscountByWeight {
    @Override
    public BigDecimal apply(WeighedProduct product, BigDecimal weigth) {
        BigDecimal oneKilo = new BigDecimal(1.0);
        if (weigth.compareTo(oneKilo) > 0){
            return product.weighing(weigth).price().divide(BigDecimal.valueOf(2));
        }
        return BigDecimal.ZERO;
    }
}
