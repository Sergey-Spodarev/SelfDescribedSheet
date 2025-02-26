package org.example;

import collections.MyList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип данных:" +
                "1. Integer" +
                "2. String" +
                "3. Double" +
                "Введите номер: ");
        int typeChoice = scanner.nextInt();
        scanner.nextLine();
        MyList<?> myList = null;
        switch (typeChoice) {
            case 1:
                myList = new MyList<Integer>();
                System.out.println("Создан список для Integer.");
                break;
            case 2:
                myList = new MyList<String>();
                System.out.println("Создан список для String.");
                break;
            case 3:
                myList = new MyList<Double>();
                System.out.println("Создан список для Double.");
                break;
            default:
                System.out.println("Неверный выбор. Программа завершена.");
                return;
        }
    }
}