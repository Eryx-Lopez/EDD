package Modulo1.Actividad2.ui;

import Modulo1.Actividad2.process.Partido;

/**
 * CLI manda a llamar los métodos creados en process
 */
public class CLI {
    public static void showMatch(){
        Partido.pedirNombresCapitanes();
        Partido.pedirNombresJugadores();
        Partido.formarEquipos();
        Partido.imprimirEquipos();

    }
}
