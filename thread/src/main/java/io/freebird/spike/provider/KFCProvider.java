package io.freebird.spike.provider;

/**
 * @author freebird
 * @date 2020/4/19 17:15
 */
public class KFCProvider extends AbstractFastFoodProvider {

    @Override
    public Food Create() {
        return new Food("鸡腿堡","12");
    }



}
