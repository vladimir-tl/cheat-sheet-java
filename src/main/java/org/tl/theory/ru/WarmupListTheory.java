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
}
