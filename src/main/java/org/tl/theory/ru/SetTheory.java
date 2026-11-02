package org.tl.theory.ru;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * ТЕОРИЯ: Set и HashSet
 *
 * Короткие примеры. Скопируйте любой из них в метод main и запустите.
 *
 * Содержание
 *
 * Основы
 *   1. Что такое Set
 *   2. Создание множества
 *   3. Добавление: дубликаты игнорируются
 *
 * Работа с элементами
 *   4. Проверка и удаление: contains, remove, size
 *   5. Удаление дубликатов из списка
 *   6. Обход множества циклом
 *
 * Виды Set
 *   7. HashSet, LinkedHashSet, TreeSet
 *
 * Ловушки
 *   8. Нет индекса, нет порядка, equals и hashCode
 *
 * Выбор
 *   9. List, Set или Map?
 *
 * Практика: см. org.tl.collections.set (SetCheatSheet, SetTasks, SetSolutions).
 */
public class SetTheory {

    /**
     * 1. Что такое Set
     *
     * Set это коллекция УНИКАЛЬНЫХ элементов: одно и то же значение в ней может быть только
     * один раз. Она хороша для двух вещей: избавляться от дубликатов и быстро проверять,
     * есть ли значение.
     *
     * Представьте список гостей у входа: имя либо есть в списке, либо нет. Если записать
     * одно имя дважды, ничего не изменится.
     *
     * У Set нет индексов: set.get(0) не существует. HashSet это самый частый вид Set.
     */
    static void whatIsSet() {
        // Добавили: Anna, Bob, Anna, Eve, Bob
        // В множестве: Anna, Bob, Eve   (каждое имя один раз, в любом порядке)
    }

    /**
     * 2. Создание множества
     *
     *   - Пустое, заполнить позже: new HashSet<>().
     *   - Из другой коллекции: new HashSet<>(list). Дубликаты исчезают по пути.
     *   - Фиксированные элементы, которые НЕЛЬЗЯ менять: Set.of(...). Если дать ему
     *     одно значение дважды, он бросит исключение.
     */
    static void creating() {
        // 1. Пустое
        Set<String> names = new HashSet<>();                      // {}

        // 2. Из списка
        List<String> list = List.of("a", "b", "a");
        Set<String> fromList = new HashSet<>(list);               // {a, b}

        // 3. Фиксированное, НЕизменяемое
        Set<String> fixed = Set.of("Mon", "Tue");                 // {Mon, Tue}
        // fixed.add("Wed");                                      // UnsupportedOperationException
        // Set.of("a", "a");                                      // IllegalArgumentException: duplicate element
    }

    /**
     * 3. Добавление: дубликаты игнорируются
     *
     * add(x) кладёт x в множество и возвращает boolean:
     *   true  - значение было новым и добавилось
     *   false - значение уже было, ничего не изменилось
     */
    static void adding() {
        Set<String> names = new HashSet<>();

        names.add("Anna");     // true,  {Anna}
        names.add("Bob");      // true,  {Anna, Bob}
        names.add("Anna");     // false, Anna уже есть: по-прежнему {Anna, Bob}

        System.out.println(names.size());   // 2, а не 3
    }

    /**
     * 4. Проверка и удаление: contains, remove, size
     *
     *   - contains(x): «x есть в множестве?» Работает БЫСТРО, намного быстрее, чем list.contains на большой коллекции.
     *   - remove(x): удаляет x (true, если он был).
     *   - size(): количество элементов.
     *   - isEmpty() и clear(): работают как в List.
     */
    static void checkAndRemove() {
        Set<String> names = new HashSet<>(List.of("Anna", "Bob", "Eve"));

        names.contains("Bob");     // true
        names.contains("Zed");     // false

        names.remove("Bob");       // true,  {Anna, Eve}
        names.remove("Zed");       // false, удалять нечего
        names.size();              // 2

        names.clear();             // {}
        names.isEmpty();           // true
    }

    /**
     * 5. Удаление дубликатов из списка
     *
     * Классическое применение Set. Положите список в HashSet: дубликаты исчезнут.
     * Если снова нужен список, скопируйте множество обратно в ArrayList.
     *
     * Чтобы сохранить исходный порядок первых появлений, используйте LinkedHashSet (см. 7).
     */
    static void removeDuplicates() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3);

        Set<Integer> unique = new HashSet<>(numbers);                    // {1, 2, 3}
        List<Integer> withoutDuplicates = new ArrayList<>(unique);       // [1, 2, 3]

        // Сколько разных значений?
        System.out.println(unique.size());                               // 3

        // Есть ли вообще дубликаты?
        boolean hasDuplicates = numbers.size() != unique.size();         // true
    }

    /**
     * 6. Обход множества циклом
     *
     * У Set нет индексов, поэтому используйте for-each (см. ForTheory).
     * Порядок элементов в HashSet не гарантирован.
     */
    static void looping() {
        Set<String> names = new HashSet<>(List.of("Anna", "Bob", "Eve"));

        for (String name : names) {
            System.out.println(name);      // все три, в любом порядке
        }

        // for (int i = 0; i < names.size(); i++) { names.get(i) }  // не компилируется: нет get(i)
    }

    /**
     * 7. HashSet, LinkedHashSet, TreeSet
     *
     * Все три используются одинаково. Разница в порядке элементов.
     *
     *   HashSet         - порядок не гарантирован. Выбор по умолчанию, самый быстрый.
     *   LinkedHashSet   - сохраняет порядок добавления.
     *   TreeSet         - хранит элементы отсортированными (от A до Z, от меньшего к большему).
     */
    static void kinds() {
        Set<String> hash = new HashSet<>();
        Set<String> linked = new LinkedHashSet<>();
        Set<String> tree = new TreeSet<>();

        // После add("Bob"), add("Anna"), add("Eve"):
        //   HashSet:       любой порядок
        //   LinkedHashSet: [Bob, Anna, Eve]
        //   TreeSet:       [Anna, Bob, Eve]
    }

    /**
     * 8. Нет индекса, нет порядка, equals и hashCode
     *
     * Три вещи, которые нужно помнить.
     *
     * 1) В HashSet нет индекса и нет порядка: нельзя попросить «первый элемент».
     * 2) Множество решает «это то же самое?» через equals() и hashCode(). У String и Integer
     *    они сделаны правильно. Для своих классов нужно написать оба метода, иначе два
     *    «равных» объекта попадут в множество оба.
     * 3) Не меняйте множество во время обхода for-each: будет ConcurrentModificationException.
     *    Используйте Iterator или removeIf (см. ListTheory).
     */
    static void traps() {
        Set<String> names = new HashSet<>();
        names.add("Anna");
        names.add("anna");           // другая строка (регистр важен) -> сохранятся обе
        names.size();                // 2
    }

    /**
     * 9. List, Set или Map?
     *
     *   List - упорядочен, доступ по индексу, дубликаты разрешены.
     *          «Очередь людей»: важны порядок и повторы.
     *   Set  - уникальные элементы, быстрое «есть ли он?», нет индекса.
     *          «Список гостей»: важно только наличие.
     *   Map  - пары ключ -> значение, значение находят по ключу.
     *          «Телефонная книга»: имя -> номер.
     *
     * Технически List и Set относятся к семейству Collection (у них есть add, remove,
     * contains, size). Map это отдельный интерфейс и он не наследует Collection (см. MapTheory).
     */
    static void choosing() {
        List<String> queue = new ArrayList<>();   // порядок и дубликаты важны
        Set<String> guests = new HashSet<>();     // важно только «есть ли здесь это имя?»
    }
}
