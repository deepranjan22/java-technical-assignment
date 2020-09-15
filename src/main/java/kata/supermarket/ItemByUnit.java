package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final Product product;
    private final int units;
    private DiscountByUnit discount;

    ItemByUnit(final Product product) {
        this.product = product;
        this.units = 1;
    }

    ItemByUnit(final Product product, final int units) {
        this.product = product;
        this.units = units;
    }

    public ItemByUnit(Product product, int units, DiscountByUnit discount) {
        this.product = product;
        this.units = units;
        this.discount = discount;
    }

    public BigDecimal price() {
        return product.pricePerUnit().multiply(BigDecimal.valueOf(units));
    }

    public ItemByUnit setDiscount(DiscountByUnit discount) {
        this.discount = discount;
        return this;
    }

    @Override
    public BigDecimal discount() {
      if (discount != null) {
         return discount.apply(product, BigDecimal.valueOf(units));
      }
      return BigDecimal.ZERO;
    }
}
