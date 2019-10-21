package exceptions;

public class WaterException extends Exception {

    private double water;

    public WaterException(double water){
        super(water + " is too little water");
        this.water = water;

    }
}
