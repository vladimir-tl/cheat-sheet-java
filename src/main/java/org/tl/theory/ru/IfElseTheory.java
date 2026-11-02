package org.tl.theory.ru;

/**
 * ТЕОРИЯ: if-else
 *
 * Короткие примеры. Скопируйте любой из них в метод main и запустите.
 *
 * Содержание
 *
 * Основы
 *   1. Синтаксис: if
 *   2. if-else: два пути
 *   3. else if: много путей
 *
 * Условия
 *   4. Операторы сравнения и логические операторы
 *   5. Короткое замыкание: && и ||
 *   6. Сравнение строк: equals, а не ==
 *   7. Тернарный оператор: ?:
 *
 * Ловушки
 *   8. Скобки, точка с запятой, = вместо ==, порядок условий
 *
 * Практика: см. org.tl.conditions.ifelse (IfElseCheatSheet, IfElseTasks, IfElseSolutions).
 */
public class IfElseTheory {

    /**
     * 1. Синтаксис: if
     *
     * if выполняет блок кода только тогда, когда условие истинно. Условие должно быть
     * булевым выражением (true или false). Если оно ложно, блок пропускается.
     *
     * Всегда ставьте фигурные скобки { }, даже для одной строки.
     */
    static void syntax() {
        int age = 20;

        if (age >= 18) {
            System.out.println("Adult"); // выполнится
        }

        if (age < 18) {
            System.out.println("Minor"); // пропущено
        }
    }

    /**
     * 2. if-else: два пути
     *
     * else выполняется, когда условие ложно. Всегда выполняется ровно один из двух блоков.
     */
    static void ifElse() {
        int number = 7;

        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd"); // выполнится
        }
    }

    /**
     * 3. else if: много путей
     *
     * Цепочка условий. Java проверяет их сверху вниз и выполняет ПЕРВЫЙ блок, условие
     * которого истинно; остальные пропускаются. Последний else необязателен: он выполняется,
     * когда ничего не подошло.
     */
    static void elseIf() {
        int score = 85;

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B"); // выполнится, цепочка на этом заканчивается
        } else if (score >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }
    }

    /**
     * 4. Операторы сравнения и логические операторы
     *
     * Сравнение (результат boolean):
     *   ==  равно            !=  не равно
     *   >   больше           >=  больше или равно
     *   <   меньше           <=  меньше или равно
     *
     * Логические:
     *   &&  И: обе части должны быть истинны
     *   ||  ИЛИ: хотя бы одна часть должна быть истинна
     *   !   НЕ: меняет true на false и обратно
     *
     * && вычисляется раньше ||. Когда смешиваете их, ставьте скобки.
     */
    static void operators() {
        int age = 20;
        boolean hasTicket = true;

        if (age >= 18 && hasTicket) {
            System.out.println("Come in");
        }

        if (age < 12 || age > 65) {
            System.out.println("Discount");
        }

        if (!hasTicket) {
            System.out.println("Buy a ticket");
        }

        // Для диапазона 10..20 нужны && и переменная дважды. Это НЕ скомпилируется:
        // if (10 <= age <= 20) { ... }
        if (age >= 10 && age <= 20) {
            System.out.println("In the range");
        }

        // Скобки делают порядок понятным:
        // true || false && false   -> true  (сначала &&: false, затем true || false)
        // (true || false) && false -> false
    }

    /**
     * 5. Короткое замыкание: && и ||
     *
     * Java останавливается, как только результат известен.
     *   a && b: если a ложно, b НЕ вычисляется (результат уже false).
     *   a || b: если a истинно, b НЕ вычисляется (результат уже true).
     *
     * Это используют намеренно: безопасную проверку ставьте первой.
     */
    static void shortCircuit() {
        String text = null;

        // Безопасно: text != null ложно, поэтому text.length() не вызывается
        if (text != null && text.length() > 3) {
            System.out.println("Long text");
        }

        // Неправильный порядок падает с NullPointerException:
        // if (text.length() > 3 && text != null) { ... }

        // Та же идея защищает от деления на ноль:
        int a = 10, b = 0;
        if (b != 0 && a / b > 2) {
            System.out.println("More than 2");
        }
    }

    /**
     * 6. Сравнение строк: equals, а не ==
     *
     * Для объектов `==` сравнивает ссылки (это тот же объект?), а не текст.
     * Строки всегда сравнивайте через equals().
     *
     * Ставьте литерал первым: "yes".equals(answer) работает, даже если answer равен null,
     * а answer.equals("yes") бросает NullPointerException.
     */
    static void strings() {
        String a = "hi";
        String b = new String("hi");

        System.out.println(a == b);          // false (!) два разных объекта
        System.out.println(a.equals(b));     // true: сравнивает текст
        System.out.println("HI".equalsIgnoreCase(a)); // true: игнорирует регистр

        String answer = null;
        System.out.println("yes".equals(answer)); // false, без исключения
        // answer.equals("yes");                  // NullPointerException
    }

    /**
     * 7. Тернарный оператор: ?:
     *
     * Короткий if-else, который возвращает значение: условие ? значениеЕслиTrue : значениеЕслиFalse.
     * Хорош для простого выбора. Для длинной логики используйте if-else; не вкладывайте тернарные операторы.
     */
    static void ternary() {
        int age = 20;

        String status = age >= 18 ? "adult" : "minor";
        System.out.println(status); // adult

        // То же самое через if-else:
        String status2;
        if (age >= 18) {
            status2 = "adult";
        } else {
            status2 = "minor";
        }

        int a = 3, b = 8;
        int max = a > b ? a : b;    // 8
    }

    /**
     * 8. Скобки, точка с запятой, = вместо ==, порядок условий
     *
     * Четыре классические ошибки.
     */
    static void traps() {
        int x = 5;

        // 1. Без скобок: к if относится только ПЕРВАЯ строка
        // if (x > 10)
        //     System.out.println("big");
        //     System.out.println("always printed"); // не часть if!
        // Кроме того, else относится к БЛИЖАЙШЕМУ if. Скобки убирают все сомнения.

        // 2. Точка с запятой после if: ПУСТОЕ тело, блок ниже выполняется всегда
        // if (x > 10); {
        //     System.out.println("always printed");
        // }

        // 3. = это присваивание, == это сравнение
        // if (x = 5) { ... }   // для int не компилируется: int cannot be converted to boolean
        boolean flag = false;
        if (flag = true) {      // компилируется (!): это ПРИСВАИВАНИЕ true, блок выполняется всегда
            System.out.println("flag is now true");
        }

        // 4. Порядок условий в else-if: побеждает первое совпадение
        int score = 95;
        if (score > 50) {
            System.out.println("Pass");        // напечатается даже для 95
        } else if (score > 90) {
            System.out.println("Excellent");   // недостижимо
        }
        // Сначала проверяйте самое строгое условие: score > 90, затем score > 50.
    }
}
