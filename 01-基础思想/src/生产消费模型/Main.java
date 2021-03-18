package 生产消费模型;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        new Thread(new Producer(storage), "生产者线程").start();
        new Thread(new Consumer(storage), "消费者线程").start();

    }
}
