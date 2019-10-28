package model.pets;

import model.Human;

public class Cat extends Pet {

    private static final double DEFAULT_CAT_PRICE = 50.00;

    public Cat(String color, boolean friendly, boolean needsAttention, double price, Human human){
        super("cat", color, friendly, needsAttention, price, human);
    }

    public Cat(String color){
        super("cat", color, DEFAULT_CAT_PRICE);
    }

}
