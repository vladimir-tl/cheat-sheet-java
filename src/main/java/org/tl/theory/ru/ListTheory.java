package org.tl.theory.ru;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ТЕОРИЯ: List
 *
 * Короткие примеры. Скопируйте любой из них в метод main и запустите.
 *
 * Содержание
 *
 * Создание списка
 *   1. Что такое List
  2. Создание списка: четыре способа
 *   3. List<String> names = new ArrayList<>(): что слева и что справа
 *   4. Неизменяемый список: List.of
 *
 * Работа с элементами
 *   5. Добавить, получить, размер, пустой ли: add, get, size, isEmpty
 *   6. Изменить и удалить: set, remove, clear
 *   7. Поиск: contains, indexOf
 *   8. Сортировка: Collections.sort, reverse, max, min
 *
 * Ловушки
 *   9. remove(int) или remove(Object)?
 *   10. IndexOutOfBoundsException
 *
 * Практика: см. org.tl.collections.list (ListCheatSheet, ListTasks, ListSolutions).
 */
public class ListTheory {

    /**
     * 1. Что такое List
     *
     * List это упорядоченная коллекция, в которой могут быть дубликаты. У каждого элемента
     * есть индекс, начиная с 0. В отличие от массива, List может расти и уменьшаться.
     *
     * Размер: у массива .length, у List .size().
     * Элементы это объекты: List<Integer>, а не List<int> (см. PrimitivesAndWrappersTheory).
     */
    static void whatIsList() {
        // ["Anna", "Bob", "Anna"]
        //    0       1      2      <- индексы
    }

    /**
     * 2. Создание списка: четыре способа
     *
     * Представьте список как бумажный список покупок: можно дописывать строки и вычёркивать их.
     * Получить его можно четырьмя способами:
     *   - Пустой, заполнить позже: new ArrayList<>(). Как новая пустая тетрадь.
     *   - С начальными элементами, и потом его можно менять: new ArrayList<>(List.of(...)).
     *     List.of(...) даёт только начальные элементы; ArrayList копирует их в список, который можно менять.
     *   - С элементами, которые НЕЛЬЗЯ менять: List.of(...). Подходит для данных, которые не меняются.
     *   - Из массива: new ArrayList<>(Arrays.asList(array)).
     *
     * Какой выбрать? Если потом будете добавлять или удалять элементы: первый, второй или четвёртый.
     * Если данные фиксированы: List.of.
     */
    static void creating() {
        // 1. Пустой
        List<String> empty = new ArrayList<>();                          // []

        // 2. С элементами, изменяемый
        List<String> fruits = new ArrayList<>(List.of("apple", "pear")); // [apple, pear]
        fruits.add("plum");                                              // [apple, pear, plum]

        // 3. С элементами, НЕизменяемый
        List<String> days = List.of("Mon", "Tue");                       // [Mon, Tue]
        // days.add("Wed");                                              // UnsupportedOperationException

        // 4. Из массива
        String[] array = {"a", "b", "c"};
        List<String> fromArray = new ArrayList<>(Arrays.asList(array));  // [a, b, c]
    }

    /**
     * 3. List<String> names = new ArrayList<>(): что слева и что справа
     *
     *   List<String>      - ТИП переменной (левая часть).
     *                       List это интерфейс: он описывает только ЧТО умеет список
     *                       (add, get, remove...), но не КАК он хранится.
     *                       <String> говорит, что в списке лежат строки.
     *   names             - имя переменной.
     *   new ArrayList<>() - сам ОБЪЕКТ, созданный в памяти (правая часть).
     *                       ArrayList это класс, реализующий List: внутри он хранит
     *                       элементы в массиве и знает КАК выполнять все операции.
     *   <>                - «ромбовидный оператор» (diamond): компилятор сам определяет <String> по левой части.
     *
     * Написать new List<>() нельзя: у интерфейса нельзя создать экземпляр.
     *
     * Почему не ArrayList<String> names = new ArrayList<>()? Это работает, но если объявить
     * переменную как List, реализацию можно потом заменить (например, на new LinkedList<>()),
     * изменив только правую часть. Остальной код использует только методы List и остаётся
     * прежним. Та же идея для методов: принимайте List<String> в параметре,
     * а не ArrayList<String>.
     *
     * ArrayList: хранит элементы в массиве; быстрый get по индексу, вставка и удаление
     * в середине медленнее. Выбор по умолчанию.
     */
    static void listVsArrayList() {
        List<String> names = new ArrayList<>(); // пустой список
    }

