package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class NombresUtils {
    public static void main(String[] args) {

        Function<Integer, String> addCeros = x -> x < 10 ? "0" + x : String.valueOf(x);

        TriFunction<Integer, Integer, Integer, LocalDate> parseDate  =
                (day,month,year) -> LocalDate.parse
                        (year + "-" + addCeros.apply(month) + "-" + addCeros.apply(day));

        TriFunction<Integer, Integer, Integer, Integer> calculateAge =
                (day, month, year) -> Period.between(
                        parseDate.apply(day,month,year), LocalDate.now()
                ).getYears();

        System.out.println(calculateAge.apply(10,10,2003));

        /*
         * Okay, aquí está cabrón, se pueden crear funciones con can la cantidad de parámetros que quieras y del tipo
         * que se quiera, aqui por ejemplo se crearon 3 funciones para calcular la edad de una persona segun su fecha
         * de nacimiento; La funcion de calcular la edad, usa la clase Period proveniente de la clase "time", esta misma
         * trae un método que permite calcular la diferencia de tiempo entre dos fechas, sin embargo, para eso ambas
         * ocupan estar en el formato de LocalDate, asi que, para hacer eso, se llama a la otra función personalizada
         * parseDate, que lo que hace es tomar 3 Integer y, con el método parse se formatean a eso, sin embargo,
         * hay otro problema y es que las fechas en este formato, si son dias o meses menores a 10 tienen que tener
         * si o si un 0 antes, asi que, dentro de parseDate, cuando se está haciendo LocalDate.parse se llama a otra
         * función, que es una simple, llamada addCeros, la cual, checa si el numero que se está pasando como parámetro
         * menor a 10, si es asi, se pega un 0 al número y si no es asi, simplmente devuelve el String del mismo número,
         * se tiene que devolver en string porque es la única manera de poner un 0 a la izquierda de un número y
         * porque el método parse tiene como parámetro un String; y aunque si bien, se podria regresar simplemente el int
         * la funcion al regresar String no puede hacer esto asi que realmente ese escenario no se puede nya
         * */
    }
    @FunctionalInterface
    interface TriFunction<T, U, V, R>{
        R apply(T t, U u, V v); // appply es un método que va a devolver R a la cual se le pasan como parámetros
        // T, U y V
    }


    @FunctionalInterface
    interface asd<T, U, V, R>{
        R apply(T t, U u, V v); // appply es un método que va a devolver R a la cual se le pasan como parámetros
        // T, U y V
    }
    @FunctionalInterface
    interface ad<T,U,D,R>{
        R apply(T t, U u, D d);
    }

    @SafeVarargs
    public static <T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }
}
