package Actividad13;

import java.util.ArrayList;
import java.util.List;

public class Mediana {

    public static int getMediana(List<Integer> nums, int k){
        int P = 0;

        //Aqui se aumenta el valor de P segun la CANTIDAD de numeros menor a k
        for (int i = 0; i < nums.size(); i++){
           if(nums.get(i) < k){
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
            return getMediana(listaCasoMenor, k - P - 1);
        }


    }
}
