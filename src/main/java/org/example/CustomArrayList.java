package org.example;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Кастомная реализация ArrayList-а
 */
public class CustomArrayList<T> {
    /**
     * Массив на котором основывается Лист
     */
    private T[] array;
    /**
     * Статическая константа указывающая изначальную емкостью листа
     */
    private static final int CAPACITY = 10;
    /**
     * Статическая константа указывающая множитель на который будет умножаться текущий размер листа при его переполнении
     */
    private static final int MULTIPLIER = 2;
    /**
     * поле указывающие текущий крайний индекс, изначально равен 0
     */
    private int currentIndex = 0;

    /**
     * Создает пустой список с начальной емкостью CAPACITY
     */
    public CustomArrayList() {
        this.array = (T[]) new Object[CAPACITY];
    }

    /**
     * Создает пустой список с начальной емкостью capacity
     *
     * @param capacity заданная начальная емкость списка
     * @throws IllegalArgumentException - если указанная начальная емкость неверна
     */
    public CustomArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер указан неверно: " + capacity);
        }
        this.array = (T[]) new Object[capacity];
    }

    /**
     * Возвращает количество элементов в списке
     *
     * @return - количество элементов в списке
     */
    public int size() {
        return currentIndex;
    }

    /**
     * Добавляет указанный элемент в конец списка
     *
     * @param element - элемент для добавления в список
     */
    public void add(T element) {
        if (currentIndex < Integer.MAX_VALUE) {
            if (currentIndex >= array.length) {
                increaseArray();
            }
            array[currentIndex] = element;
            currentIndex++;
        }
    }

    /**
     * Возвращает элемент на позиции в списке
     *
     * @param index - индекс искомого элемента
     * @return - элемент на позиции в этом списке
     * @throws IndexOutOfBoundsException - ошибка если индекс будет неверным
     */
    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    /**
     * Вставляет элемент на указанную позицию в списке
     * Смещает элемент находящийся в этой позиции вправо
     * Если вставить в последнюю позицию списка то добавление произойдет в конец списка
     *
     * @param index - индекс для вставки
     * @param element - элемент для вставки
     * @throws IndexOutOfBoundsException - ошибка если индекс будет неверным
     */
    public void set(int index, T element) {
        if (index == currentIndex) {
            add(element);
            return;
        }
        checkIndex(index);
        if (currentIndex + 1 >= array.length) {
            increaseArray();
        }
        System.arraycopy(array, index, array, index + 1, currentIndex - index);
        array[index] = element;
        currentIndex++;
    }

    /**
     * Заменяет элемент в позиции в списке новым элементом
     *
     * @param index - индекс элемента
     * @param element - элемент для замены
     * @throws IndexOutOfBoundsException - ошибка если индекс будет неверным
     */
    public void replace(int index, T element) {
        checkIndex(index);
        array[index] = element;
    }

    /**
     * Удаляет элемент в указанной позиции в списке
     * Смещает все последующие элементы влево
     *
     * @param index - индекс удаляемого элемента
     * @throws IndexOutOfBoundsException - ошибка если индекс будет неверным
     */
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, currentIndex - index - 1);
        currentIndex--;
        array[currentIndex] = null;
    }

    /**
     * Удаляет первое вхождение элемента из списка
     *
     * @param removedElement - элемент который необходимо удалить из списка если он есть
     */
    public void remove(T removedElement) {
        if (removedElement == null) {
            for (int i = 0; i < currentIndex; i++) {
                if (array[i] == null) {
                    remove(i);
                    break;
                }
            }
        } else {
            for (int i = 0; i < currentIndex; i++) {
                if (removedElement.equals(array[i])) {
                    remove(i);
                    break;
                }
            }
        }

    }

    /**
     * Удаляет все элементы из списка
     */
    public void removeAll() {
        Arrays.fill(array, null);
        currentIndex = 0;
    }

    /**
     * Сортирует список в соответствии с порядком установленным компаратором
     *
     * @param comparator - используется для сравнения элементов списка
     * @throws NullPointerException - ошибка если список содержит null
     */
    public void sort(Comparator<? super T> comparator) {
        quickSort(0, currentIndex - 1, comparator);
    }

    /**
     * Реализация быстрой сортировки
     *
     * @param low - нижняя граница массива
     * @param high - верхеняя граница массива
     * @param comparator - используется для сравнения элементов списка
     * @throws NullPointerException - ошибка если список содержит null
     */
    private void quickSort(int low, int high, Comparator comparator) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        T opor = array[middle];

        int leftBound = low;
        int rightBound = high;
        while (leftBound <= rightBound) {
            while (comparator.compare(array[leftBound], opor) < 0) {
                leftBound++;
            }
            while (comparator.compare(array[rightBound], opor) > 0) {
                rightBound--;
            }
            if (leftBound <= rightBound) {
                T temp = array[leftBound];
                array[leftBound] = array[rightBound];
                array[rightBound] = temp;
                leftBound++;
                rightBound--;
            }
        }
        if (low < rightBound) {
            quickSort(low, rightBound, comparator);
        }
        if (high > leftBound) {
            quickSort(leftBound, high, comparator);
        }
    }

    /**
     * Увеличить размер базового массива вдвое
     * Создать новый массив с новой емкостью и копирует все элементы в новый увеличенный массив
     */
    private void increaseArray() {
        long newCapacity = (long) array.length * MULTIPLIER;

        if (newCapacity > Integer.MAX_VALUE) {
            newCapacity = Integer.MAX_VALUE;
        }

        T[] newArray = (T[]) new Object[(int) newCapacity];
        System.arraycopy(this.array, 0, newArray, 0, array.length);
        this.array = newArray;
    }

    /**
     * Метод для проверки коректности индекса
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= currentIndex) {
            throw new IndexOutOfBoundsException(String.format("Индекс: %d, Размер: %d", index, currentIndex));
        }
    }

    /**
     * Переопределенный метод toString для возвращения всеего листа в виде строки
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, currentIndex));
    }
}
