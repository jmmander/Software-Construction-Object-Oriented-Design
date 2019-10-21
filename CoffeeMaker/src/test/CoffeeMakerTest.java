package test;

import exceptions.*;
import junit.framework.TestCase;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;


public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;
    @Before
    public void setUp(){
        coffeeMaker = new CoffeeMaker();
    }

    @Test
    public void testBrewCoffeeTooManyBeansOKWater() {
        try {
            coffeeMaker.brew(3, 15);
        } catch (TooManyBeansException e) {
            //do nothing;
        } catch (WaterException e) {
            fail("water exception");
        } catch (NotEnoughBeansException e) {
            fail("not enough beans exception");
        }
    }


        @Test
        public void testBrewCoffeeNotEnoughBeansOKWater(){
            try {
                coffeeMaker.brew(1,15);
            } catch (TooManyBeansException e) {
                fail("Too many beans exception");
            } catch (WaterException e) {
                fail("water exception");
            } catch (NotEnoughBeansException e) {
               //;
            }
        }

    @Test
    public void testBrewCoffeeNotEnoughBeansNotEnoughWater(){
        try {
            coffeeMaker.brew(1,1);
        } catch (TooManyBeansException e) {
            fail("Too many beans exception");
        } catch (WaterException e) {
            fail("water exception");
        } catch (NotEnoughBeansException e) {
            //;
        }
    }


    @Test
    public void testBrewCoffeeTooManyBeansNotEnoughWater(){
        try {
            coffeeMaker.brew(10,1);
        } catch (TooManyBeansException e) {
            //
        } catch (WaterException e) {
            fail("water exception");
        } catch (NotEnoughBeansException e) {
            fail("Not enough beans exception");
        }
    }

    @Test
    public void testBrewCoffeeOKBeansNotEnoughWater(){
        try {
            coffeeMaker.brew(2.5,10);
        } catch (TooManyBeansException e) {
            fail("too many beans exception");
        } catch (WaterException e) {
            //
        } catch (NotEnoughBeansException e) {
            fail("Not enough beans exception");
        }
    }

    @Test
    public void testPourCoffeeNoCupsNotStale(){
        try {
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            //;
        } catch (StaleCoffeeException e) {
            fail("Stale coffee exception");
        }

    }
    @Test
    public void testPourCoffeeHaveCupsIsStale() throws NotEnoughBeansException, TooManyBeansException, WaterException {
        try {
            coffeeMaker.brew(2.5,15);
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            fail("no cups exception");
        } catch (StaleCoffeeException e) {
            //
        }

    }

    @Test
    public void testPourCoffeeNoCupsIsStale(){
        try {
            coffeeMaker.pourCoffee();
        } catch (NoCupsRemainingException e) {
            //
        } catch (StaleCoffeeException e) {
            fail("Stale coffee exception");
        }

    }
}
