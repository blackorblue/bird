package io.freebird.proxy;

public class PersonallyRentingHouse implements RentingHouse {


    public void toHouse() {
        System.out.println("这套房子位于天府新区");
    }

    public void contract() {
        System.out.println("这套房子一年100元...");
    }
}
