package ui;

import exceptions.*;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args){
       //sucessful
        CoffeeMaker coffeemaker = new CoffeeMaker();

        try {
            coffeemaker.brew(2.5, 15);
            coffeemaker.pourCoffee();
            coffeemaker.pourCoffee();
            coffeemaker.setTimeSinceLastBrew(30);
            coffeemaker.pourCoffee();
            coffeemaker.brew(2.9, 12);
            coffeemaker.pourCoffee();
        } catch (TooManyBeansException e) {
            System.out.println(e.getMessage());
        } catch (WaterException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughBeansException e) {
            System.out.println(e.getMessage());
        } catch (NoCupsRemainingException e) {
            System.out.println(e.getMessage());
        } catch (StaleCoffeeException e) {
            System.out.println(e.getMessage());
        }



    }


}