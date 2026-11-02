package org.tl.theory.ru;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ТЕОРИЯ: Stream API
 *
 * Короткие примеры. Скопируйте любой из них в метод main и запустите.
 *
 * Содержание
 *
 * Основы
 *   1. Что такое поток (stream)
 *   2. Создание потока
 *   3. Лямбда: крошечная функция
 *
 * Промежуточные операции: станции конвейера
 *   4. filter: оставить только подходящие элементы
 *   5. map: преобразовать каждый элемент
 *   6. sorted, distinct, limit, skip
 *
 * Терминальные операции: конец конвейера
 *   7. toList и collect: получить коллекцию обратно
 *   8. count, sum, average, min, max
 *   9. anyMatch, allMatch, noneMatch, findFirst
 *   10. forEach
 *
 * Группировка
 *   11. groupingBy и counting
 *
 * Ловушки
 *   12. Один раз, нет терминальной операции, effectively final
 *
 * Практика: см. org.tl.streams (StreamCheatSheet, StreamTasks, StreamSolutions).
 */
public class StreamTheory {

    /**
     * 1. Что такое поток (stream)
     *
     * Поток это способ обрабатывать коллекцию по шагам, как конвейер:
     *
     *   источник  ->  станция  ->  станция  ->  ...  ->  результат
     *   (список)      filter       map                   (список, число, текст...)
     *
     * - Источник это List, Set, массив и так далее.
     * - Станции (промежуточные операции) берут элементы, фильтруют или меняют их и передают дальше.
     * - Последний шаг (терминальная операция) собирает результат. Только тогда конвейер запускается.
     *
     * Поток НЕ меняет исходный список. Он даёт новый результат.
     * Он заменяет много циклов for коротким читаемым кодом: «из счетов возьми большие,
     * сложи их суммы».
     */
    static void whatIsStream() {
        List<Integer> totals = List.of(5, 12, 8, 20, 3);

        // «Из сумм счетов возьми те, что больше 7, и сделай список»
        List<Integer> big = totals.stream()    // источник
                .filter(t -> t > 7)            // станция: оставить большие
                .toList();                     // конец: список [12, 8, 20]

        // То же самое циклом (длиннее):
        // List<Integer> big = new ArrayList<>();
        // for (int t : totals) { if (t > 7) big.add(t); }
    }

    /**
     * 2. Создание потока
     *
     *   - из List или Set: list.stream()
     *   - из массива: Arrays.stream(array)
     *   - из значений: Stream.of("a", "b", "c")
     *   - диапазон чисел: IntStream.range(1, 6) даёт 1, 2, 3, 4, 5 (конец НЕ включается);
     *     IntStream.rangeClosed(1, 5) даёт 1..5 (конец включается)
     *
     * У Map нет stream(): используйте map.entrySet().stream() или map.values().stream().
     */
    static void creating() {
        List<String> names = List.of("Anna", "Bob", "Eve");
        int[] numbers = {10, 20, 30};

        Stream<String> fromList = names.stream();
        IntStream fromArray = java.util.Arrays.stream(numbers);
        Stream<String> fromValues = Stream.of("a", "b", "c");
        IntStream range = IntStream.range(1, 6);                // 1, 2, 3, 4, 5
    }

    /**
     * 3. Лямбда: крошечная функция
     *
     * В потоки передают маленькие функции, записанные как лямбда: параметры -> результат.
     *
     *   x -> x * 2            один параметр, возвращает x * 2
     *   (a, b) -> a + b       для двух параметров нужны скобки
     *   x -> { ...; return y; }  блок, когда одного выражения мало
     *
     * Читайте стрелку как «переходит в»: t -> t > 7 это «t переходит в (t больше 7)».
     * Имя параметра можно выбрать любое.
     *
     * Ссылка на метод это более короткая лямбда, которая только вызывает один метод:
     *   String::toUpperCase    то же самое, что   s -> s.toUpperCase()
     *   String::length         то же самое, что   s -> s.length()
     *   System.out::println    то же самое, что   x -> System.out.println(x)
     */
    static void lambdas() {
        List<String> names = List.of("Anna", "Bob", "Eve");

        names.stream().map(s -> s.toUpperCase());      // лямбда
        names.stream().map(String::toUpperCase);       // ссылка на метод: то же самое
    }

