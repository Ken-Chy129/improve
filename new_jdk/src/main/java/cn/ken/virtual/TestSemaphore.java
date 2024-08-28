package cn.ken.virtual;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Ken-Chy129
 * @date 2024/8/17
 */
public class TestSemaphore {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(10);
        // ......
        Executors.newVirtualThreadPerTaskExecutor().submit(() -> {
            try {
                // 执行任务前信号量-1，表示多了一个并发线程在执行了，剩下的可同时执行数量减少
                // 如果信号量（许可证）为0，则阻塞直到有其他线程执行完成释放许可证
                sem.acquire();
                doSomething();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                // 执行完任务后信号量+1
                sem.release();
            }
        });
    }

    private static void doSomething() {

    }
}
