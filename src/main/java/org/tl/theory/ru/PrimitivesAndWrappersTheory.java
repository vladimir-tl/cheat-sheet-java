package org.tl.theory.ru;

import java.util.Objects;

/**
 * ТЕОРИЯ: примитивы и классы-обёртки
 *
 * Короткие примеры. Скопируйте любой из них в метод main и запустите.
 *
 * Содержание
 *
 * Основы
 *   1. Два вида типов: примитивы и обёртки
 *   2. Восемь примитивов и их обёртки
 *   3. Что когда использовать
 *
 * Преобразования
 *   4. Автоупаковка и распаковка
 *   5. Парсинг: строка в число и обратно
 *   6. Приведение типов: расширение и сужение
 *
 * Ловушки
 *   7. Распаковка null: NullPointerException
 *   8. Сравнение обёрток: == или equals?
 *   9. Целочисленное деление, переполнение, точность double
 *
 * Практика: см. org.tl.types (PrimitivesAndWrappersCheatSheet, PrimitivesAndWrappersTasks, PrimitivesAndWrappersSolutions).
 */public class PrimitivesAndWrappersTheory {

    /**
     * 1. Два вида типов: примитивы и обёртки
     *
     * Примитив: хранит само значение. Быстрый, никогда не null, методов нет. Пишется
     * с маленькой буквы: int, double, boolean.
     *
     * Обёртка: класс (объект), который хранит примитив. Может быть null, имеет полезные
     * методы и нужна для generics. Пишется с большой буквы: Integer, Double, Boolean.
     *
     * String НЕ примитив; это класс.
     */
    static void twoKinds() {
        int a = 5;          // примитив: просто число 5
        Integer b = 5;      // обёртка: объект, хранящий 5
        Integer c = null;   // возможно только для обёртки
    }

    /**
     * 2. Восемь примитивов и их обёртки
     *
     *   Примитив  | Обёртка   | Размер | По умолч.| Примечания
     *   ----------|-----------|--------|----------|--------------------------------
     *   byte      | Byte      | 8 бит  | 0        | -128 .. 127
     *   short     | Short     | 16 бит | 0        |
     *   int       | Integer   | 32 бит | 0        | целый тип по умолчанию
     *   long      | Long      | 64 бит | 0L       | в литерале нужна L: 10000000000L
     *   float     | Float     | 32 бит | 0.0f     | в литерале нужна f: 1.5f
     *   double    | Double    | 64 бит | 0.0      | дробный тип по умолчанию
     *   char      | Character | 16 бит | 0 (nul)  | один символ в одинарных кавычках: 'a'
     *   boolean   | Boolean   | —      | false    | true или false
     *
     * «По умолчанию» это значение, которое получает поле или элемент массива, если ничего не задать.
     * Для любой обёртки значение по умолчанию null, а не 0.
     *
     * Заметка: Почему у boolean нет размера? Спецификация Java его не задаёт. В boolean всего 1 бит
     * информации (true или false), но память нельзя адресовать по одному биту, поэтому решает JVM:
     * обычно 1 байт в массиве и 4 байта (как int) в локальной переменной.
     * Для написания кода это знать не нужно.
     */
    static void table() {
        long big = 10000000000L;  // без L: "integer number too large"
        float f = 1.5f;           // без f: 1.5 это double и не помещается в float
        char letter = 'a';        // одинарные кавычки для char, двойные для String
    }

    /**
     * 3. Что когда использовать
     *
     *   - По умолчанию примитив: счётчики, математика, флаги.
     *   - Обёртка, когда нужен null («значения нет») или внутри generics:
     *     Map<String, Long>. Generics не могут хранить примитивы: Map<String, long> не компилируется.
     */
    static void whenToUse() {
        int count = 0;                    // счётчик: примитив
        Integer maybeAge = null;          // возраст может быть неизвестен: обёртка
    }

    /**
     * 4. Автоупаковка и распаковка
     *
     * Java сама преобразует примитив в обёртку и обратно.
     *   упаковка (boxing):     int -> Integer
     *   распаковка (unboxing): Integer -> int
     */
    static void autoboxing() {
        Integer boxed = 5;       // упаковка
        int primitive = boxed;   // распаковка
    }

    /**
     * 5. Парсинг: строка в число и обратно
     *
     * Integer.parseInt("42") превращает текст в int. String.valueOf(42) превращает число
     * в текст. Текст, который не является числом, бросает NumberFormatException.
     */
    static void parsing() {
        int a = Integer.parseInt("42");             // 42
        double d = Double.parseDouble("3.14");      // 3.14
        String text = String.valueOf(42);           // "42"
        Integer boxed = Integer.valueOf(42);        // 42 как Integer

        // Integer.parseInt("abc");   // NumberFormatException: For input string: "abc"
        // Integer.parseInt("");      // NumberFormatException
    }

    /**
     * 6. Приведение типов: расширение и сужение
     *
     * Расширение (меньший -> больший тип) автоматическое и безопасное: int -> long -> double.
     * Сужение (больший -> меньший) требует приведения в скобках и может потерять данные.
     */
    static void casting() {
        long big = 5;                   // int -> long, автоматически
        double dbl = 5;                 // int -> double, автоматически: 5.0

        int truncated = (int) 3.99;     // 3: дробная часть ОТБРАСЫВАЕТСЯ, а не округляется
        byte overflow = (byte) 200;     // -56: 200 не помещается в byte (максимум 127)
        int rounded = (int) Math.round(3.99); // 4: для округления используйте Math.round
    }

    /**
     * 7. Распаковка null: NullPointerException
     *
     * Обёртка может быть null, примитив нет. Если распаковать null-обёртку,
     * программа упадёт.
     */
    static void nullTrap() {
        Integer value = null;
        // int x = value;   // NullPointerException

        int safe = (value != null) ? value : 0;   // сначала проверка -> 0
    }

    /**
     * 8. Сравнение обёрток: == или equals?
     *
     * Это два разных вопроса:
     *   - == для примитивов: равны ли значения?
     *   - == для объектов (Integer, String, Long...): это ОДИН И ТОТ ЖЕ объект в памяти?
     *   - equals(): равны ли значения? Для объектов почти всегда нужно именно это.
     *
     * Integer кэширует значения -128 .. 127, поэтому == «работает» для маленьких чисел случайно
     * и ломается для больших. Не полагайтесь на это.
     *
     * Заметка: Ещё три ловушки с equals
     *   - Разные типы обёрток никогда не равны: Long это не Integer, даже с тем же значением.
     *     > Long id = 1L;
     *     > id.equals(1);    // false: 1 упаковывается в Integer
     *     > id.equals(1L);   // true
     *   - equals на null падает: если c равно null, c.equals(d) бросает NullPointerException. Objects.equals(c, d) безопасен.
     *     > Objects.equals(null, null); // true
     *     > Objects.equals(null, 5);    // false, без исключения
     *   - int == Integer: Java распаковывает Integer и сравнивает значения. Если Integer равен null, будет NullPointerException.
     */
    static void equalsTrap() {
        int a = 1000, b = 1000;
        System.out.println(a == b);             // true: примитивы

        Integer c = 1000, d = 1000;
        System.out.println(c == d);             // false (!) два разных объекта
        System.out.println(c.equals(d));        // true: сравнивает значения

        Integer e = 100, f = 100;
        System.out.println(e == f);             // true, только потому что 100 в кэше

        Long id = 1L;
        System.out.println(id.equals(1));       // false: Integer 1 это не Long 1
        System.out.println(id.equals(1L));      // true

        Integer missing = null;
        System.out.println(Objects.equals(missing, c)); // false, безопасно с null
        // missing.equals(c);                   // NullPointerException
        // int x = 5; x == missing;             // NullPointerException: null нельзя распаковать
    }

    /**
     * 9. Целочисленное деление, переполнение, точность double
     *
     * Три классических неожиданности с числами.
     */
    static void numberTraps() {
        // Целочисленное деление: int / int это int, дробная часть отбрасывается
        System.out.println(5 / 2);              // 2, а не 2.5
        System.out.println(5 / 2.0);            // 2.5: один операнд double
        System.out.println(5 % 2);              // 1: остаток

        // Переполнение: в int не хватает места для большего числа, и значение «заворачивается»
        System.out.println(Integer.MAX_VALUE);      // 2147483647
        System.out.println(Integer.MAX_VALUE + 1);  // -2147483648 (!)
        System.out.println(Integer.MAX_VALUE + 1L); // 2147483648: используйте long

        // Точность: double хранит дроби приблизительно
        System.out.println(0.1 + 0.2);              // 0.30000000000000004
        System.out.println(0.1 + 0.2 == 0.3);       // false
        // Для денег используйте BigDecimal или целое число копеек в long.
    }
}
