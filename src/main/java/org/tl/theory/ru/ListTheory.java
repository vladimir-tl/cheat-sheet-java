package org.tl.theory.ru;

import java.util.ArrayList;
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
 *   2. List<String> names = new ArrayList<>(): что слева и что справа
 *   3. Неизменяемый список: List.of
 *
 * Работа с элементами
 *   4. Добавить, получить, размер, пустой ли: add, get, size, isEmpty
 *   5. Изменить и удалить: set, remove, clear
 *   6. Поиск: contains, indexOf
 *   7. Сортировка: Collections.sort, reverse, max, min
 *
 * Ловушки
 *   8. remove(int) или remove(Object)?
 *   9. IndexOutOfBoundsException
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
     * 2. List<String> names = new ArrayList<>(): что слева и что справа
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
     * 3. Неизменяемый список: List.of
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
     * 4. Добавить, получить, размер, пустой ли: add, get, size, isEmpty
     *
     * add(x) добавляет в конец. add(index, x) вставляет по индексу и сдвигает остальные вправо.
     * get(index) возвращает элемент. size() это количество элементов.
     */
    static void basics() {
        List<String> names = new ArrayList<>();

        names.add("Anna");     // [Anna]
        names.add("Bob");      // [Anna, Bob]
        names.add(0, "Eve");   // [Eve, Anna, Bob]

        names.get(0);          // "Eve"
        names.size();          // 3
        names.isEmpty();       // false
    }

    /**
     * 5. Изменить и удалить: set, remove, clear
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
     * 6. Поиск: contains, indexOf
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
     * 7. Сортировка: Collections.sort, reverse, max, min
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
     * 8. remove(int) или remove(Object)?
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
     * 9. IndexOutOfBoundsException
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
