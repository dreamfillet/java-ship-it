package ru.yandex.practicum.delivery;

public class FragileParcel extends  Parcel implements  Truckable{
    private final static int BASE_PRICE = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    public FragileParcel(int weight) {
        super( weight);
    }

    @Override
    int getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    void packageItem() {
        System.out.println("Посылка " + getDescription() + " обёрнута в защитную плёнку");
        System.out.println("Посылка " + getDescription() + " упакована");
    }

    @Override
    void deliver() {
        System.out.println("Посылка " + getDescription() + " доставлена по адресу " + getDeliveryAddress());
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight()*BASE_PRICE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + getDescription() + " изменила местоположение на " + newLocation);
    }
}
