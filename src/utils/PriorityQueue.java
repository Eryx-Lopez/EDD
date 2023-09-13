package utils;

import java.util.LinkedList;

public class PriorityQueue <E extends Comparable> {
    LinkedList<E> lista = new LinkedList<>();

    //Te da el indíce del Parent
    public int getParent (int k){
        if(k == 0) k = 1;
        return ((k+1)/2)-1;
    }

    public int getLeft(int k){
        return (2 * k + 1);
    }

    public int getRight(int k){
        return (2 * k + 2);
    }

    private void heapify(){
        int index = 0;
        int left = getLeft(index);
        int right = getRight(index);
        int child;

        while(true){
            int parent = getParent(left);
            while (parent >= 0 && left < lista.size()) {
                if (lista.get(left).compareTo(lista.get(parent)) > 0) {
                    swap(lista, left, parent);
                }
                parent = getParent(parent);
                index++;
                left = getLeft(index);
                right = getRight(index);
              //  if(left< lista.size() && right< lista.size()) {
                //    child = (lista.get(left).get().compareTo(lista.get(right).get()) > 0) ? left > right ? left : right; //es un boolean, si la cumple, devuelve el valor de la izquierda
                    // y si no, el de la derecha
                //}
            }
        }
    }

    public E poll() {
        heapify();
        return lista.poll();
    }
    private void swap(LinkedList<E> lista, int origin, int target){
        E tmp = lista.get(origin);
        lista.set(origin, lista.get(target));
        lista.set(target,tmp);
    }
}
