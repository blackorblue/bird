package io.freebird.provider;

/**
 * @author freebird
 * @date 2020/4/19 17:12
 */
public class Food {

    private String name;
    private String price;

    public Food(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
