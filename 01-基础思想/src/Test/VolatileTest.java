package Test;

public class VolatileTest {
    private static volatile VolatileTest instance = null;

    private VolatileTest(){}

    public static VolatileTest getInstance(){
        if(instance == null){
            instance = new VolatileTest();
        }

        return instance;
    }

    public static void main(String[] args) {
        VolatileTest.getInstance();
    }
}
