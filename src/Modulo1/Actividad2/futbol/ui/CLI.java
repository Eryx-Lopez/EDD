package Modulo1.Actividad2.futbol.ui;

import static Modulo1.Actividad2.futbol.process.Partido.*;

/**
 * CLI manda a llamar los métodos creados en process
 */
public class CLI {
    public static void showMatch(){
        pedirNombresCapitanes();
        pedirNombresJugadores();
        formarEquipos();
        imprimirEquipos();

    }
}
