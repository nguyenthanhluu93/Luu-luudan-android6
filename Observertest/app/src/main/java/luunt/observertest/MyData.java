package luunt.observertest;

import java.util.Observable;

/**
 * Created by User on 1/11/2017.
 */

public class MyData extends Observable {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }
}
