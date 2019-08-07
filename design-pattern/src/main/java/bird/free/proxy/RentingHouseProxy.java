package bird.free.proxy;

/**
 * 房屋中介对为你进行这些操作
 * 省去了你自己的一些力
 */
public class RentingHouseProxy implements RentingHouse {

    private RentingHouse rentingHouse;
    public RentingHouseProxy(RentingHouse rentingHouse) {
        this.rentingHouse = rentingHouse;
    }

    public void toHouse() {
        rentingHouse.toHouse();
    }

    public void contract() {
        rentingHouse.contract();
    }
}
