package utils.Sorting;

import static utils.Sorting.PerformaceTesting.testPerformance;

public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Selection();
        testPerformance(sorter);
    }
}
