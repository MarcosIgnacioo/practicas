package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class Utils {
    public static void main(String[] args) {
        ad<Integer, Integer, Integer, Integer, Integer> popo = (a,b,c,d) -> a+b+c+d;
        System.out.println(popo.apply(1,2,3,4));

    }
    @FunctionalInterface
    interface ad<T,U,D,F,R>{
        R apply(T t, U u, D d, F f);
    }
}

