package kata.supermarket;

import java.math.BigDecimal;

public class Product {

    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public ItemByUnit oneOf() {
        return new ItemByUnit(this);
    }

    public ItemByUnit unitOf(int units) {
        return new ItemByUnit(this, units);
    }
}
