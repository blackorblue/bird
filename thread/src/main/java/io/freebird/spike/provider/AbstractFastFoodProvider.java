package io.freebird.spike.provider;


import io.freebird.util.CollectionUtils;
import io.freebird.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author freebird
 * @date 2020/4/19 17:17
 */
public abstract class AbstractFastFoodProvider implements FastFoodProvider {
    private final List<Food> foodList = new ArrayList<>();
    private final BigDecimal totalAmount = new BigDecimal("0");


    public void addFood(Food food) {
        foodList.add(food);
        addPrice(food.getPrice());
    }

    private void addPrice(String price) {
        if (StringUtils.isEmpty(price)) {
            throw new IllegalArgumentException("the input price is not correct");
        }
        totalAmount.add(new BigDecimal(price));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Food getFood() {
        if (CollectionUtils.isEmpty(foodList)) {
            throw new RuntimeException("已经被抢光了！请下次再来");
        }
        Food food = foodList.remove(0);
        return food;
    }

    public boolean isSellOut() {
        if (CollectionUtils.isNotEmpty(foodList)) {
            return false;
        }
        return true;
    }
}
