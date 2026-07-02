package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel>{
    private List<T> parcels;
    private int maxWeight;
    private int currentWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
        this.parcels = new ArrayList<>();
    }

    public void addParcel(T parcel){
        if(currentWeight + parcel.getWeight()<=maxWeight){
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
            System.out.println("Посылка добавлена в коробку");
        }
        else {
            System.out.println("Превышение максимального веса. Посылка не может быть добавлена в коробку");
        }
    }

    public int getCurrentWeight() {
        return currentWeight;
    }
}

