package Modulo1.Actividad2.process;


import Modulo1.Actividad2.Models.Jugador;

import java.util.LinkedList;
import java.util.Scanner;

public class Partido {
    public static LinkedList<String> nombresJugadores = new LinkedList<>();
    public static LinkedList<Integer> numerosCamisetaJugadores = new LinkedList<>();
    public static LinkedList<String> nombresJugadoresEquipo1 = new LinkedList<>();
    public static LinkedList<String> nombresJugadoresEquipo2 = new LinkedList<>();

    public static int numJugadores = 0;

    public static Jugador capitan1 = new Jugador();
    public static Jugador capitan2 = new Jugador();
    public static String jugadorEquipo1;
    public static String jugadorEquipo2;

    /**
     * Pide los nombres y números de los capitanes del equipo
     */
    public static void pedirNombresCapitanes(){
        Scanner nombres = new Scanner(System.in);
        Scanner numeros = new Scanner(System.in);
        System.out.println("Vamos a jugar.");
        System.out.println("¡Capitán del equipo 1! ¿Cuál es tu nombre?");
        capitan1.isCapitan();
        capitan1.setNombre(nombres.nextLine());
        nombresJugadoresEquipo1.add(capitan1.nombre);
        System.out.println(capitan1.getNombre() + "¿Cuál es tu número?");
        capitan1.setNumeroDeCamiseta((numeros.nextInt()));
        numerosCamisetaJugadores.add(capitan1.numeroDeCamiseta);

        System.out.println("¡Capitán del equipo 2! ¿Cuál es tu nombre?");
        capitan2.isCapitan();
        capitan2.setNombre(nombres.nextLine());
        nombresJugadoresEquipo2.add(capitan2.nombre);
        System.out.println(capitan2.getNombre() + "¿Cuál es tu número?");
        capitan2.setNumeroDeCamiseta((numeros.nextInt()));
        if (numerosCamisetaJugadores.contains(capitan2.numeroDeCamiseta)) {
            System.out.println("Ese número ya está ocupado, prueba con otro.");
            capitan2.setNumeroDeCamiseta((numeros.nextInt()));
        }
        numerosCamisetaJugadores.add(capitan2.numeroDeCamiseta);
    }
    /**
     * Pide los nombres, números de los jugadores y se asegura de que el número no esté repetido
     */
    public static void pedirNombresJugadores() {
        Scanner nombres = new Scanner(System.in);
        Scanner numeros = new Scanner(System.in);

        System.out.println("Ahora vamos con los jugadores, dénme sus datos");

        while (numJugadores <= 10) {
            Jugador jugador = new Jugador();
            System.out.println("¿Nombre?");
            jugador.setNombre(nombres.nextLine());
            System.out.println("¿Número?");
            jugador.setNumeroDeCamiseta(numeros.nextInt());
            if (numerosCamisetaJugadores.contains(jugador.numeroDeCamiseta)) {
                System.out.println("Ese número ya está ocupado, prueba con otro.");
                jugador.setNumeroDeCamiseta((numeros.nextInt()));
            }
            numerosCamisetaJugadores.add(jugador.numeroDeCamiseta);
            nombresJugadores.add(jugador.getNombre());
            numJugadores++;
        }
        System.out.println("Ya son muchos jugadores, luego jugamos un segundo partido.");

    }

    /**
     * Aquí ya se empiezan a formar los equipos, intercalando el turno del capitán 1 y del capitán 2
     */
    public static void formarEquipos() {
        Scanner nombres = new Scanner(System.in);
        int contador = 0;

        System.out.println("Ahora formemos los equipos.");
        while (contador <= 5) {
            System.out.println("Es turno del Capitán 1, " + capitan1.getNombre());
            System.out.println("Ingresa el nombre de tu jugador");
            jugadorEquipo1 = nombres.nextLine();
            if (!nombresJugadores.contains(jugadorEquipo1)) {
                System.out.println("Este jugador ya está seleccionado, elige otro.");
            }
            nombresJugadores.remove(jugadorEquipo1);
            nombresJugadoresEquipo1.add(jugadorEquipo1);


            System.out.println("Es turno del Capitán 2, " + capitan2.getNombre());
            System.out.println("Ingresa el nombre de tu jugador");
            jugadorEquipo2 = nombres.nextLine();
            if (!nombresJugadores.contains(jugadorEquipo2)) {
                System.out.println("Este jugador ya está seleccionado, elige otro.");
            }
            nombresJugadores.remove(jugadorEquipo2);
            nombresJugadoresEquipo2.add(jugadorEquipo2);
            contador++;

        }
    }

    /**
     * Imprime los equipos
     */
    public static void imprimirEquipos(){
        System.out.println("EQUIPO 1");
        System.out.println(nombresJugadoresEquipo1.toString());
        System.out.println();
        System.out.println("EQUIPO 2");
        System.out.println(nombresJugadoresEquipo2.toString());


    }
}