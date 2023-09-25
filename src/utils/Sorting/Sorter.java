package utils.Sorting;

import java.util.Arrays;
import java.util.Random;

public abstract class Sorter {
    public int COMPARACIONES = 0;
    public int MOVIMIENTOS = 0;

    public int getCOMPARACIONES() {
        return COMPARACIONES;
    }

    public int getMOVIMIENTOS() {
        return MOVIMIENTOS;
    }

    public abstract void sort(int[] N);

    /**
     *
     * @param n
     * @param minVal valor mínimo del arreglo
     * @param maxVal valor máximo del arreglo
     * @return regresa un arreglo con valores aleatorios
     */
    public static int[] getRandomArray(int n, int minVal, int maxVal){
        Random random = new Random();
        return random.ints(n, minVal, maxVal).toArray();
    }

    /**
     * Intercambia dos valores
     *
     * @param N el arreglo de enteros
     * @param i primer índice dentro del arreglo
     * @param j segundo índice dentro del arreglo
     */
    public static void swap(int[] N, int i, int j){
        int tmp = N[i];
        N[i] = N[j];
        N[j] = tmp;

    }

    /**
     * Imprime el arreglo
     * @param N arreglo de elementos enteros
     */
    private static void printArray(int[] N){
        System.out.println(Arrays.toString(N));
    }

    /**
     *
     * @param N es el arreglo de los elementos que se mandan a verificar si están ordenados
     * @return si no están ordenados, devuelve false, y si lo están, devuelve true.
     */
    public static boolean isSorted(int[] N){
        for(int i = 0; i < N.length-1; i++){
            if(N[i] < N[i+1]){
                return false;
            }
        }
        return true;
    }



}
