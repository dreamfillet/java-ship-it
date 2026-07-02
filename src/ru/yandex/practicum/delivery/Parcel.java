package ru.yandex.practicum.delivery;

abstract class Parcel {
    private String description;
    private final int weight;
    private String deliveryAddress;
    private int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public Parcel(int weight){
        this.weight = weight;
    }


    void packageItem() {
        System.out.println("Посылка " + getDescription() + " упакована");
    }


    abstract void deliver();

    abstract int calculateDeliveryCost();

    abstract int getBasePrice();

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    @Override
    public String toString() {
        return "Посылка:" +
                " описание= " + getDescription() +
                ", вес= " + getWeight() +
                ", адрес доставки= " + getDeliveryAddress()  +
                ", день отправки= " + getSendDay();
    }
}
