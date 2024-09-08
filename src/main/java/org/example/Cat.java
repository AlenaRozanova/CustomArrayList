package org.example;

import java.util.Comparator;
import java.util.Objects;

/**
 * Тестовый класс Кот
 */
public class Cat {
    int old;
    String name;

    public Cat(int old, String name) {
        this.old = old;
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Comparators {

        public static Comparator<Cat> NAME = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.name.compareTo(o2.name);
            }
        };
        public static Comparator<Cat> OLD = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o1.old - o2.old;
            }
        };
        public static Comparator<Cat> NAMEANDOLD = new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                int i = o1.name.compareTo(o2.name);
                if (i == 0) {
                    i = o1.old - o2.old;
                }
                return i;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cat cat)) return false;
        return old == cat.old && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(old, name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "old=" + old +
                ", name='" + name + '\'' +
                '}';
    }
}
