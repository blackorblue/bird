package io.freebird.main;

import io.freebird.lock.consumer.FastFoodConsumer;
import io.freebird.lock.provider.AbstractFastFoodProvider;
import io.freebird.lock.provider.Food;
import io.freebird.lock.provider.KFCProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author freebird
 * @date 2020/4/19 17:52
 */
public class BootStrap {

    private final Object lOCK = new Object();


    public static void main(String[] args) {
        BootStrap bootStrap = new BootStrap();
        bootStrap.start();
    }

    private void start() {
        final AbstractFastFoodProvider provider = new KFCProvider();
        // 先生产10个商品
        for (int i = 0; i < 10; i++) {
            Food food = provider.Create();
            provider.addFood(food);
        }
        // 消费
        AtomicInteger threadCount = new AtomicInteger();

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10, (r) -> {
            Thread thread = new Thread(r);
            thread.setName("consumer-" + threadCount.getAndIncrement());
            return new Thread(r);
        });
        AtomicInteger number = new AtomicInteger();
        List<FastFoodConsumer> consumerList = new ArrayList<>();
        // 消费者不断涌入
        CompletableFuture.runAsync(() -> {
            while (true) {
                consumerList.add(new FastFoodConsumer(String.valueOf(number.getAndIncrement())));
            }
        });
        // 统计已消费的名单
        List<FastFoodConsumer> consumedList = new ArrayList<>();
        while (!provider.isSellOut()) {
            // 未售光就提交消费任务
            Runnable task = () -> {
                final FastFoodConsumer consumer = consumerList.get(0);
                if (consumedList.contains(consumer)) {
                    throw new RuntimeException(consumer.toString() + "已经买过了！");
                }
                consumer.consume(provider);
                addConsumed(consumedList, consumer);
            };
            fixedThreadPool.submit(task);
        }
        System.out.println(number);
    }

    private void addConsumed(List<FastFoodConsumer> consumedList, FastFoodConsumer consumer) {
        consumedList.add(consumer);
    }
}
