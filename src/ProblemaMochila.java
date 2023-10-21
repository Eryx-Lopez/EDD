import java.util.ArrayList;
import java.util.Collections;

public class ProblemaMochila {
    public static void main(String[] args) {
        int maxPeso = 9;

        //Precios individuales
        Producto arroz = new Producto("Arroz", 28, 4, 0);
        arroz.setPrecioUnitario(arroz.getCosto()/arroz.getStock());

        Producto frijol = new Producto("Frijol", 30, 5,0 );
        frijol.setPrecioUnitario(frijol.getCosto()/ frijol.getStock());

        Producto almendra = new Producto("Almendra", 24, 3,0);
        almendra.setPrecioUnitario(almendra.getCosto()/ almendra.getStock());

       //Agregar los valores al array
        ArrayList preciosUnitarios = new ArrayList<>();
        preciosUnitarios.add(arroz.getPrecioUnitario());
        preciosUnitarios.add(frijol.getPrecioUnitario());
        preciosUnitarios.add(almendra.getPrecioUnitario());

        Collections.sort(preciosUnitarios);
        System.out.println(preciosUnitarios);
int precioFinal = 0;

        for(int i = 0; i < preciosUnitarios.size(); i++){
            int n = 0;
            if (n < i){
                i = n;
            }
            if(i == arroz.getPrecioUnitario()){
                maxPeso -= arroz.getStock();
                precioFinal =+ arroz.getPrecioUnitario()* arroz.getStock();
            }
            if(i == frijol.getPrecioUnitario()){
                maxPeso -= frijol.getStock();
                precioFinal =+ frijol.getPrecioUnitario()* frijol.getStock();
            }
            if(i == almendra.getPrecioUnitario()){
                maxPeso -= almendra.getStock();
                precioFinal =+ almendra.getPrecioUnitario()* almendra.getStock();
            }
        }
        System.out.println(precioFinal);

    }
}
