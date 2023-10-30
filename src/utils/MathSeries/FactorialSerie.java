package utils.MathSeries;

public class FactorialSerie {
    public static int get(int N){
        if(N == 0 || N == 1){
            //Escenario base
            return 1;
        }
        else{
            //Escenario general
            return N * get(N-1);
        }
    }
}
