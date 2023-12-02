package Actividad13;

import java.util.ArrayList;
import java.util.List;

/**
 * Es la clase main en donde se crea una lista y se agregan los números deseados, al igual que el elemento esperado
 * Se le asigna a una variable llamada result el resultado del método getMedianda de la clase Mediana y luego se
 * imprime dicho resultado.
 *
 *     ()-().----.          .
 *      \"/` ___  ;________.'
 *       ` ^^   ^^
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(6);
        nums.add(8);
        nums.add(4);
        nums.add(2);
        nums.add(7);
        nums.add(27);
        nums.add(1);
        nums.add(15);
        nums.add(5);
        //Elemento esperado
        int k = 5;
        int result = Mediana.getMediana(nums, k);
        System.out.println("La mediana es " + result);

    }
}
