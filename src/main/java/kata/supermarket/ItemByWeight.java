package kata.supermarket;

import java.math.BigDecimal;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;
    private DiscountByWeight discount;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos) {
        this(product, weightInKilos, null);
    }

    public ItemByWeight(WeighedProduct product, BigDecimal weightInKilos, DiscountByWeight discount) {
        this.product = product;
        this.weightInKilos = weightInKilos;
        this.discount = discount;
    }

    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public ItemByWeight setDiscount(DiscountByWeight discount) {
        this.discount = discount;
        return this;
    }

    @Override
    public BigDecimal discount() {
        if (discount != null) {
            return discount.apply(product, weightInKilos);
        }
        return BigDecimal.ZERO;
    }
}
