package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firms = {"Samsung", "Xiaomi", "Huawei" };
        Object[][] watch = {
                {firms[0], "Galaxy 5", " Galaxy Pro 4" },
                {firms[1], "Redmi 3", "GS Pro", "Smart Band 8" },
                {firms[2], "4 PRO", "Buds", "GT4" }
        };
        ArrayList<String[]> buyers = new ArrayList<>();

        while (true) {
            // Ввод ФИО, email и номера телефона
            System.out.println("Введите ФИО:");
            String fullName = scanner.nextLine();
            System.out.println("Введите email:");
            String email = scanner.nextLine();
            System.out.println("Введите номер телефона:");
            String phoneNumber = scanner.nextLine();

            // Выбор фирмы
            System.out.println("Выберите фирму:");
            for (int i = 0; i < firms.length; i++) {
                System.out.println((i + 1) + ". " + firms[i]);
            }
            int firmChoice;
            do {
                try {
                    firmChoice = Integer.parseInt(scanner.nextLine()) - 1;
                    if (firmChoice < 0 || firmChoice >= firms.length) {
                        System.out.println("Пожалуйста, введите корректный номер фирмы.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                }
            } while (true);

            // Выбор товара и количества
            System.out.println("Доступные товары для фирмы " + firms[firmChoice] + ":");
            for (int j = 0; j < watch[firmChoice].length; j++) {
                System.out.print((j + 1) + ". " + watch[firmChoice][j]);
                if (j < watch[firmChoice].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\nВведите номер товара:");
            int watchChoice;
            do {
                try {
                    watchChoice = Integer.parseInt(scanner.nextLine()) - 1;
                    if (watchChoice < 0 || watchChoice >= watch[firmChoice].length) {
                        System.out.println("Некорректный выбор товара. Пожалуйста, введите корректный номер.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                }
            } while (true);

            String selectedWatchModel = (String) watch[firmChoice][watchChoice];

            System.out.println("Введите количество:");
            int quantity = Integer.parseInt(scanner.nextLine());

            if (quantity > 10) {
                System.out.println("Извините, такого количества нет");
                quantity = 10;
            }

            // Создание массива с информацией о покупателе
            String[] buyerDetails = {fullName, email, phoneNumber,
                    (String) watch[firmChoice][0], selectedWatchModel, String.valueOf(quantity)};

            // Добавление информации о покупателе в список
            buyers.add(buyerDetails);

            //Вывод всех заказов
            System.out.println("Заказы покупателей:");
            for (String[] buyer : buyers) {
                System.out.println("Покупатель: " + buyer[0]);
                System.out.println("Email: " + buyer[1]);
                System.out.println("Номер телефона: " + buyer[2]);
                System.out.println("Товар: " + buyer[4] + " - " + buyer[3]);
                System.out.println("Количество: " + buyer[5]);
                System.out.println();
            }

            //Выход из программы или продолжение работы
            System.out.println("Введите ваш выбор: exit- закончить программу, " +
                    "clear - очистить список покупателей и сделать заказ, next - сделать еще заказ");
            String EnterAndExit = scanner.nextLine();
            if (EnterAndExit.equalsIgnoreCase("exit")) {
                break;
            } else if (EnterAndExit.equalsIgnoreCase("clear")) {
                buyers.clear();
                continue;
            }
            else if (EnterAndExit.equalsIgnoreCase("next")) {
                continue;
            }
        }
    }
}