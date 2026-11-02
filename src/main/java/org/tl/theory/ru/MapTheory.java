package org.tl.theory.ru;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * ТЕОРИЯ: Map
 *
 * Короткие примеры. Скопируйте любой из них в метод main и запустите.
 *
 * Содержание
 *
 * Основы
 *   1. Что такое Map
 *   2. Положить и получить: put и get
 *   3. Нет ключа: null и getOrDefault
 *   4. Проверка ключа: containsKey
 *
 * Виды Map
 *   5. HashMap, LinkedHashMap, TreeMap
 *
 * Обход
 *   6. Перебор: entrySet, keySet, values
 *
 * Ловушки
 *   7. Ключи уникальны и сравниваются через equals/hashCode
 *
 * Практика: см. org.tl.collections.map (MapCheatSheet, MapTasks, MapSolutions).
 */
public class MapTheory {

    /**
     * 1. Что такое Map
     *
     * Map хранит пары ключ -> значение, как словарь. Значение находят по ключу.
     * Ключи уникальны. Значения могут повторяться. Поиск по ключу быстрый.
     *
     * Generics: Map<ТипКлюча, ТипЗначения>. Примитивам нужны обёртки: Map<String, Integer>,
     * а не Map<String, int> (см. PrimitivesAndWrappersTheory).
     *
     * Map это не List: индексов нет, и map.get(0) писать нельзя.
     */
    static void whatIsMap() {
        // "Anna" -> 25
        // "Bob"  -> 30
        Map<String, Integer> ages = new HashMap<>();
    }

    /**
     * 2. Положить и получить: put и get
     *
     * put(key, value) добавляет пару. Если ключ уже есть, его значение ПЕРЕЗАПИСЫВАЕТСЯ.
     * get(key) возвращает значение.
     */
    static void putAndGet() {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Anna", 25);   // {Anna=25}
        ages.put("Bob", 30);    // {Anna=25, Bob=30}
        ages.put("Anna", 26);   // тот же ключ -> {Anna=26, Bob=30}

        ages.get("Anna");       // 26
        ages.size();            // 2: по-прежнему два ключа
    }

    /**
     * 3. Нет ключа: null и getOrDefault
     *
     * get возвращает null, если ключ не найден. getOrDefault(key, x) вместо этого возвращает x.
     *
     * Ловушка: распаковка null. int age = ages.get("Zed") бросает NullPointerException,
     * потому что null нельзя превратить в int (см. PrimitivesAndWrappersTheory).
     */
    static void missingKey() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Anna", 26);

        Integer unknown = ages.get("Zed");        // null
        int safe = ages.getOrDefault("Zed", 0);   // 0
        // int crash = ages.get("Zed");           // NullPointerException
    }

    /**
     * 4. Проверка ключа: containsKey
     *
     * containsKey(key) истинно, если ключ есть в карте. containsValue(value) проверяет значения
     * (это медленно: перебираются все).
     */
    static void contains() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Anna", 26);

        ages.containsKey("Anna");   // true
        ages.containsKey("Zed");    // false
        ages.containsValue(26);     // true
    }

    /**
     * 5. HashMap, LinkedHashMap, TreeMap
     *
     * Все три используются одинаково. Разница в порядке пар.
     *
     *   HashMap         - порядок не гарантирован. Выбор по умолчанию, самый быстрый.
     *   LinkedHashMap   - сохраняет порядок добавления.
     *   TreeMap         - хранит ключи отсортированными (от A до Z, от меньшего к большему).
     *
     * Map.of(...) создаёт неизменяемую карту (put бросает UnsupportedOperationException).
     */
    static void kinds() {
        Map<String, Integer> hash = new HashMap<>();
        Map<String, Integer> linked = new LinkedHashMap<>();
        Map<String, Integer> tree = new TreeMap<>();

        // После put("Bob", 1), put("Anna", 2), put("Eve", 3):
        //   HashMap:       любой порядок
        //   LinkedHashMap: {Bob=1, Anna=2, Eve=3}
        //   TreeMap:       {Anna=2, Bob=1, Eve=3}
    }

    /**
     * 6. Перебор: entrySet, keySet, values
     *
     * Напрямую по Map цикл не пройти. Выберите, что нужно:
     *   entrySet() - ключ и значение вместе (пары)
     *   keySet()   - только ключи
     *   values()   - только значения
     */
    static void iterating() {
        Map<String, Integer> ages = new LinkedHashMap<>();
        ages.put("Anna", 26);
        ages.put("Bob", 30);

        // Пары: Anna=26, Bob=30
        for (Map.Entry<String, Integer> e : ages.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }

        // Ключи: Anna, Bob
        for (String name : ages.keySet()) {
            System.out.println(name);
        }

        // Значения: 26, 30
        for (int age : ages.values()) {
            System.out.println(age);
        }
    }

    /**
     * 7. Ключи уникальны и сравниваются через equals/hashCode
     *
     * Map находит ключ с помощью equals() и hashCode(). У String и Integer они реализованы
     * правильно, поэтому используйте их как ключи. Для своих классов нужно написать оба метода,
     * иначе два «равных» объекта станут двумя разными ключами.
     *
     * Не меняйте объект после того, как использовали его как ключ: изменится hashCode,
     * и карта его больше не найдёт.
     */
    static void keysTrap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Anna", 1);
        map.put("anna", 2);  // другой ключ: String учитывает регистр -> 2 записи
        map.size();          // 2
    }
}
