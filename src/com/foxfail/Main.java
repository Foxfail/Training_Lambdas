package com.foxfail;

import com.foxfail.interfaces.Functional;

public class Main {

    public static void main(String[] args) {
        // Реализация метода функционального интерфейса совпадает с методом println
        acceptFunctional(System.out::println);


        // Реализация метода представляет собой две команды
        acceptFunctional( s -> {
            s += "2";
            System.out.println(s);
        });

    }

    private static void acceptFunctional(Functional f){
        // в реализацию метода function1 отправляем тестовую строку
        f.function1("testString");
    }
}
