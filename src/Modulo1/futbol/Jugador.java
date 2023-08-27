package Modulo1.futbol;

public class Jugador {
public String nombre;
public String numeroDeCamiseta;
public  boolean capitan;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDeCamiseta() {
        return numeroDeCamiseta;
    }

    public void setNumeroDeCamiseta(String numeroDeCamiseta) {
        this.numeroDeCamiseta = numeroDeCamiseta;
    }

    public boolean isCapitan() {
        return capitan;
    }

    public void setCapitan(boolean capitan) {
        this.capitan = capitan;
    }
}
