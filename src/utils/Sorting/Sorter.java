package utils.Sorting;

public abstract class Sorter {
    protected int COMPARACIONES = 0;
    protected int MOVIMIENTOS = 0;

    /**
     * Es el getter de las comparaciones
     * @return comparaciones
     */
    public int getCOMPARACIONES() {
        return COMPARACIONES;
    }

    /**
     * Es el getter de los movimientos
     * @return movimientos
     */
    public int getMOVIMIENTOS() {
        return MOVIMIENTOS;
    }

    /**
     * Es el abstract que genera el arreglo que se va cambiando según los sorters
     * @param N
     */
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

    /**
     * La lista de los sorters
     */
    public enum SorterMethods {
        BUBBLE,SELECTION,INSERTION,SHELL,MERGE,QUICK,HEAP
    }



}
