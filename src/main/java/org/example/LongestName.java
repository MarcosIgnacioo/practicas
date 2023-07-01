package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
 *
 * * Ejercicio 2 - Longitud del nombre más largo:
 * Declara una lista de strings.
 * Utiliza un Optional para almacenar el nombre más largo.
 * Convierte la lista de strings en un Stream.
 * Convierte cada nombre en su longitud correspondiente.
 * Encuentra la longitud máxima usa un método específico.
 * Si la longitud máxima es válida, imprímela. De lo contrario,
 * muestra un mensaje indicando que la lista de nombres está vacía.
 *
 * */
public class LongestName {
    static List<String> namesList = new ArrayList<>();
    static String userAnswer = "Yes";
    static Scanner reader = new Scanner(System.in);
    static Predicate<String> isNo = answer -> answer.equals("no");
    static Supplier<Optional> naN = () -> Optional.of("Doesnt exist");
    public static void main(String[] args) {
        while(!userAnswer.equals("no")){
            System.out.println("Type a name or \"no\" to end");
            userAnswer = reader.next();
            if(!isNo.test(userAnswer)){
                Optional<String> userAnswer = answerSaver();
                userAnswer.ifPresent(text -> namesList.add(text));
            }
        }
        Optional<String> longestName = longestName(namesList);
        System.out.println("Longest name");
        longestName.ifPresent(System.out::println);
        Stream<Integer> lenghtOfNames = namesList.stream().map(String::length);
        System.out.println("Lengths list");
        lenghtOfNames.forEach(System.out::println);
        Optional<String> longestLenght = longestLenght(namesList.stream().map(String::length));
        System.out.println("Longest length: ");
        longestLenght.ifPresent(System.out::println);
    }
    static Optional<String> longestName(List<String> list){
        return Optional.of(list.stream().max(Comparator.comparingInt(String::length)).orElse("The list is empty"));
    }
    static Optional<String> answerSaver(){
        return Optional.of(userAnswer);
    }
    static Optional<String> longestLenght(Stream<Integer> stream){
        return Optional.of(stream.max(Comparator.naturalOrder()).map(Object::toString).orElse("List is empty"));
    }
    
}
