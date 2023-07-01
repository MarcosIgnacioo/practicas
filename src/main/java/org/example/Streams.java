package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> courseList = NombresUtils.getList(
     "Java!",
                "Backend!",
                "Frontend!",
                "Fullstack!");
        for (String course:
             courseList) {
            String newCourseName = course.toLowerCase().replace("!", "!!!");
            System.out.println("Platzi: "+newCourseName);
        }
        Stream<String> coursesStream = Stream.of("Java", "Backend", "Frontend");

        //Stream<Integer> streamOfLenghts = coursesStream.map(String::length);
        //Stream<String> justJavaCourses = coursesStream.filter(course -> course.contains("Java"));
        //justJavaCourses.forEach(System.out :: println);
        /*
        * Los streams son una chingadera mágica que nadie sabe bien que onda con ellos, son como
        * si fueran listas, pero no almacenan los datos en una estructura de datos, se puede crear un stream
        * a partir de una lista, con el método stream sobre la lista, y realizar las funciones que
        * se deseen sobre la misma con el método map o filter, sin embargo, solamente
        * se puede hacer una chingadera a un stream asi que elige sabiamente!, aunque de seguro hay más
        * maneras de enfrentar este pedillo.
        *
        *
        * */
        Stream<String> coursesStream2 = courseList.stream();
        addOperator(coursesStream2.map(course -> course + "!!").
                filter(course -> course.contains("Java"))).
                forEach(System.out::println);
        // SI, SE PUEDE ASI CON CHAINING razón: Chainning es como ir almacenando en variables a cada rato porque
        // se está devolviendo el objeto cambiado, asi que boom, pero asi se mira más gamer
        /*
        * Muchas veces se van a hacer funciones custom en las que das un stream como parametro y devuelves
        * el propio stream cambiando lo que sea que quieras cambiar, por ejemplo en addOperator se hace un printline
        * del stream que se le pasa, y luego devuevle el mismo stream al que se le hace un foreach:
        *
        * con el siguiente output puesto que se filtró primero que contenga la palabra java y ya se le agregaron
        * los !! extra
        *
        * Dato: Java!!!
        * Java!!!
        *
        * */
    }
    static <T>Stream<T> addOperator(Stream<T> stream){
        return stream.peek(dato -> System.out.println("Dato: " + dato));
        // peek sirve para ver
    }
}
