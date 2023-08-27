package Modulo1.futbol.ui;

import static Modulo1.futbol.process.Partido.*;

public class CLI {
    public static void showMatch(){
        pedirNombresCapitanes();
        pedirNombresJugadores();
        formarEquipos();
        imprimirEquipos();

    }
}
