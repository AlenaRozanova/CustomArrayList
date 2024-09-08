import org.example.Cat;
import org.example.CustomArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomArrayListTest {

    @Test
    @DisplayName("проверка метода add и size")
    public void addAndSizeTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>();
        Cat cat1 = new Cat(10, "Вася");
        Cat cat2 = new Cat(9, "Муся");
        Cat cat3 = new Cat(11, "Феня");

        catCustomArrayList.add(cat1);
        catCustomArrayList.add(cat2);
        catCustomArrayList.add(cat3);

        Assertions.assertEquals(3, catCustomArrayList.size());
    }

    @Test
    @DisplayName("проверка метода add и get")
    public void addAndGetTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>();
        Cat cat = new Cat(10, "Вася");

        catCustomArrayList.add(cat);
        Assertions.assertEquals(1, catCustomArrayList.size());
        Cat cat1 = catCustomArrayList.get(0);

        Assertions.assertEquals(cat, cat1);
    }

    @Test
    @DisplayName("проверка метода add и remove по индексу")
    public void addAndRemoveIndexTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>();
        Cat cat1 = new Cat(10, "Вася");
        Cat cat2 = new Cat(9, "Муся");
        Cat cat3 = new Cat(11, "Феня");

        catCustomArrayList.add(cat1);
        catCustomArrayList.add(cat2);
        catCustomArrayList.add(cat3);
        Assertions.assertEquals(3, catCustomArrayList.size());
        catCustomArrayList.remove(0);

        Assertions.assertEquals(2, catCustomArrayList.size());
        Assertions.assertEquals(cat2, catCustomArrayList.get(0));
        Assertions.assertEquals(cat3, catCustomArrayList.get(1));
    }

    @Test
    @DisplayName("проверка метода add и remove по элементу")
    public void addAndRemoveElementTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>();
        Cat cat1 = new Cat(10, "Вася");
        Cat cat2 = new Cat(9, "Муся");
        Cat cat3 = new Cat(11, "Феня");

        catCustomArrayList.add(cat1);
        catCustomArrayList.add(cat2);
        catCustomArrayList.add(cat3);
        Assertions.assertEquals(3, catCustomArrayList.size());
        catCustomArrayList.remove(cat2);

        Assertions.assertEquals(2, catCustomArrayList.size());
        Assertions.assertEquals(cat1, catCustomArrayList.get(0));
        Assertions.assertEquals(cat3, catCustomArrayList.get(1));
    }

    @Test
    @DisplayName("проверка метода set")
    public void addAndSetTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>();
        Cat cat1 = new Cat(10, "Вася");
        Cat cat2 = new Cat(9, "Муся");
        Cat cat3 = new Cat(11, "Феня");

        catCustomArrayList.add(cat1);
        catCustomArrayList.add(cat3);
        Assertions.assertEquals(2, catCustomArrayList.size());
        catCustomArrayList.set(0, cat2);

        Assertions.assertEquals(3, catCustomArrayList.size());
        Assertions.assertEquals(cat2, catCustomArrayList.get(0));
        Assertions.assertEquals(cat1, catCustomArrayList.get(1));
        Assertions.assertEquals(cat3, catCustomArrayList.get(2));
    }

    @Test
    @DisplayName("проверка метода insert")
    public void addAndInsetTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>();
        Cat cat1 = new Cat(10, "Вася");
        Cat cat2 = new Cat(9, "Муся");
        Cat cat3 = new Cat(11, "Феня");

        catCustomArrayList.add(cat1);
        catCustomArrayList.add(cat3);
        Assertions.assertEquals(2, catCustomArrayList.size());
        catCustomArrayList.replace(0, cat2);

        Assertions.assertEquals(2, catCustomArrayList.size());
        Assertions.assertEquals(cat2, catCustomArrayList.get(0));
        Assertions.assertEquals(cat3, catCustomArrayList.get(1));
    }

    @Test
    @DisplayName("проверка метода sort")
    public void sortTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>();
        Cat cat1 = new Cat(10, "Вася");
        Cat cat2 = new Cat(9, "Муся");
        Cat cat3 = new Cat(11, "Феня");
        Cat cat4 = new Cat(3, "Маша");
        Cat cat5 = new Cat(2, "Марксик");

        catCustomArrayList.add(cat1);
        catCustomArrayList.add(cat2);
        catCustomArrayList.add(cat3);
        catCustomArrayList.add(cat4);
        catCustomArrayList.add(cat5);
        Assertions.assertEquals(5, catCustomArrayList.size());
        catCustomArrayList.sort(Cat.Comparators.OLD);

        Assertions.assertEquals(5, catCustomArrayList.size());
        Assertions.assertEquals(cat5, catCustomArrayList.get(0));
        Assertions.assertEquals(cat4, catCustomArrayList.get(1));
        Assertions.assertEquals(cat2, catCustomArrayList.get(2));
        Assertions.assertEquals(cat1, catCustomArrayList.get(3));
        Assertions.assertEquals(cat3, catCustomArrayList.get(4));
    }

    @Test
    @DisplayName("проверка метода removeAll")
    public void addAndRemoveAllTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>();
        Cat cat1 = new Cat(10, "Вася");
        Cat cat2 = new Cat(9, "Муся");
        Cat cat3 = new Cat(11, "Феня");

        catCustomArrayList.add(cat1);
        catCustomArrayList.add(cat2);
        catCustomArrayList.add(cat3);
        Assertions.assertEquals(3, catCustomArrayList.size());
        catCustomArrayList.removeAll();

        Assertions.assertEquals(0, catCustomArrayList.size());
    }

    @Test
    @DisplayName("проверка автоматического расширения листа")
    public void catCustomArrayListCustomCapacityTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>(4);
        Cat cat1 = new Cat(10, "Вася");
        Cat cat2 = new Cat(9, "Муся");
        Cat cat3 = new Cat(11, "Феня");
        Cat cat4 = new Cat(3, "Маша");
        Cat cat5 = new Cat(2, "Марксик");

        catCustomArrayList.add(cat1);
        catCustomArrayList.add(cat2);
        catCustomArrayList.add(cat3);
        catCustomArrayList.add(cat4);
        catCustomArrayList.add(cat5);
        Assertions.assertEquals(5, catCustomArrayList.size());
    }

    @Test
    @DisplayName("проверка бросания исключения в случае неверного индекса")
    public void indexOutOfBoundsExceptionTest() {
        CustomArrayList<Cat> catCustomArrayList = new CustomArrayList<>();
        Cat cat = new Cat(10, "Вася");

        catCustomArrayList.add(cat);
        IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class, () -> catCustomArrayList.get(5));

        Assertions.assertTrue(indexOutOfBoundsException.getMessage().contains("Индекс: 5, Размер: 1"));
    }

}
