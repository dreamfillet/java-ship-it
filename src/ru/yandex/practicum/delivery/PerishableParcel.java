package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{
    private final static int BASE_PRICE = 3;
    private int timeToLive;
    private int currentDay;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive, int currentDay) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
        this.currentDay = currentDay;
    }

    public PerishableParcel(int weight){
        super(weight);
    }

    public PerishableParcel(int sendDay, int timeToLive, int currentDay) {
        super(sendDay);
        this.timeToLive = timeToLive;
        this.currentDay = currentDay;
    }


    @Override
    int getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    void deliver() {
        if (isExpired(currentDay)) {
            System.out.println("Доставка невозможна: посылка испортилась!");
        }
        else {
            System.out.println("Посылка " + getDescription() + " доставлена по адресу " + getDeliveryAddress());
        }
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight()*BASE_PRICE;
    }

    public boolean isExpired(int currentDay){
        if(getSendDay() + getTimeToLive() >= getCurrentDay()){
            return false;
        }
        else {
            return true;
        }
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public int getCurrentDay() {
        return currentDay;
    }

}
