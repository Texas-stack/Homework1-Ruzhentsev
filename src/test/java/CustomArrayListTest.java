import org.example.CustomArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Тесты для класса CustomArrayList.
 */
public class CustomArrayListTest {

    /**
     * Тест на добавление элементов и проверку размера списка.
     */
    @Test
    public void testAddAndSize() {
        CustomArrayList<Object> list = new CustomArrayList<>();
        list.add(1);
        list.add(2.5);
        list.add("Hello");

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2.5, list.get(1));
        assertEquals("Hello", list.get(2));
    }

    /**
     * Тест на добавление элемента по индексу.
     */
    @Test
    public void testAddByIndex() {
        CustomArrayList<Object> list = new CustomArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add(1, 5); // Adding an integer at index 1
        list.add(2, 3.14); // Adding a double at index 2

        assertEquals(4, list.size());
        assertEquals("apple", list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(3.14, list.get(2));
        assertEquals("banana", list.get(3));
    }

    /**
     * Тест на получение элементов из списка.
     */
    @Test
    public void testGet() {
        CustomArrayList<Object> list = new CustomArrayList<>();
        list.add(42); // Добавляем целое число
        list.add("Hello"); // Добавляем строку

        assertEquals(42, list.get(0));
        assertEquals("Hello", list.get(1));
    }

    /**
     * Тест на удаление элемента.
     */
    @Test
    public void testRemove() {
        CustomArrayList<Object> list = new CustomArrayList<>();
        list.add("apple");
        list.add(3.14);
        list.add("banana");

        list.remove(1);

        assertEquals(2, list.size());
        assertEquals("apple", list.get(0));
        assertEquals("banana", list.get(1));
    }

    /**
     * Тест на очистку списка.
     */
    @Test
    public void testClear() {
        CustomArrayList<Object> list = new CustomArrayList<>();
        list.add(1);
        list.add("apple");

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        list.add(3.14);

        assertEquals(1, list.size());
        assertEquals(3.14, list.get(0));
    }

    /**
     * Тест на сортировку с использованием компаратора.
     */
    @Test
    public void testSortWithComparator() {
        // Тест для Integer
        CustomArrayList<Integer> list1 = new CustomArrayList<>();
        list1.add(3);
        list1.add(1);
        list1.add(2);
        Comparator<Integer> comparator1 = Comparator.naturalOrder();
        list1.sortWithComparator(comparator1);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, list1.toArray());

        // Тест для String
        CustomArrayList<String> list2 = new CustomArrayList<>();
        list2.add("C");
        list2.add("A");
        list2.add("B");
        Comparator<String> comparator2 = Comparator.naturalOrder();
        list2.sortWithComparator(comparator2);
        Assert.assertArrayEquals(new String[]{"A", "B", "C"}, list2.toArray());
    }

    /**
     * Тест на быструю сортировку с использованием компаратора.
     */
    @Test
    public void testQuickSortWithComparator() {
        // Тест для Integer
        CustomArrayList<Integer> list1 = new CustomArrayList<>();
        list1.add(4);
        list1.add(1);
        list1.add(3);
        Comparator<Integer> comparator1 = Integer::compare;
        list1.quickSort(comparator1);
        assertEquals(1, (int) list1.get(0));
        assertEquals(3, (int) list1.get(1));
        assertEquals(4, (int) list1.get(2));


        // Тест для String
        CustomArrayList<String> list2 = new CustomArrayList<>();
        list2.add("C");
        list2.add("A");
        list2.add("B");
        Comparator<String> comparator2 = String::compareTo;
        list2.quickSort(comparator2);
        assertEquals("A", list2.get(0));
        assertEquals("B", list2.get(1));
        assertEquals("C", list2.get(2));

        // Тест для пользовательского типа данных
        class Person {
            final String name;
            Person(String name) {
                this.name = name;
            }
        }
        CustomArrayList<Person> list3 = new CustomArrayList<>();
        list3.add(new Person("Charlie"));
        list3.add(new Person("Alice"));
        list3.add(new Person("Bob"));
        Comparator<Person> comparator3 = Comparator.comparing(person -> person.name);
        list3.quickSort(comparator3);
        assertEquals("Alice", list3.get(0).name);
        assertEquals("Bob", list3.get(1).name);
        assertEquals("Charlie", list3.get(2).name);
    }

}