package utils.Sorting;

import static utils.Sorting.PerformaceTesting.testPerformance;

public class Main {
    /**
     * Genera un testPerformance con el sorter que se desee
     * @param args
     */
    public static void main(String[] args) {
        testPerformance(SorterFactory.getSorter(Sorter.SorterMethods.MERGE));

    }


}
