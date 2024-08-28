package cn.ken.virtual;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CreateVirtualThread {

    public void createByThread() throws InterruptedException {
        // name(String prefix, Integer start) p0:前缀 p1:计数器初始值
        Thread.Builder.OfVirtual virtualThreadBuilder = Thread.ofVirtual().name("worker-", 0);
        Thread worker0 = virtualThreadBuilder.start(this::doSomethings);
        worker0.join();
        System.out.print("finish worker-0 running");
        Thread worker1 = virtualThreadBuilder.start(this::doSomethings);
        worker1.join();
        System.out.print("finish worker-1 running");
    }

    public void createByExecutors() throws ExecutionException, InterruptedException {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<?> submit = executorService.submit(this::doSomethings);
            submit.get();
            System.out.print("finish running");
        }
    }

    public static void main(String[] args) {
        CreateVirtualThread createVirtualThread = new CreateVirtualThread();
    }

    private void doSomethings() {
        System.out.print("hello virtual");
    }
}