package com.serenitydojo.fruitmarket;


import org.assertj.core.api.AbstractBooleanArrayAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalog {

    private Map<Fruit, Double> pricePerKilo = new HashMap<>();

    public PriceSetter setPriceOf(Fruit fruit) {
        return new PriceSetter(this, fruit);
    }

    public Double getPriceOf(Fruit fruit) {
        if (pricePerKilo.containsKey(fruit)) {
            return pricePerKilo.get(fruit);
        }
        throw new FruitNotAvailableException(fruit.name()+" is currently not available");
    }

    public List<String> getAvailableFruit() {
       return  pricePerKilo.keySet().stream()
                .map(fruit -> fruit.name()) //could be map(Enum:name)
               .sorted()
               .collect(Collectors.toList());
    }

    public static class PriceSetter {
        private final Catalog catalog;
        private final Fruit fruit;

        public PriceSetter(Catalog catalog, Fruit fruit) {
            this.catalog = catalog;
            this.fruit = fruit;
        }

        public Catalog to(Double price) {
            catalog.pricePerKilo.put(fruit, price);
            return catalog;
        }
    }
}