    /**
     * 4. filter: оставить только подходящие элементы
     *
     * filter принимает условие (лямбду, которая возвращает true или false) и пропускает только
     * те элементы, для которых оно истинно. Остальные отбрасываются.
     */
    static void filtering() {
        List<Integer> totals = List.of(5, 12, 8, 20, 3);
        List<String> names = List.of("Anna", "Bob", "Alex", "Eve");

        List<Integer> big = totals.stream().filter(t -> t > 7).toList();        // [12, 8, 20]
        List<String> onA = names.stream().filter(n -> n.startsWith("A")).toList(); // [Anna, Alex]
    }

    /**
     * 5. map: преобразовать каждый элемент
     *
     * map принимает функцию и применяет её к каждому элементу. Количество элементов остаётся
     * тем же, но сами элементы (и даже их тип) могут измениться.
     */
    static void mapping() {
        List<String> names = List.of("Anna", "Bob", "Eve");
        List<Integer> prices = List.of(5, 12, 8);

        List<String> upper = names.stream().map(String::toUpperCase).toList();  // [ANNA, BOB, EVE]
        List<Integer> lengths = names.stream().map(String::length).toList();    // [4, 3, 3]: String -> Integer
        List<Integer> cents = prices.stream().map(p -> p * 100).toList();       // [500, 1200, 800]

        // Станции можно соединять в цепочку: сначала filter, потом map
        List<String> result = names.stream()
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .toList();                                                      // [ANNA]
    }

    /**
     * 6. sorted, distinct, limit, skip
     *
     *   sorted()                         - по возрастанию (числа, строки)
     *   sorted(Comparator.reverseOrder()) - по убыванию
     *   distinct()                       - убрать дубликаты
     *   limit(n)                         - взять только первые n элементов
     *   skip(n)                          - пропустить первые n элементов
     */
    static void sortLimit() {
        List<Integer> totals = List.of(5, 12, 8, 12, 3);

        totals.stream().sorted().toList();                                   // [3, 5, 8, 12, 12]
        totals.stream().sorted(Comparator.reverseOrder()).toList();          // [12, 12, 8, 5, 3]
        totals.stream().distinct().toList();                                 // [5, 12, 8, 3]
        totals.stream().limit(2).toList();                                   // [5, 12]
        totals.stream().skip(3).toList();                                    // [12, 3]

        // «Топ-3 самых больших суммы»:
        totals.stream().sorted(Comparator.reverseOrder()).limit(3).toList(); // [12, 12, 8]
    }

    /**
     * 7. toList и collect: получить коллекцию обратно
     *
     * toList() завершает поток и выдаёт List. Результат НЕЛЬЗЯ менять (add бросает
     * UnsupportedOperationException). Если нужен изменяемый список, оберните: new ArrayList<>(...).
     *
     * collect(...) это общий способ, с готовыми коллекторами из класса Collectors:
     *   Collectors.toList()         - изменяемый List
     *   Collectors.toSet()          - Set (дубликаты исчезают)
     *   Collectors.joining(", ")    - одна строка со всеми элементами через разделитель
     *
     * (toList() требует Java 16 или новее.)
     */
    static void collecting() {
        List<String> names = List.of("Anna", "Bob", "Eve");

        List<String> list = names.stream().toList();                          // [Anna, Bob, Eve]
        java.util.Set<String> set = names.stream().collect(Collectors.toSet());
        String text = names.stream().collect(Collectors.joining(", "));       // "Anna, Bob, Eve"
    }

