package utils.Sorting;

public abstract class Sorter {
    protected int COMPARACIONES = 0;
    protected int MOVIMIENTOS = 0;

    public int getCOMPARACIONES() {
        return COMPARACIONES;
    }

    public int getMOVIMIENTOS() {
        return MOVIMIENTOS;
    }

    public abstract void sort(int[] N);

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


    public enum SorterMethods {
        BUBBLE,SELECTION,INSERTION,SHELL,MERGE,QUICK,HEAP
    }



}
