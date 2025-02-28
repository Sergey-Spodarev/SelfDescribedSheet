package org.example;

import collections.MyList;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<>();
        integerMyList.add(12);
        System.out.println("Добавили в лист значение 12");
        integerMyList.add(24);
        System.out.println("Добавили в лист значение 24");
        integerMyList.add(36);
        System.out.println("Добавили в лист значение 36");
        System.out.println("Так выглядит саморализованный лит: ");
        for (int i = 0; i < integerMyList.getSize(); i++) {
            System.out.print(integerMyList.getByIndex(i) + " ");
        }
        System.out.println();
        System.out.println("Получим эллемент под индексом 1 = " + integerMyList.getByIndex(1));
        System.out.println("Удалим значение под индексом 1");
        integerMyList.delByIndex(1);
        System.out.println("Вот как теперь выглядит саморализованный лит: ");
        for (int i = 0; i < integerMyList.getSize(); i++) {
            System.out.print(integerMyList.getByIndex(i) + " ");
        }
        System.out.println();
    }
}