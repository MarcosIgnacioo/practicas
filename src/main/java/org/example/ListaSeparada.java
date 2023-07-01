package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListaSeparada {
    /*
        Crea un programa que permita a los usuarios ingresar una lista de
        números enteros separados por comas. El programa debe procesar la lista
        y mostrar los números que cumplen con cierta condición utilizando las
        interfaces Predicate y Consumer.
    */
    public static void main(String[] args) {
        Predicate<String> isComma = (ListaNumeros) -> ListaNumeros.contains(",");
        Predicate<String[]> isBesidesNumber = (ListaNumeros) -> {
            for (String listaNumero : ListaNumeros) {
                if (listaNumero.equals("") || listaNumero.equals(" ")){
                    return false;
                }
            }
            return true;
        };

        Function<String, List<Integer>> toList = (ListaNumeros) -> {
            if (isComma.test(ListaNumeros)){
                String [] listaNumerosString = ListaNumeros.split(",");
                if (isBesidesNumber.test(listaNumerosString)){
                    List<Integer> listaNumerosInt =  new ArrayList<>();
                    for (String numero : listaNumerosString) {
                        listaNumerosInt.add(Integer.parseInt(numero));
                    }
                    return listaNumerosInt;
                }
            }
            return Collections.emptyList();
        };

        Scanner inputUser = new Scanner(System.in);


        System.out.println("Ingresa una lista de números separados por \",\"");
        String numbersListInput = inputUser.next();
        List<Integer> listaNumerosInt = toList.apply(numbersListInput);
        for (Integer integer : listaNumerosInt) {
            System.out.print("["+integer+"] ");
        }

        // Esta parte no es mia jeje pero asi se usa el consumer, como para entregar datos lit nomas pa eso xd
        // como un filtro loquillo
        Consumer<Integer> printNumber = num -> System.out.print("[" + num + "] ");

        System.out.println("Números pares:");
        for (Integer numero : listaNumerosInt) {
            if (numero % 2 == 0) {
                printNumber.accept(numero);
            }
        }
    }

}
