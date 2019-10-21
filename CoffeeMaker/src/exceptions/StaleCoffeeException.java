package exceptions;

public class StaleCoffeeException extends Exception {

    int time;

    public StaleCoffeeException(int time){
        super(time + " is too old.");
        this.time = time;
    }


}
