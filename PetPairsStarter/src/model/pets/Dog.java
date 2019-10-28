package model.pets;

import model.Human;

public class Dog extends Pet {

    private static final double DEFAULT_DOG_PRICE = 100.00;

    public Dog(String color, boolean friendly, boolean needsAttention, double price, Human human){
        super("dog", color, friendly, needsAttention, price, human);
    }

    public Dog(String color){
        super("dog", color, DEFAULT_DOG_PRICE);
    }

}
