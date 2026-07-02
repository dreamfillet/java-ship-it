package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {

    @Test
    public void testStandardParcelCost() {
        StandardParcel parcel = new StandardParcel(5);
        int actualCost = parcel.calculateDeliveryCost();
        int expectedCost = 10;
        assertEquals(expectedCost, actualCost);
    }

    @Test
    public void testFragileParcelCost() {
        FragileParcel parcel = new FragileParcel(6);
        int actualCost = parcel.calculateDeliveryCost();
        int expectedCost = 24;
        assertEquals(expectedCost, actualCost);
    }

    @Test
    public void testPerishableParcelCost() {
        PerishableParcel parcel = new PerishableParcel(7);
        int actualCost = parcel.calculateDeliveryCost();
        int expectedCost = 21;
        assertEquals(expectedCost, actualCost);
    }

    @Test
    public void negativeTestIsExpired(){
        PerishableParcel parcel = new PerishableParcel(1,9,8);
        boolean actualStatus = parcel.isExpired(8);
        boolean expectedStatus = false;
        assertEquals(expectedStatus, actualStatus);
        if (expectedStatus == false){
            System.out.println("Посылка не испорчена");
        }
    }

    @Test
    public void positiveTestIsExpired(){
        PerishableParcel parcel = new PerishableParcel(1,5,8);
        boolean actualStatus = parcel.isExpired(8);
        boolean expectedStatus = true;
        assertEquals(expectedStatus, actualStatus);
        if (expectedStatus == true){
            System.out.println("Посылка испорчена");
        }
    }

    @Test
    public void positiveTestAddInBox(){
        ParcelBox box = new ParcelBox(10);
        box.addParcel(new StandardParcel(5));
        assertEquals(5, box.getCurrentWeight());
    }

    @Test
    public void negativeTestAddInBox(){
        ParcelBox box = new ParcelBox(10);
        box.addParcel(new StandardParcel(5));
        box.addParcel(new StandardParcel(6));
        assertEquals(5, box.getCurrentWeight());
    }
}
