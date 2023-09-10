package Modulo1.pasajeros.ui;

import static Modulo1.pasajeros.process.Pasajeros.menuPasajeros;

/**
 * Corre el menú creado en process
 */
public class CLI {
    public static void showMenu(){
        System.out.println("Bienvenido a Autobuses Alfa.");
        do {
            menuPasajeros.showMenu();
            var option = menuPasajeros.readOption();
            menuPasajeros.selectAndRunOption(option);
        } while (menuPasajeros.isAlive());
    }

}
