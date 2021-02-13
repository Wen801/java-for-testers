/*In this exercise, your challenge is to write a Fruit Shop Cart Calculator.
Write tests code to illustrate the following requirements,
and write the additional application code you need to make them work:

        The shop sells apples, oranges, bananas, pears, peaches and other fruit, depending on availability.
        For example the prices per kilo for the currently available fruit are:
        Apples: $4.00
        Oranges: $5.50
        Bananas: $6.00
        Pears: $4.50

        You can add items to your shopping cart, which should keep a running total.
        When you buy 5 kilos or more of any fruit, you get a 10% discount.
        You should end up with at least 10 test cases. The first one is written for you.

*/

package com.serenitydojo.fruitmarket;
import org.junit.Before;
import org.junit.Test;
import static com.serenitydojo.fruitmarket.Fruit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class TheCatalog {
    Catalog catalog;

    @Before
    public void setupFruitCatalog(){
        catalog = new Catalog();
        catalog.setPriceOf(Apple).to(4.00)
                .setPriceOf(Orange).to(5.50)
                .setPriceOf(Banana).to(6.00)
                .setPriceOf(Pear).to(4.50)
                .setPriceOf(Strawberries).to(5.20)
                .setPriceOf(Mulberries).to(7.25)
                .setPriceOf(Peach).to(3.15);
    }

    //update the catalog with the current market price of a fruit
    //The Catalog should report the price of a given type of fruit
    @Test
    public void shouldBeAbleToUpdateTheCurrentPriceOfAFruit() {
        assertThat(catalog.getPriceOf(Apple)).isEqualTo(4.00);
        assertThat(catalog.getPriceOf(Orange)).isEqualTo(5.50);
        assertThat(catalog.getPriceOf(Banana)).isEqualTo(6.00);
        assertThat(catalog.getPriceOf(Pear)).isEqualTo(4.50);
        assertThat(catalog.getPriceOf(Strawberries)).isEqualTo(5.20);
    }

    //The Catalog should list the names of the currently available fruit in alphabetical order
    @Test
    public void listNamesOfAllTheCurrentlyAvailableFruits(){
        assertThat(catalog.getAvailableFruit()).containsExactly("Apple", "Banana","Mulberries", "Orange","Peach","Pear","Strawberries");
    }

    // The Catalog should throw a FruitUnavailableException if the fruit is not currently available
    @Test (expected=FruitNotAvailableException.class)
    public void shouldReportExceptionIfFruitIsNotAvailable (){
        assertThat(catalog.getPriceOf(Kiwi)).isEqualTo(5.30);
    }

    //You can add items to your shopping cart, which should keep a running total.
    @Test ()
    public void shouldCalculateTheTotalCostOfItemsInShoppingCart (){
        ShoppingCart cart = new ShoppingCart(catalog);
        cart.add(1.0, Apple);
        cart.add(2.5,Strawberries);
        assertThat(cart.getTotalPrice()).isEqualTo(17.0);
    }

    //When you buy 5 kilos or more of any fruit, you get a 10% discount.
    //Apples: $4.00 ;  strawberries: $5.20;
    @Test
    public void discountPriceForItemsOver5KilosInShoppingCart (){
        ShoppingCart cart = new ShoppingCart(catalog);
        cart.add(5.0, Apple);
        cart.add(5.0,Strawberries);
        cart.add(10.2,Banana);
        assertThat(cart.getTotalPrice()).isEqualTo(96.48,within(0.001));
    }


}

