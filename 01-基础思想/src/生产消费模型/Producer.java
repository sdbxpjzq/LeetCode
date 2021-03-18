package 生产消费模型;

public class Producer implements Runnable {
    private Storage storage;

    public Producer(){}

    public Producer(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run(){
        while(true){
            // storage.produce();
        }
    }
}
