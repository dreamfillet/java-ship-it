package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{
    private final static int BASE_PRICE = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    public StandardParcel(int weight) {
        super( weight);
    }

    @Override
    int getBasePrice() {
        return BASE_PRICE;
    }
    @Override
    void deliver() {
        System.out.println("Посылка " + getDescription() + " доставлена по адресу " + getDeliveryAddress());
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight()*BASE_PRICE;
    }

}