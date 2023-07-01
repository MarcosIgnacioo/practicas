package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 Ejercicio 4- Concatenación de strings no vacíos:

     * Declara una lista de strings.
     * Utiliza Optionals y Streams para concatenar los strings no vacíos en la lista.
     * Filtra los strings no vacíos utilizando una condición.
     * Concatena los strings filtrados utilizando un método específico.
     * Si la concatenación es válida y no está vacía, imprímela.
     * De lo contrario, muestra un mensaje indicando que no hay strings no vacíos en la lista.
     *
*/
public class ConcatNotEmptyStrings {
    static Scanner reader =  new Scanner(System.in);
    static String userAnswer = "Yes";
    static List<String> stringList = new ArrayList<>();
    static BinaryOperator<String> concanete = String::concat;

    public static void main(String[] args) {
        while(!userAnswer.equals("no")){
            System.out.println("Type your word");
            userAnswer = reader.next();
            if (!userAnswer.equals("no")) stringList.add(userAnswer);
        }
        String previousText = "";
        // Hacer un stream en el que se filtren todos los string no vacíos
        Stream <String> notEmptyList = stringList.stream().filter(element -> !element.isEmpty());
        Optional<String> concatenated = Optional.of(notEmptyList.collect(Collectors.joining())).orElse("Optional.of()").describeConstable();
        System.out.println(concatenated.get());

        /*
        * Para hacer cosas más de strings con un stream, se debe de usar el collect porque ahi hay un joining y asi
        *
        * */
    }
}
