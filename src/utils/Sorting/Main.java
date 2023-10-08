package utils.Sorting;

import static utils.Sorting.PerformaceTesting.testPerformance;

public class Main {
    /**
     * Genera un testPerformance con el sorter que se desee
     * @param args
     */
    public static void main(String[] args) {
    //ACTIVIDAD 7
        // testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.BUBBLE));
        // testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.SELECTION));
        // testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.SHELL));
        // testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.INSERTION));
        System.out.println("------ MERGE SORT ------");
        testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.MERGE));
        System.out.println();

        System.out.println("------ HEAP SORT ------");
        testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.HEAP));
        System.out.println();

        System.out.println("------ QUICK SORT ------");
        testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.QUICK));
        System.out.println();

        System.out.println("------ BÚSQUEDA SECUENCIAL ------");
        testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.SECUENCIAL));
        System.out.println();

        System.out.println("------ BÚSQUEDA BINARIA ------");
        testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.BINARIA));



    }


}
