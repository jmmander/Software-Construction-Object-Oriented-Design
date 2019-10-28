package model;

import java.util.ArrayList;

public class Dish {
    private String description;
    private ArrayList<String> ingredients;
    private String name;
    private String recipe;

    public Dish(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dish(String name, String description, ArrayList<String> ingredients, String recipe) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }


    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
