package Modulo1.Actividad2.utils;

import utils.Queue;

import java.util.Optional;

public class PriorityQueue <Integer> extends Queue<E> {

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
        int parent = getParent(left);

        while(true){


            while (parent > 0) {
                if (lista.get(left) > (lista.get(parent))) {
                    int tmp = lista.get(parent);
                    lista.set(parent, lista.get(left));
                    lista.set(left, tmp);
                }
                parent = getParent(parent);

                index++;
            }
        }
    }
    @Override
    public Optional<E> poll() {
        heapify();
        return super.poll();
    }
}
