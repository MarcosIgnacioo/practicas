package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class EvenNumbers {
    /*Escribe un programa que genere una lista de números
    enteros aleatorios utilizando un Supplier.
    Luego, usa un "Predicate" para filtrar solo los números pares.
    Haz un Function para sumar todos los números pares y muestra
    el resultado con un Consumer.*/
    static Random random = new Random();

    public static void main(String[] args) {
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Supplier<List<Integer>> randomNumbersGenerator = () ->{
          List<Integer> randomNumbersList = new ArrayList<>();
          int listSize = random.nextInt(999);
            for (int i = 0; i < listSize; i++) {
                int randomNumberGenerated = random.nextInt(999);
                randomNumbersList.add(randomNumberGenerated);
            }
            return randomNumbersList;
          };
        Consumer <Integer> showResult = System.out::println;

        Function<List<Integer>, Integer> addAllEvens = RandomNumbersList ->{
            int sumOfAllEvens = 0;
            for (Integer number:
                 RandomNumbersList) {
                if (isEven.test(number)) sumOfAllEvens += number;
            }
            return sumOfAllEvens;
        };
        showResult.accept(addAllEvens.apply(randomNumbersGenerator.get()));
    }
}
