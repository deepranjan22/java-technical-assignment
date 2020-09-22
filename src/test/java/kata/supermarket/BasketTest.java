package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket();
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                noItems(),
                aSingleItemPricedPerUnit(),
                multipleItemsPricedPerUnit(),
                aSingleItemPricedByWeight(),
                multipleItemsPricedByWeight(),
                threeItemsPricedTwoForOneUnit(),
                threeItemsPriceHalfPricedDiscountPerUnit(),
                threeKiloHalfPricePricedByWeight(),
                sixPencilsWithThreeItemsForThePriceOfTwoPricedPerUnit()

        );
    }

    private static Arguments aSingleItemPricedByWeight() {
        return Arguments.of("a single weighed item", "1.25", Collections.singleton(twoFiftyGramsOfAmericanSweets()));
    }

    private static Arguments multipleItemsPricedByWeight() {
        return Arguments.of("multiple weighed items", "1.85",
                Arrays.asList(twoFiftyGramsOfAmericanSweets(), twoHundredGramsOfPickAndMix())
        );
    }

    private static Arguments multipleItemsPricedPerUnit() {
        return Arguments.of("multiple items priced per unit", "2.04",
                Arrays.asList(aPackOfDigestives(), aPintOfMilk()));
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments threeItemsPricedTwoForOneUnit() {
        return Arguments.of("2 for one priced discount", "2.00", Collections.singleton(threePencilsWithTwoForOneDiscount()));
    }

    private static Arguments threeItemsPriceHalfPricedDiscountPerUnit() {
        return Arguments.of("half priced discount priced per unit", "3.75", Collections.singleton(threePencilsWithHalfPriceeDiscount()));
    }

    private static Arguments sixPencilsWithThreeItemsForThePriceOfTwoPricedPerUnit() {
        return Arguments.of("Discount Price for three items for the price of Two, per unit", "9.00", Collections.singleton(sixPencilsWithThreeItemsForThePriceOfTwo()));
    }


    private static Arguments threeKiloHalfPricePricedByWeight() {
        return Arguments.of("half price discount over one kilo priced by weight", "7.50", Collections.singleton(threeKiloAndHalfPRiceDiscountOVerOneKilo()));
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49")).oneOf();
    }

    private static Item aPackOfDigestives() {
        return new Product(new BigDecimal("1.55")).oneOf();
    }

    private static WeighedProduct aKiloOfAmericanSweets() {
        return new WeighedProduct(new BigDecimal("4.99"));
    }

    private static Item twoFiftyGramsOfAmericanSweets() {
        return aKiloOfAmericanSweets().weighing(new BigDecimal(".25"));
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"));
    }

    private static Item twoHundredGramsOfPickAndMix() {
        return aKiloOfPickAndMix().weighing(new BigDecimal(".2"));
    }

    private static Item threePencilsWithTwoForOneDiscount() {
        return new Product(new BigDecimal(".75")).unitOf(5).setDiscount(new BuyTwoForOnePoundDiscount());
    }

    private static Item threePencilsWithHalfPriceeDiscount() {
        return new Product(new BigDecimal("2.50")).unitOf(3).setDiscount(new HalfPriceDiscountByUnit());
    }

    private static Item sixPencilsWithThreeItemsForThePriceOfTwo() {
        return new Product(new BigDecimal("1.50")).unitOf(9).setDiscount(new ThreeItemsForThePriceOfTwo());
    }

    private static Item threeKiloAndHalfPRiceDiscountOVerOneKilo() {
        return new WeighedProduct(new BigDecimal("5.0")).weighing(new BigDecimal("3.0")).setDiscount(new HalPriceDiscountPerOneKilo());
    }

}