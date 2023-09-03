package Modulo1.Actividad3.ui;

import java.util.Scanner;

public class CLI {

        public static void iniciarConversor(){
            Scanner scanner = new Scanner(System.in);
            String entradaNotacion;
            System.out.println("Bienecnido. Por favor ingrese la operación que desee realizar" +
                    " a través de notación posfija");
            entradaNotacion = scanner.nextLine();


            System.out.println("Esta operación en notación postfija se escribe como:");

            System.out.println("El resultado de esta operación es:");

        }
    }
}
