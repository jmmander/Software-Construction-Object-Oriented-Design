package ui;

import model.Chef;
import model.Sever;
import model.Order;

public class Diner {

    public static void main(String[] args) {
        Sever sever = new Sever();
        Chef chef = new Chef();

        for (int i=0; i < 2 ; i++) {
            System.out.println("Table " + (i + 1) + ":\n");

            sever.greet();
            sever.describeDish();
            Order o = sever.takeOrder();
            chef.makeDish(o);
            System.out.println();

            doOrderRoutine(sever, o);
            System.out.println();
        }

        System.out.println();
        Chef.doDishes();
    }

    private static void doOrderRoutine(Sever e, Order o) {
        System.out.println();
        if (o.isReadyToBeServed())
            e.deliverFood(o);
        if(o.isReadyToBePaid())
            e.takePayment(o);
    }

}
