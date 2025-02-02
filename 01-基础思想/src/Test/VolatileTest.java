package Test;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest {
    private static volatile VolatileTest instance = null;

    private VolatileTest() {
    }

    public static VolatileTest getInstance() {
        if (instance == null) {
            instance = new VolatileTest();
        }

        return instance;
    }

    public static void main(String[] args) {

//        VolatileTest.getInstance();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Object[] array = list.toArray();
        list.toArray(array);
        //红.
    }

}