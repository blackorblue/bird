package io.freebird.spike.consumer;


import io.freebird.spike.provider.FastFoodProvider;

/**
 * @author freebird
 * @date 2020/4/19 17:36
 */
public class FastFoodConsumer {

    private String name;

    public FastFoodConsumer(String name) {
        this.name = name;
    }

    public boolean consume(FastFoodProvider provider) {
        // 客户下单成功
        if (provider.getFood() == null) {
            return false;
        }
        System.out.println(Thread.currentThread().getName()+"=======用户" + this.getName() + "消费成功！");
        return true;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "FastFoodConsumer{" +
                "name='" + name + '\'' +
                '}';
    }
}
