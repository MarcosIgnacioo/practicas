package org.example.Employment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;

public class EvenNumbersSum {
    static List <Integer> intergersList = new ArrayList<>();
    static String userAnswer = "yes";
    static Scanner reader = new Scanner(System.in);

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
    static Function<String, Integer> toInt = Integer::parseInt;
    static Predicate<Integer> isEven = x -> x % 2 == 0;
    static Function<List<Integer>,List<Integer>> filterEven = list ->{
        List<Integer> filteredList = new ArrayList<>();
        list.forEach(number -> {
            Optional<Integer> element = Optional.ofNullable(number);
            element.filter(n -> isEven.test(n)).ifPresent(filteredList::add);
        });
        return filteredList;
    };

    public static void main(String[] args) {
        while(!userAnswer.equals("no")){
            System.out.println("Insert the number, type \"no\" to stop adding numbers and sum every even number");
            userAnswer = reader.next();
            if (isInt.test(userAnswer)) intergersList.add(toInt.apply(userAnswer));
        }
        intergersList = filterEven.apply(intergersList);
        Optional<Integer> sumOfAll = sum(intergersList);
        sumOfAll.ifPresent(System.out::println);
    }
    static Optional<Integer> sum(List<Integer> list){
        AtomicInteger sum = new AtomicInteger();
        list.forEach(number -> {
            Optional<Integer> num = Optional.ofNullable(number);
            num.ifPresent(sum::addAndGet);
        });
        return Optional.of(sum.get());
    }
}
