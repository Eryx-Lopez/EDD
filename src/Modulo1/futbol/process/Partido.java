package Modulo1.futbol.process;

import Modulo1.futbol.Jugador;

import java.util.LinkedList;
import java.util.Scanner;

public class Partido {
    public static LinkedList<String> nombresJugadores = new LinkedList<>();
    public static LinkedList<String> nombresJugadoresEquipo1 = new LinkedList<>();
    public static LinkedList<String> nombresJugadoresEquipo2 = new LinkedList<>();

    public static int numJugadores = 0;

    public static Jugador capitan1 = new Jugador();
    public static Jugador capitan2 = new Jugador();
    public static String jugadorEquipo1;

    public static void main(String[] args) {
        Scanner nombres = new Scanner(System.in);
        Scanner numeros = new Scanner(System.in);

        System.out.println("Vamos a jugar.");
        System.out.println("¡Capitán del equipo 1! ¿Cuál es tu nombre?");
        capitan1.isCapitan();
        capitan1.setNombre(nombres.nextLine());
        System.out.println(capitan1.getNombre() + "¿Cuál es tu número?");
        capitan1.setNumeroDeCamiseta(Integer.parseInt(numeros.nextLine()));

        System.out.println("¡Capitán del equipo 2! ¿Cuál es tu nombre?");
        capitan2.isCapitan();
        capitan2.setNombre(nombres.nextLine());
        System.out.println(capitan2.getNombre() + "¿Cuál es tu número?");
        capitan2.setNumeroDeCamiseta(Integer.parseInt(numeros.nextLine()));
        pedirNombresJugadores();
    }
    public static void pedirNombresJugadores(){
        Scanner nombres = new Scanner(System.in);
        Scanner numeros = new Scanner(System.in);

        System.out.println("Ahora vamos con los jugadores, dénme sus datos");

        while(numJugadores <= 10){
            Jugador jugador = new Jugador();
            System.out.println("¿Nombre?");
            jugador.setNombre(nombres.nextLine());
            System.out.println("¿Número?");
            if (numeros.nextLine() == String.valueOf(jugador.getNumeroDeCamiseta())){
                System.out.println("Ese número ya está ocupado, prueba con otro.");
            }
            jugador.setNumeroDeCamiseta(Integer.parseInt(numeros.nextLine()));
            nombresJugadores.add(jugador.getNombre());
            numJugadores++;
        }
        System.out.println("Ya son muchos jugadores, luego jugamos un segundo partido.");

    }
    public static void formarEquipos(){
        Scanner nombres = new Scanner(System.in);
       // Scanner numeros = new Scanner(System.in);
        int contador = 0;

        System.out.println("Ahora formemos los equipos. es turno del Capitán 1, " + capitan1.getNombre());
        System.out.println("Ingresa el nombre de tu jugador");
        
        jugadorEquipo1 = nombres.nextLine();
        nombresJugadores.remove(jugadorEquipo1);
        nombresJugadoresEquipo1.add(jugadorEquipo1);
        if (nombresJugadores.contains(jugadorEquipo1)){
            System.out.println("Este jugador ya está seleccionado, elige otro.");
        }

    }
    public static void checarNombreDelJugador(){
        nombresJugadores.remove(jugadorEquipo1);


        System.out.println("Ahora formemos los equipos. es turno del Capitán 1, " + capitan1.getNombre());
        System.out.println("Ingresa el nombre de tu jugador");
        jugadorEquipo1 = nombres.nextLine();
    }






}
