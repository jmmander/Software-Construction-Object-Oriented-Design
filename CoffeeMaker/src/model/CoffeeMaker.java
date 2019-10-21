package model;

import exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    int time;
    boolean haveCups;
    int cups;

    public CoffeeMaker(){

    }

    // getters
    public int getTimeSinceLastBrew () {
        return time;
    }
    public int getCupsRemaining () {
        return cups;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining () {
        if (getCupsRemaining() < 1) {
            haveCups = false;
        }
        else {
            haveCups = true;
        }
        return haveCups;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew (int time) {
        this.time = time;
    }


    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    public void brew(double beans, double water) throws TooManyBeansException, WaterException, NotEnoughBeansException {
        if (beans < 2.4) {
            throw new NotEnoughBeansException(beans);
        }
        else if (beans > 2.6) {
            throw new TooManyBeansException(beans);
        }
        else if (water < 14.75){
            throw new WaterException(water);
        }
        else{
            setTimeSinceLastBrew(0);
            cups = 20;
            System.out.println("Coffee has been brewed");
        }
    }

    ///REQUIRES: cups remaining > 0, time since last brew < 60
    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException {
        if (areCupsRemaining()) {
            time = getTimeSinceLastBrew();
            if (time >= 60) {
                throw new StaleCoffeeException(time);
            } else {
                cups = cups - 1;
                System.out.println("Coffee poured. You have " + cups + " cups left");
            }
        }
        else{
            throw new NoCupsRemainingException();
        }
        }
    }



