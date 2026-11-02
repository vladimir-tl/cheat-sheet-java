package org.tl.theory.ru;

/**
 * ТЕОРИЯ: switch
 *
 * Короткие примеры. Скопируйте любой из них в метод main и запустите.
 *
 * Содержание
 *
 * Классический switch
 *   1. Синтаксис: switch, case, default
 *   2. break и «проваливание» (fall-through)
 *   3. По чему можно делать switch
 *
 * Современный switch (Java 14+)
 *   4. Стрелочная форма: case ->
 *   5. Switch как выражение: возвращает значение
 *   6. Несколько значений в одном case
 *   7. Блок в ветке: yield
 *
 * Выбор
 *   8. switch или if-else?
 *
 * Практика: см. org.tl.conditions.switchcase (SwitchCheatSheet, SwitchTasks, SwitchSolutions).
 */
public class SwitchTheory {

    /**
     * 1. Синтаксис: switch, case, default
     *
     * switch сравнивает одно значение с несколькими константами и выполняет код подходящего case.
     * default выполняется, когда ничего не подошло (он необязателен и может стоять где угодно, обычно последним).
     */
    static void syntax() {
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday"); // выполнится это
                break;
            default:
                System.out.println("Another day");
        }

        // Значения case должны быть константами: литералы, final-переменные или константы enum.
        // case x: с обычной переменной x не компилируется.
    }

    /**
     * 2. break и «проваливание» (fall-through)
     *
     * В классическом switch после подходящего case Java продолжает выполнять ВСЕ следующие case,
     * пока не встретит break (или конец switch). Это называется fall-through.
     * Забытый break это самая частая ошибка со switch.
     */
    static void fallThrough() {
        int n = 1;

        // Забыли break: напечатает "one", "two" и "default"
        switch (n) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            default:
                System.out.println("default");
        }

        // Fall-through бывает полезен намеренно, чтобы сгруппировать case:
        switch (n) {
            case 1:
            case 2:
            case 3:
                System.out.println("small"); // для 1, 2 и 3
                break;
            default:
                System.out.println("big");
        }
    }

    /**
     * 3. По чему можно делать switch
     *
     * Можно: int, short, byte, char (и их обёртки Integer, Short, Byte, Character),
     * String и enum.
     * НЕЛЬЗЯ: long, float, double, boolean. Для них используйте if-else.
     *
     * String сравнивается через equals(), поэтому учитывается регистр: "Yes" и "yes" разные.
     * null в switch бросает NullPointerException.
     */
    static void types() {
        String command = "stop";
        switch (command) {
            case "start":
                System.out.println("Starting");
                break;
            case "stop":
                System.out.println("Stopping");
                break;
            default:
                System.out.println("Unknown command");
        }

        char grade = 'B';
        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("Good");
                break;
            default:
                System.out.println("Other");
        }

        // long big = 5L;
        // switch (big) { ... } // не компилируется
    }

    /**
     * 4. Стрелочная форма: case ->
     *
     * С -> выполняется только код подходящего case. Fall-through нет,
     * поэтому break не нужен. Короче и безопаснее: предпочитайте её.
     */
    static void arrow() {
        int day = 3;

        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("Another day");
        }

        // Нельзя смешивать case: и case -> в одном switch.
    }

    /**
     * 5. Switch как выражение: возвращает значение
     *
     * switch может выдавать значение, его можно присвоить или вернуть. После закрывающей
     * скобки ставится ;. Он должен покрывать все возможные значения: закончите его default
     * (или перечислите все константы enum), иначе он не скомпилируется.
     */
    static void expression() {
        int day = 3;

        String name = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Another day";
        };
        System.out.println(name); // Wednesday

        // Без default не компилируется: "the switch expression does not cover all possible input values"
    }

    /**
     * 6. Несколько значений в одном case
     *
     * В современной форме значения перечисляют через запятую. Это заменяет сгруппированные
     * case из раздела 2.
     */
    static void severalValues() {
        int month = 7;

        String season = switch (month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> "Not a month";
        };
        System.out.println(season); // Summer
    }

    /**
     * 7. Блок в ветке: yield
     *
     * Если ветке нужно несколько строк, используйте блок { } и возвращайте значение через yield.
     * yield нужен в выражениях switch, а return выйдет из всего метода.
     */
    static void yieldValue() {
        int score = 85;

        String result = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> {
                System.out.println("Almost excellent");
                yield "B";
            }
            default -> "C or lower";
        };
        System.out.println(result); // B
    }

    /**
     * 8. switch или if-else?
     *
     * switch: одна переменная сравнивается с точными значениями (команда меню, день недели, enum).
     * if-else: диапазоны и условия (age >= 18, x > 0 && x < 10), boolean, long и double.
     *
     * Диапазон в switch невозможен: для него пишите if-else.
     */
    static void switchOrIf() {
        int age = 20;

        // Диапазон -> if-else
        if (age < 18) {
            System.out.println("Minor");
        } else {
            System.out.println("Adult");
        }
    }
}
