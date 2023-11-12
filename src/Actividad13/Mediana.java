package Actividad13;

import java.util.ArrayList;
import java.util.List;

public class Mediana {
    /**
     * Es el método para sacar la mediana
     * @param nums es la lista de la cual se quiere sacar la mediana
     * @param k el objetivo o elemento esperado
     * @return la mediana o bien, la confirmación del elemento esperado
     */
    public static int getMediana(List<Integer> nums, final int k){
        //Número de elementos más pequeños que Lk
        int P = 0;

        //Aqui se aumenta el valor de P según la CANTIDAD de números menor a k
        for (int i = 0; i < nums.size(); i++){
           if(nums.get(i) < nums.get(k)){
               P++;
           }
        }
        if(P == k){
           return nums.get(k);
        } else if (P > k){
            List listaCasoMayor = new ArrayList<>();

            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) < nums.get(k)){
                    listaCasoMayor.add(nums.get(i));
                }
            }
            return getMediana(listaCasoMayor, k);
        }else {
            List listaCasoMenor = new ArrayList<>();

            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) > nums.get(k)){
                    listaCasoMenor.add(nums.get(i));
                }
            }
            return getMediana(listaCasoMenor, k - P - 1) - 1; //Este 1 es para que me dé el número de la izquierda, el cual sería 5 en este caso
        }


    }
}
