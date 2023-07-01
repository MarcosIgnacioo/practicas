package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NumerosEnteros {
    /*Desarrolla un programa que genere una lista de números enteros aleatorios utilizando un Supplier.
    Luego, usa un "Predicate" para filtrar solo los números mayores a 50.
    Utiliza un Function para calcular el cuadrado de cada número filtrado
    y muestra el resultado utilizando un Consumer*/
    public static void main(String[] args) {
        Random rnd = new Random();
        Predicate<Integer> greaterThan50 = x -> x > 50;

        Supplier<List<Integer>> randomNumbers = () ->{
            int limiterListSize = rnd.nextInt(999);
            List<Integer> randomNumbersList = new ArrayList<>();
            for (int i = 0; i <limiterListSize; i++) {
                int randomNumgerGenerated = rnd.nextInt(200);
                if (greaterThan50.test(randomNumgerGenerated)) randomNumbersList.add(randomNumgerGenerated);
            }
            return randomNumbersList;
        };

        Function<List<Integer>,List<Integer>> squareGreaters = randomNumbersList ->{
            List<Integer> squaredUpList = new ArrayList<>();
            for (Integer integer : randomNumbersList) {
                System.out.println("Normal number: " + integer);
                System.out.println("Squared number: " + integer*integer);
                squaredUpList.add(integer * integer);
            }
            return  randomNumbersList;
        };

        List<Integer> randomNumbersList = randomNumbers.get();
        squareGreaters.apply(randomNumbersList);
    }
}
