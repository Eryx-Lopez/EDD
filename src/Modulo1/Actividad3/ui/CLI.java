package Modulo1.Actividad3.ui;

import java.util.Scanner;

import static Modulo1.Actividad3.process.InfijaAPostfija.convertirNotacion;
import static Modulo1.Actividad3.process.InfijaAPostfija.resolverOpPostfija;

public class CLI {
    public static void iniciarConversor(){
        Scanner scanner = new Scanner(System.in);
        String entradaNotacion;
        System.out.println("Bienvenido. Por favor ingrese la operación que desee realizar" +
                " a través de notación posfija");
        entradaNotacion = scanner.nextLine();
        entradaNotacion = convertirNotacion(entradaNotacion);
        System.out.println();

        System.out.println("Mira, por si te interesa, así se ve tu operación INFIJA, escrita como operación POSTFIJA");
        System.out.printf(entradaNotacion);
        System.out.println();

        System.out.println("Pero ahora sí. Tu resultado es: ");
        System.out.println(resolverOpPostfija(entradaNotacion));

    }
}