    /**
     * 4. Неизменяемый список: List.of
     *
     * List.of(...) создаёт список, который нельзя менять. add, remove, set и sort
     * бросают UnsupportedOperationException.
     *
     * Нужен изменяемый список? Скопируйте его: new ArrayList<>(List.of(...)).
     */
    static void immutable() {
        List<String> fixed = List.of("Anna", "Bob");
        // fixed.add("Eve"); // UnsupportedOperationException

        List<String> changeable = new ArrayList<>(List.of("Anna", "Bob"));
        changeable.add("Eve"); // OK -> [Anna, Bob, Eve]
    }

    /**
     * 5. Добавить, получить, размер, пустой ли: add, get, size, isEmpty
     *
     * Список растёт сам: достаточно вызвать add. Не нужно выбирать размер и копировать.
     *   - add(x): положить x в КОНЕЦ списка.
     *   - add(index, x): положить x на это место; всё, что после него, сдвигается на шаг вправо.
     *   - addAll(other): добавить в конец все элементы другого списка.
     * get(index) возвращает элемент по индексу. size() это количество элементов.
     * isEmpty() истинно, когда в списке ничего нет.
     */
    static void basics() {
        List<String> names = new ArrayList<>();

        names.add("Anna");     // [Anna]
        names.add("Bob");      // [Anna, Bob]
        names.add(0, "Eve");   // [Eve, Anna, Bob]: Eve впереди, остальные сдвинулись вправо
        names.addAll(List.of("Tom", "Kate")); // [Eve, Anna, Bob, Tom, Kate]

        names.get(0);          // "Eve"
        names.size();          // 5
        names.isEmpty();       // false
    }

    /**
     * 6. Изменить и удалить: set, remove, clear
     *
     * set(index, x) заменяет элемент и возвращает старый. remove(index) удаляет элемент
     * и сдвигает остальные влево. remove("value") удаляет первое совпадение. clear() удаляет всё.
     */
    static void changeAndRemove() {
        List<String> names = new ArrayList<>(List.of("Eve", "Anna", "Bob"));

        names.set(1, "Alex");  // [Eve, Alex, Bob]
        names.remove(0);       // по индексу -> [Alex, Bob]
        names.remove("Bob");   // по значению -> [Alex]
        names.clear();         // []
    }

    /**
     * 7. Поиск: contains, indexOf
     *
     * contains(x) истинно, если элемент есть в списке. indexOf(x) это индекс первого
     * совпадения или -1, если его нет. lastIndexOf(x) это индекс последнего совпадения.
     */
    static void searching() {
        List<String> names = new ArrayList<>(List.of("Anna", "Bob", "Anna"));

        names.contains("Bob");      // true
        names.indexOf("Anna");      // 0
        names.lastIndexOf("Anna");  // 2
        names.indexOf("Zed");       // -1: не найден
    }

    /**
     * 8. Сортировка: Collections.sort, reverse, max, min
     *
     * В классе Collections есть вспомогательные методы для списков. Им нужен изменяемый
     * список (не List.of): sort и reverse меняют сам список.
     */
    static void sorting() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 1, 2));

        Collections.sort(numbers);          // [1, 2, 3]
        Collections.reverse(numbers);       // [3, 2, 1]
        Collections.max(numbers);           // 3
        Collections.min(numbers);           // 1
    }

    /**
     * 9. remove(int) или remove(Object)?
     *
     * Ловушка со списком List<Integer>. У списка два метода с именем remove:
     * remove(int index) и remove(Object value). С обычным числом Java выбирает индекс.
     */
    static void removeTrap() {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30));

        list.remove(1);                    // индекс 1 -> удаляет 20 -> [10, 30]
        list.remove(Integer.valueOf(10));  // ЗНАЧЕНИЕ 10 -> [30]
    }

    /**
     * 10. IndexOutOfBoundsException
     *
     * У списка размера n индексы 0 .. n-1. Любой другой индекс бросает исключение.
     * Последний элемент это list.get(list.size() - 1).
     */
    static void indexTrap() {
        List<String> names = new ArrayList<>(List.of("Anna", "Bob", "Eve"));

        names.get(2);                   // "Eve", последний
        names.get(names.size() - 1);    // "Eve", то же самое
        // names.get(3);                // IndexOutOfBoundsException: Index 3 out of bounds for length 3
        // new ArrayList<String>().get(0); // то же для пустого списка
    }
}