    /**
     * 8. count, sum, average, min, max
     *
     * Эти операции завершают поток и дают одно значение.
     *   count()                 - сколько элементов (результат long)
     *   mapToInt(...).sum()     - сумма чисел
     *   mapToInt(...).average() - среднее (OptionalDouble: список может быть пустым)
     *   max(...) / min(...)     - наибольший / наименьший (Optional: список может быть пустым)
     *
     * mapToInt(Integer::intValue) превращает Stream<Integer> в IntStream, у которого есть sum() и average().
     */
    static void numbers() {
        List<Integer> totals = List.of(5, 12, 8, 20, 3);

        long howMany = totals.stream().filter(t -> t > 7).count();                  // 3
        int sum = totals.stream().mapToInt(Integer::intValue).sum();                // 48
        double average = totals.stream().mapToInt(Integer::intValue)
                .average().orElse(0);                                               // 9.6
        int max = totals.stream().max(Integer::compare).orElse(-1);                 // 20
        int min = totals.stream().min(Integer::compare).orElse(-1);                 // 3

        // orElse(x) это значение для пустого списка: без него вы получите «коробку» Optional.
    }

    /**
     * 9. anyMatch, allMatch, noneMatch, findFirst
     *
     * Вопросы об элементах:
     *   anyMatch(cond)   - есть ХОТЯ БЫ ОДИН подходящий элемент? (true/false)
     *   allMatch(cond)   - подходят ли ВСЕ элементы? (true для пустого списка)
     *   noneMatch(cond)  - НЕ подходит ни один элемент?
     *   findFirst()      - первый элемент, в виде Optional (поток может быть пустым).
     *                      Значение берут через orElse(default) или get().
     */
    static void questions() {
        List<Integer> totals = List.of(5, 12, 8, 20, 3);

        boolean hasBig = totals.stream().anyMatch(t -> t > 15);                      // true
        boolean allPositive = totals.stream().allMatch(t -> t > 0);                  // true
        boolean noHuge = totals.stream().noneMatch(t -> t > 100);                    // true

        Optional<Integer> first = totals.stream().filter(t -> t > 10).findFirst();   // Optional[12]
        int firstOrDefault = totals.stream().filter(t -> t > 100).findFirst().orElse(-1); // -1
    }

    /**
     * 10. forEach
     *
     * forEach что-то делает с каждым элементом (печатает, сохраняет). Он ничего не возвращает.
     * Используйте его для действий, а не для сбора результатов: для результатов есть toList() и collect.
     */
    static void each() {
        List<String> names = List.of("Anna", "Bob", "Eve");

        names.stream().forEach(System.out::println);       // Anna, Bob, Eve
        names.forEach(System.out::println);                // у List тоже есть forEach: то же самое
    }

    /**
     * 11. groupingBy и counting
     *
     * collect(Collectors.groupingBy(...)) делит элементы на группы и возвращает Map:
     * ключ это группа, значение это список её элементов.
     * С counting() значение это просто количество элементов в группе.
     */
    static void grouping() {
        List<String> countries = List.of("Brazil", "USA", "Brazil", "Canada", "USA", "Brazil");

        // Сколько клиентов из каждой страны?
        Map<String, Long> count = countries.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        // {Brazil=3, USA=2, Canada=1}  (порядок в HashMap не гарантирован)

        // Сгруппировать слова по длине:
        List<String> words = List.of("hi", "yo", "hello", "world", "a");
        Map<Integer, List<String>> byLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        // {1=[a], 2=[hi, yo], 5=[hello, world]}
    }

    /**
     * 12. Один раз, нет терминальной операции, effectively final
     *
     * Три классические ловушки.
     *
     * 1) Поток можно использовать ОДИН раз. Повторное использование бросает IllegalStateException
     *    ("stream has already been operated upon or closed"). Создайте новый поток из списка.
     * 2) Без терминальной операции ничего не происходит. filter и map только описывают
     *    конвейер; он запускается, когда вы вызываете toList, count, forEach и так далее.
     * 3) Лямбда может только читать локальные переменные, которые не меняются (effectively final).
     *    Считать внешним counter++ внутри лямбды нельзя. Используйте count() или sum().
     */
    static void traps() {
        List<Integer> totals = List.of(5, 12, 8);

        Stream<Integer> stream = totals.stream();
        stream.count();
        // stream.count();                      // IllegalStateException

        totals.stream().filter(t -> t > 7);     // ничего не делает: нет терминальной операции

        // int counter = 0;
        // totals.forEach(t -> counter++);      // не компилируется: counter не effectively final
        long counter = totals.stream().filter(t -> t > 7).count();   // правильный способ
    }
}
