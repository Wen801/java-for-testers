package com.serenitydojo.fruitmarket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final Catalog catalog;
    private final List<ShoppingCartItem> items;

    public ShoppingCart(Catalog catalog) {
        this.catalog = catalog;
        this.items = new ArrayList<>();
    }

    public void add (Double quantity, Fruit fruit){
        double cost;
         if (quantity<5)   {
               cost= quantity*catalog.getPriceOf(fruit);}
         else {
             cost=(quantity*catalog.getPriceOf(fruit))*0.9;
         }
        items.add(new ShoppingCartItem(fruit,quantity,cost));
    }

    public double getTotalPrice (){
        return items.stream().mapToDouble(ShoppingCartItem::getTotalCost).sum();
    }
}
