package 生产消费模型;

import java.util.LinkedList;

public class Storage {
    // 仓库容量
    private final int MAX_SIZE = 10;
    // 仓库存储的载体
    private final LinkedList<Object> list = new LinkedList<>();


    public void produce() throws InterruptedException {
        synchronized (list) {
            while (list.size() + 1 > MAX_SIZE) {
                System.out.println("【生产者" + Thread.currentThread().getName() + "】仓库已满");
                list.wait();
            }
            list.add(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName() + "】生产一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (list) {
            while (list.size() == 0) {
                System.out.println("【消费者" + Thread.currentThread().getName()
                        + "】仓库为空");
                list.wait();
            }
            list.remove();
            System.out.println("【消费者" + Thread.currentThread().getName() + "】消费一个产品，现库存" + list.size());
            list.notifyAll();
        }
    }
}
