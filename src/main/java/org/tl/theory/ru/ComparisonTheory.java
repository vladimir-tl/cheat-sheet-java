package org.tl.theory.ru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * ТЕОРИЯ: Сравнение
 *
 * Короткие примеры. Скопируйте любой из них в метод main и запустите.
 *
 * Содержание
 *
 * Коллекции
 *   1. Сравнение двух списков List
 *   3. Сравнение двух Map
 *
 * На практике
 *   4. Основной use case equals()
 */
public class ComparisonTheory {

    /**
     * 1. Сравнение двух списков List
     *
     * Списки равны, если в них одинаковые элементы в одинаковом порядке.
     *
     * == проверяет, один ли это объект, а equals сравнивает содержимое.
     * Если поменять порядок элементов, equals вернёт false.
     */
    static void compareLists() {
        List<String> first = new ArrayList<>();
        first.add("Anna");
        first.add("Max");

        List<String> second = new ArrayList<>();
        second.add("Anna");
        second.add("Max");

        System.out.println(first == second);      // false — разные объекты
        System.out.println(first.equals(second)); // true — содержимое одинаковое

        // Если поменять порядок:
        List<String> third = new ArrayList<>();
        third.add("Max");
        third.add("Anna");

        System.out.println(first.equals(third));  // false
    }

    /**
     * 3. Сравнение двух Map
     *
     * Две Map равны, если содержат одинаковые пары «ключ → значение». Порядок добавления не важен.
     */
    static void compareMaps() {
        Map<String, Integer> first = new HashMap<>();
        first.put("Anna", 25);
        first.put("Max", 30);

        Map<String, Integer> second = new HashMap<>();
        second.put("Max", 30);
        second.put("Anna", 25);

        System.out.println(first == second);      // false — разные объекты
        System.out.println(first.equals(second)); // true — одинаковые пары
    }

    /**
     * 4. Основной use case equals()
     *
     * Основной use case .equals() — проверить, равны ли два объекта по содержимому.
     *
     * Например: пользователь ввёл команду, и нужно проверить её текст.
     * Или найти конкретное имя при переборе.
     */
    static void equalsUseCase() {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        if ("exit".equals(command)) {
            System.out.println("Выход из программы");
        }

        // найти конкретное имя при переборе:
        List<String> names = List.of("Max", "Anna", "Kate");
        for (String name : names) {
            if ("Anna".equals(name)) {
                System.out.println("Нашли Анну!");
            }
        }
    }
}
