package com.foxfail;

import com.foxfail.interfaces.Functional;
import com.foxfail.interfaces.FunctionalWithReturnValue;
import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String[] args) {
        System.out.println("-== Функциональный интерфейс без возвращаемого значения ==-");
        // Реализация метода функционального интерфейса совпадает с методом println
        acceptFunctional(System.out::println);

        // Реализация метода функционального интерфейса представляет собой две команды
        acceptFunctional(s -> {
            s += "2";
            System.out.println(s);
        });


        System.out.println("\n-== Функциональный интерфейс, метод которого возвращает Integer ==-");
        // Использую излишнюю разметку для наглядности
        acceptFunctionalWithReturnValue((String s) -> {
            if (s != null) {
                return s.length();
            } else {
                return 0;
            }
        });

        // Тоже самое только в сокращенном виде и с тернарным оператором
        acceptFunctionalWithReturnValue(s -> s != null ? s.length() : 0);

        // Без проверки на null используя method reference
        acceptFunctionalWithReturnValue(String::length);
    }

    private static void acceptFunctional(@NotNull Functional f) {
        // в реализацию метода function1 отправляем тестовую строку
        f.function1("testString");
    }

    private static void acceptFunctionalWithReturnValue(@NotNull FunctionalWithReturnValue f) {
        // в реализацию метода function2 отправляем тестовую строку
        Integer i = f.function2("testString3");
        System.out.println(i.toString());
    }

}
