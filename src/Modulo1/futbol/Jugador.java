package Modulo1.futbol;

/**
 * Es la clase que se encarga de guardar los datos de nombre, camiseta y de si es capitán o no
 */
public class Jugador {
public String nombre;
public int numeroDeCamiseta;
public  boolean capitan;

    @Override
    public String toString() {
        return "Jugadores" +
                "Nombre:'" + nombre + '\'' +
                ", Número;" + numeroDeCamiseta +
                ", Capitán:" + capitan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDeCamiseta() {
        return numeroDeCamiseta;
    }

    public void setNumeroDeCamiseta(int numeroDeCamiseta) {
        this.numeroDeCamiseta = numeroDeCamiseta;
    }

    public boolean isCapitan() {
        return capitan;
    }

    public void setCapitan(boolean capitan) {
        this.capitan = capitan;
    }
}
