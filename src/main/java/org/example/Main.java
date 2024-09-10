package org.example;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        CustomArrayList<Integer> integerCustomArrayList = new CustomArrayList<>();

        for(int i = 0; i < 100000; i++) {
            integerCustomArrayList.add(i);
        }

        for(int i = 0; i < integerCustomArrayList.size(); i++) {
            System.out.println(integerCustomArrayList.get(i));
        }

        System.out.println("Размер листа " + integerCustomArrayList.size());
        integerCustomArrayList.removeAll();
        System.out.println("Размер листа после удаления всех элементов " + integerCustomArrayList.size());
        System.out.println("-------------------------------------------");

        for(int i = 0; i < 100000; i++) {
            integerCustomArrayList.add((int) (Math.random() * 100000));
        }

        integerCustomArrayList.sort(Comparator.naturalOrder());
        System.out.println("Отсортированный по возрастанию лист ");

        for(int i = 0; i < integerCustomArrayList.size(); i++) {
            System.out.println(integerCustomArrayList.get(i));
        }

        integerCustomArrayList.sort(Comparator.reverseOrder());
        System.out.println("-------------------------------------------");
        System.out.println("Отсортированный по убыванию лист ");

        for(int i = 0; i < integerCustomArrayList.size(); i++) {
            System.out.println(integerCustomArrayList.get(i));
        }

    }
}