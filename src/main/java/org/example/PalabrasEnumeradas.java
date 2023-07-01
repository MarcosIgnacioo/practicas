package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PalabrasEnumeradas {

    /*Crea un programa que tome una lista de palabras como entrada del usuario.
    Utiliza un "Predicate" para filtrar solo las palabras que tengan más de 5 caracteres.
    Usa un Function para convertir cada palabra filtrada en su longitud
    y muestra el resultado usando un Consumer.
    */

    static Scanner reader = new Scanner(System.in);
    static String userAnswer = "yes";

    public static void main(String[] args) {
        Predicate <String> isLonger = word -> word.length() > 5;
        Consumer<List<String>> wordSizes = wordList ->{
            for (String word:
                    wordList) {
                System.out.println("La palabra  es: " + word);
                System.out.println("La longitud es: " + word.length());
                System.out.println("------------------------------");
            }
        };
        List<String> userWordList = new ArrayList<>();
        while(!userAnswer.equals("No")){
            System.out.println("Escribe una palabra");
            userAnswer = reader.next();
            if (isLonger.test(userAnswer)) userWordList.add(userAnswer);
        }
        wordSizes.accept(userWordList);
    }

}
