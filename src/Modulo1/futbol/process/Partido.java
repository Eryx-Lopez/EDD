package Modulo1.futbol.process;

import Modulo1.futbol.Jugador;

import java.util.LinkedList;
import java.util.Scanner;

public class Partido {
    public static LinkedList<String> nombresJugadores = new LinkedList<>();
    public static LinkedList<String> nombresJugadoresEquipo1 = new LinkedList<>();
    public static LinkedList<String> nombresJugadoresEquipo2 = new LinkedList<>();

    public static Jugador capitan1 = new Jugador();
    public static Jugador capitan2 = new Jugador();

    public static void main(String[] args) {
        int numJugadores = 0;

        Scanner nombres = new Scanner(System.in);
        Scanner numeros = new Scanner(System.in);
        System.out.println("Vamos a jugar.");
        System.out.println("¡Capitán del equipo 1! ¿Cuál es tu nombre?");
        capitan1.isCapitan();
        capitan1.setNombre(nombres.nextLine());
        System.out.println(capitan1.getNombre() + "¿Cuál es tu número?");
        capitan1.setNumeroDeCamiseta(numeros.nextLine());

        System.out.println("¡Capitán del equipo 2! ¿Cuál es tu nombre?");
        capitan2.isCapitan();
        capitan2.setNombre(nombres.nextLine());
        System.out.println(capitan2.getNombre() + "¿Cuál es tu número?");
        capitan2.setNumeroDeCamiseta(numeros.nextLine());

        System.out.println("Ahora vamos con los jugadores, dénme sus datos");
        while(numJugadores <= 10){
            Jugador jugador = new Jugador();
            System.out.println("¿Nombre?");
            jugador.setNombre(nombres.nextLine());
            System.out.printf("¿Número?");
            jugador.setNumeroDeCamiseta(numeros.nextLine());
            nombresJugadores.add(jugador.getNombre());
            numJugadores++;
        }
        System.out.println("Ya son muchos jugadores, luego jugamos un segundo partido.");

    }






}
