package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Класс, представляющий список.
 */
public class CustomArrayList {

    /** Список элементов */
    public final ArrayList<Object> list;

    /**
     * Конструктор по умолчанию, инициализирует пустой список.
     */
    public CustomArrayList() {
        this.list = new ArrayList<>();
    }

    /**
     * Добавляет элемент в список.
     *
     * @param element Элемент для добавления.
     */
    public void add(Object element) {
        list.add(element);
    }

    /**
     * Добавляет несколько элементов в список.
     *
     * @param elements Строка с элементами, разделенными запятой.
     */
    public void addMultipleElements(String elements) {
        String[] elementsArray = elements.split(",\\s*");
        Collections.addAll(list, elementsArray);
    }

    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index   Индекс для добавления.
     * @param element Элемент для добавления.
     */
    public void add(int index, Object element) {
        list.add(index, element);
    }

    /**
     * Получает элемент по индексу.
     *
     * @param index Индекс элемента.
     * @return Элемент по заданному индексу.
     */
    public Object get(int index) {
        return list.get(index);
    }

    /**
     * Удаляет элемент по индексу.
     *
     * @param index Индекс элемента для удаления.
     */
    public void remove(int index) {
        list.remove(index);
    }

    /**
     * Очищает весь список.
     */
    public void clear() {
        list.clear();
    }

    /**
     * Метод для сортировки через компаратор
     */
    public void sort() {
        list.sort(Comparator.comparing(Object::toString));
    }

    /**
     * Выводит список элементов на экран.
     */
    public void displayList() {
        System.out.println("Текущий список:");
        for (Object element : list) {
            System.out.println(element);
        }
    }

    /**
     * Ниже методы для быстрой сортировки списка.
     */
    public void quickSort() {
        quickSort(0, list.size() - 1);
    }

    public void quickSort(int low, int high) {
        if (low < high) {
            Object pivot = list.get(high);
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (((Comparable) list.get(j)).compareTo(pivot) <= 0) {
                    i++;
                    Collections.swap(list, i, j);
                }
            }
            Collections.swap(list, i + 1, high);

            int pi = i + 1;
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }




    /**
     * Основной класс main, где находится userMenu и вызовы всех методов.
     */
    public static void main(String[] args) {
        CustomArrayList customList = new CustomArrayList();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Выберите опцию:");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Добавить сразу несколько элементов (через запятую!)");
            System.out.println("3. Добавить элемент по индексу");
            System.out.println("4. Получить элемент по индексу");
            System.out.println("5. Удалить элемент по индексу");
            System.out.println("6. Очистить список");
            System.out.println("7. Отсортировать список");
            System.out.println("8. Отсортировать список при помощи quicksort");
            System.out.println("9. Вывести список");
            System.out.println("0. Выйти");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Введите элемент для добавления: ");
                    String newElement = scanner.nextLine();
                    customList.add(newElement);
                    break;
                case 2:
                    System.out.print("Введите элементы для добавления через запятую: ");
                    String multipleElements = scanner.nextLine();
                    customList.addMultipleElements(multipleElements);
                    break;
                case 3:
                    System.out.print("Введите индекс для добавления: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите элемент для добавления: ");
                    String newElementAtIndex = scanner.nextLine();
                    customList.add(index, newElementAtIndex);
                    break;
                case 4:
                    System.out.print("Введите индекс для получения элемента: ");
                    int getIndex = Integer.parseInt(scanner.nextLine());
                    System.out.println("Элемент: " + customList.get(getIndex));
                    break;
                case 5:
                    System.out.print("Введите индекс для удаления элемента: ");
                    int removeIndex = Integer.parseInt(scanner.nextLine());
                    customList.remove(removeIndex);
                    break;
                case 6:
                    customList.clear();
                    System.out.println("Список очищен.");
                    break;
                case 7:
                    customList.sort();
                    System.out.println("Список отсортирован.");
                    break;
                case 8:
                    //Здесь вызови функцию quicksort
                    customList.quickSort();
                    System.out.println("Список отсортирован при помощи quicksort.");
                    break;
                case 9:
                    customList.displayList();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Некорректная опция. Попробуйте снова.");
            }
        }

        System.out.println("Работа программы завершена.");
    }
}