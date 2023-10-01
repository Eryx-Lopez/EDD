package utils.Sorting;
import java.util.Arrays;
import java.util.Random;

public class PerformaceTesting {
    public static int COMPARACIONES = 0;
    public static int MOVIMIENTOS = 0;
    public static void testPerformance(Sorter sorter ) {
        final int RANGO = 1_000;
        final int ITERACIONES = 500; //Cuántas veces voy a hacer la misma prueba.
        final int INCREMENTOS = 100;

        double[][] performanceResults = new double[RANGO / INCREMENTOS][2];

        for (int N = 1, k = 0; N <= RANGO; N += INCREMENTOS, k++) {
            // llamar 500 veces cada algoritmo
            COMPARACIONES = 0;
            MOVIMIENTOS = 0;
            for (int i = 0; i < ITERACIONES; i++) {
                int[] array = getRandomArray(N, Short.MIN_VALUE, Integer.MAX_VALUE);
                sorter.sort(array);

            }
            performanceResults[k][0] += sorter.getCOMPARACIONES();
            performanceResults[k][1] += sorter.getMOVIMIENTOS();
            performanceResults[k][0] = performanceResults[k][0] / ((double) ITERACIONES);
            performanceResults[k][1] = performanceResults[k][1] / ((double) ITERACIONES);
        }
        
        for(double[] results: performanceResults)
            System.out.println(Arrays.toString(results)
                    .replace("[","")
                    .replace("]",""));
    }
    public static int[] getRandomArray(int n, int minVal, int maxVal) {
        Random random = new Random();
        return random.ints(n, minVal, maxVal).toArray();
    }


}
