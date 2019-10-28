package model.pets;

import model.Human;

public class Parrot extends Pet {

    private static final double DEFAULT_PARROT_PRICE = 30.00;

    public Parrot(String color, boolean friendly, boolean needsAttention, double price, Human human){
        super("parrot", color, friendly, needsAttention, price, human);
    }

    public Parrot(String color){
        super("parrot", color, DEFAULT_PARROT_PRICE);
    }

}
