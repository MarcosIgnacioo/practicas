package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PositiveAverage {
    static Scanner reader = new Scanner(System.in);
    static List<Integer> numbersList = new ArrayList<>();
    static String userAnswer = "Yes";

    static Predicate<Integer> isPositive = x -> x >= 0;
    static Predicate<String> isInt = x -> (
            x.contains("0") ||
                    x.contains("1") ||
                    x.contains("2") ||
                    x.contains("3") ||
                    x.contains("4") ||
                    x.contains("5") ||
                    x.contains("6") ||
                    x.contains("7") ||
                    x.contains("8") ||
                    x.contains("9")
    );

    static Function<String,Integer> toInt = Integer::parseInt;
    static BiConsumer<Integer, Integer> sum = Integer::sum;

    public static void main(String[] args) {
        while (!userAnswer.equals("no")){
            System.out.println("Insert a number, negative or positive");
            userAnswer = reader.next();
            if(isInt.test(userAnswer)){
                numbersList.add(toInt.apply(userAnswer));
            }
        }
        numbersList.forEach(System.out::println);

        List<Integer> positiveNumbers = numbersList.stream().filter(x -> x >= 0).toList();
        System.out.println(getQuantity(positiveNumbers).get());
        System.out.println(getSum(positiveNumbers).get());

    }
    static Optional<Integer> getQuantity(List<Integer> list){
        return Optional.of(list.size());
    }
    static Optional<Integer> getSum(List<Integer> list){
        int sum = 0;
        for (Integer num:
             list) {
            sum += num;
        }
        return Optional.of(sum);
    }
}
