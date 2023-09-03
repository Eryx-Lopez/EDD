package Modulo1.Actividad2.pasajeros.process;

import utilsMenu.Menu;
import utilsMenu.MenuAction;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Es la clase encargada de crear, eliminar y visualizar los pasajeros
 */
public class Pasajeros {
   public static LinkedList<String> nombresPasajeros = new LinkedList<>();

    public static Menu menuPasajeros = new Menu();
    // OPTIONS
    public static final String agregarPasajerosOption = "Agregar pasajero";
    public static final String eliminarPasajerosOption = "Eliminar pasajero";
    public static final String visualizarPasajerosOption = "Visualizar pasajeros";

    // ACTIONS
    /**
     * Es la acción para agregar los pasajeros a la lista
     */
    public static final MenuAction agregarPasajerosAction = (scanner) -> {
        String pasajeroAgregado;
        Scanner scannerAgregar = new Scanner(System.in);
        System.out.println("Ingrese el nombre del pasajero");
        pasajeroAgregado = scannerAgregar.nextLine();
        nombresPasajeros.add(pasajeroAgregado);

        System.out.println("Pasajero agregado con éxito.");
        System.out.println("Regresando al menú...");

    };
    /**
     * Es la acción para eliminar los pasajeros de la lista
     */
    public static final MenuAction eliminarPasajerosAction = (scanner) -> {
        String pasajeroEliminado;
        Scanner scannerEliminar = new Scanner(System.in);
        System.out.println("Ingrese el nombre del pasajero a eliminar");
        pasajeroEliminado = scannerEliminar.nextLine();
        boolean eliminar = nombresPasajeros.remove(pasajeroEliminado);
        if (eliminar == true){
            System.out.println("Pasajero eliminado.");
        } else if( eliminar == false){
            System.out.println("No se encontró al pasajero, intente de nuevo.");
        }
    };

    /**
     * Es la acción para visualizar la lista de los pasajeros
     */
    public static final MenuAction visualizarPasajerosAction = (scanner) -> {
        System.out.println(nombresPasajeros.toString());
    };

    static {
       menuPasajeros
               .addOption(agregarPasajerosOption,agregarPasajerosAction);
       menuPasajeros
               .addOption(eliminarPasajerosOption,eliminarPasajerosAction);
       menuPasajeros
               .addOption(visualizarPasajerosOption,visualizarPasajerosAction);
       menuPasajeros
               .createMenu();

    }

}
