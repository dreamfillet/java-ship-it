package ru.yandex.practicum.delivery;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<FragileParcel> trackingParcels = new ArrayList<>();

    private static final List<StandardParcel> box1 = new ArrayList<>();
    private static final List<FragileParcel> box2 = new ArrayList<>();
    private static final List<PerishableParcel> box3 = new ArrayList<>();


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.next());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    showParcels();
                    break;
                case 5:
                    showBoxesInside();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }


    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Изменить адрес хрупкой посылки, поддерживающей трекинг");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Выберите тип посылки:" +
                "стандартная - 1, " +
                "хрупкая - 2, " +
                "скоропортящаяся - 3");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                System.out.println("Введите краткое описание посылки:");
                String description1 = scanner.next();

                System.out.println("Введите вес посылки:");
                int weight1 = scanner.nextInt();

                System.out.println("Введите адрес доставки:");
                String deliveryAddress1 = scanner.next();

                System.out.println("Введите день отправки посылки:");
                int sendDay1 = scanner.nextInt();

                StandardParcel standardParcel = new StandardParcel(description1, weight1, deliveryAddress1, sendDay1);
                allParcels.add(standardParcel);
                System.out.println(standardParcel + " добавлена в общий список");
                box1.add(standardParcel);
                System.out.println(standardParcel + " добавлена в коробку");
                break;
            case 2:
                System.out.println("Введите краткое описание посылки:");
                String description2 = scanner.next();

                System.out.println("Введите вес посылки:");
                int weight2 = scanner.nextInt();

                System.out.println("Введите адрес доставки:");
                String deliveryAddress2 = scanner.next();

                System.out.println("Введите день отправки посылки:");
                int sendDay2 = scanner.nextInt();

                FragileParcel fragileParcel = new FragileParcel(description2, weight2, deliveryAddress2, sendDay2);
                allParcels.add(fragileParcel);
                System.out.println(fragileParcel + " добавлена в общий список");
                trackingParcels.add(fragileParcel);
                System.out.println(fragileParcel + " добавлена в список трекинга");
                box2.add(fragileParcel);
                System.out.println(fragileParcel + " добавлена в коробку");
                break;
            case 3:
                System.out.println("Введите краткое описание посылки:");
                String description3 = scanner.next();

                System.out.println("Введите вес посылки:");
                int weight3 = scanner.nextInt();

                System.out.println("Введите адрес доставки:");
                String deliveryAddress3 = scanner.next();

                System.out.println("Введите день отправки посылки:");
                int sendDay3 = scanner.nextInt();

                System.out.println("Введите срок в днях, за который посылка не испортится:");
                int timeToLive = scanner.nextInt();

                System.out.println("Введите номер текущего дня месяца:");
                int currentDay = scanner.nextInt();

                PerishableParcel perishableParcel = new PerishableParcel(description3, weight3, deliveryAddress3, sendDay3, timeToLive, currentDay);
                allParcels.add(perishableParcel);
                System.out.println(perishableParcel + " добавлена в общий список");
                box3.add(perishableParcel);
                System.out.println(perishableParcel + " добавлена в коробку");
                break;
            default:
                System.out.println("Некорректный номер типа посылки");
                break;
        }

    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int allDeliveriesCostSum = 0;
        for (Parcel parcel : allParcels) {
            allDeliveriesCostSum += parcel.calculateDeliveryCost();
        }
        System.out.println(allDeliveriesCostSum);
    }

    private static void showParcels() {
        System.out.println("Введите адрес новой локации хрупкой посылки:");
        String newLocation = scanner.next();
        for (FragileParcel parcel : trackingParcels) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void showBoxesInside() {
        System.out.println("Введите номер коробки по типу: стандартная - 1, хрупкая - 2, скоропортящаяся - 3");
        int boxNumber = scanner.nextInt();
        switch (boxNumber) {
            case 1:
                for (StandardParcel parcel : box1) {
                    System.out.println(parcel.toString());
                }
                break;
            case 2:
                for (FragileParcel parcel : box2) {
                    System.out.println(parcel.toString());
                }
                break;
            case 3:
                for (PerishableParcel parcel : box3) {
                    System.out.println(parcel.toString());
                }
                break;
            default:
                System.out.println("Введен некорректный номер");
                break;
        }
    }
}

