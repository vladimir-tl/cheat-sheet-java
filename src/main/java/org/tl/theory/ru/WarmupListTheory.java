package org.tl.theory.ru;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ТЕОРИЯ: Разминка: ArrayList
 *
 * Короткие примеры. Скопируйте любой из них в метод main и запустите.
 *
 * Содержание
 *
 * Основные операции
 *   1. size: сколько элементов
 *   2. get: прочитать элемент по позиции
 *   3. add: добавить элемент в конец
 *   4. Collections.reverse: развернуть тот же список
 *
 * Поиск и изменение
 *   5. contains и indexOf: есть ли элемент и где он
 *   6. remove: по элементу или по позиции
 *   7. set и add(позиция, элемент): заменить и вставить
 *   8. isEmpty: пустой ли список
 *
 * Циклы по списку
 *   9. for-each: пройти по всем элементам
 *   10. Удаление во время цикла
 *
 * Практика: см. org.tl.warmup (WarmupListCheatSheet, WarmupListTasks, WarmupListSolutions).
 */
public class WarmupListTheory {

    /**
     * 1. size: сколько элементов
     *
     * size() возвращает количество элементов в списке. Для пустого списка вернёт 0.
     * У массива есть поле length, а у списка метод size(), со скобками.
     */
    static void size() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        System.out.println(numbers.size());   // 3
    }

    /**
     * 2. get: прочитать элемент по позиции
     *
     * get(позиция) возвращает элемент на этой позиции. Позиции считаются с 0.
     * Если такой позиции нет, Java бросает IndexOutOfBoundsException.
     */
    static void get() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        System.out.println(numbers.get(1));   // 20
    }

    /**
     * 3. add: добавить элемент в конец
     *
     * add(элемент) ставит элемент в конец списка, и список становится на один длиннее.
     * В этом главное отличие от массива, размер которого никогда не меняется.
     */
    static void add() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        System.out.println(numbers);          // [10, 20]
    }

    /**
     * 4. Collections.reverse: развернуть тот же список
     *
     * Collections.reverse(список) меняет порядок элементов на обратный. Метод ничего не возвращает
     * и меняет переданный ему список. Классу нужен импорт: java.util.Collections.
     */
    static void reverse() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        Collections.reverse(numbers);
        System.out.println(numbers);          // [3, 2, 1]
    }

    /**
     * 5. contains и indexOf: есть ли элемент и где он
     *
     * contains(элемент) возвращает true, если такой элемент есть в списке. indexOf(элемент) возвращает
     * его позицию или -1, если элемента нет. Оба сравнивают элементы через equals, поэтому работают и со строками.
     */
    static void containsAndIndexOf() {
        List<String> names = new ArrayList<>(List.of("Ann", "Bob"));
        System.out.println(names.contains("Bob"));   // true
        System.out.println(names.indexOf("Bob"));    // 1
        System.out.println(names.indexOf("Eve"));    // -1
    }

    /**
     * 6. remove: по элементу или по позиции
     *
     * remove(позиция) удаляет элемент на этой позиции. remove(элемент) удаляет первый равный элемент,
     * а если такого нет, ничего не делает. Элементы после удалённого сдвигаются на одну позицию влево.
     *
     * Ловушка: в List<Integer> вызов remove(1) означает позицию 1, а не число 1.
     * Чтобы удалить число, пишите remove(Integer.valueOf(1)).
     */
    static void remove() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        numbers.remove(1);                           // позиция 1: [10, 30]
        numbers.remove(Integer.valueOf(10));         // число 10: [30]
        System.out.println(numbers);                 // [30]
    }

    /**
     * 7. set и add(позиция, элемент): заменить и вставить
     *
     * set(позиция, элемент) записывает поверх старого элемента, размер не меняется.
     * add(позиция, элемент) вставляет элемент, размер растёт на один, а остальные сдвигаются вправо.
     */
    static void setAndAddAt() {
        List<String> names = new ArrayList<>(List.of("Ann", "Bob"));
        names.set(1, "Eve");                         // [Ann, Eve]
        names.add(0, "Max");                         // [Max, Ann, Eve]
        System.out.println(names);
    }

    /**
     * 8. isEmpty: пустой ли список
     *
     * isEmpty() возвращает true, когда в списке нет элементов. Это то же самое, что size() == 0, но читается проще.
     */
    static void isEmpty() {
        List<String> names = new ArrayList<>();
        System.out.println(names.isEmpty());         // true
        names.add("Ann");
        System.out.println(names.isEmpty());         // false
    }

    /**
     * 9. for-each: пройти по всем элементам
     *
     * for (int x : список) берёт элементы по одному, от первого до последнего. Подходит, когда элементы
     * нужно только читать, а их позиции не важны. Элементы List<Integer> можно читать сразу в int.
     */
    static void forEach() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 8, 5));
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        System.out.println(sum);                     // 16
    }

    /**
     * 10. Удаление во время цикла
     *
     * Удаление внутри for-each бросает ConcurrentModificationException. Идите по позициям с конца
     * к началу: тогда удаление сдвигает только уже проверенные элементы. Или используйте removeIf.
     */
    static void removeWhileLooping() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
        System.out.println(numbers);                 // [1, 3]

        List<Integer> other = new ArrayList<>(List.of(1, 2, 3, 4));
        other.removeIf(x -> x % 2 == 0);             // то же самое в одну строку
        System.out.println(other);                   // [1, 3]
    }
}
