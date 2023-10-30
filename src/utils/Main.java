package utils;

import utils.MathSeries.FactorialSerie;
import utils.MathSeries.FibonacciSerie;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(n);
        System.out.println("---- SERIE FIBONACCI----");
        System.out.println(FibonacciSerie.get(n));
        System.out.println("------------------------");
        System.out.println();
        System.out.println("---- SERIE FACTORIAL ----");
        System.out.println(FactorialSerie.get(n));

    }
}
