package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/*
Ejercicio 1 - Producto de los dígitos de un número:
     * Declara un número entero.
     * Utiliza Optionals y Streams para calcular el producto de los dígitos del número.
     * Convierte el número en una cadena de caracteres.
     * Convierte cada carácter en un dígito entero.
     * Calcula el producto de los dígitos utilizando un método específico.
     * Si el producto es válido, imprímelo. De lo contrario,
     muestra un mensaje indicando que el número es inválido o no tiene dígitos.
 */
public class ProductOfDigits {
    static Function <String, List<Integer>> toList = text ->{
        List<Integer> digitsList = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            digitsList.add(Integer.parseInt(String.valueOf(text.charAt(i))));
        }
        return digitsList;
    };
    public static void main(String[] args) {
        Integer num = 1234;
        System.out.println(num.describeConstable());
        System.out.println(num.longValue());
        System.out.println(num.toString().indexOf("4"));
        int sum = 0;
        Optional<Integer> result = toList.apply(num.toString()).stream().reduce(Integer::sum);
        //toList.apply(num.toString()).stream().forEach((n, n2) -> n + n2);
        System.out.println(result.get());

        System.out.println("----------");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> suma = numeros.stream()
                .reduce((num1, num2) -> num1 + num2);

        suma.ifPresent(System.out::println);

    }
        /*
        * el metodo reduce sirve para realizar operaciones con el stream, mientras se almacena el resultado anterior
        * y se le aplica de manera iterativa, si se quiere hacer reseteo de variable creo que será con atomic integer
        *
        * */
    }

