package utils.MathSeries;

public class FactorialSerie {
    public static int getRecursiva(int n){
        if(n == 0 || n == 1){
            //Escenario base
            return 1;
        }
        else{
            //Escenario general
            return n * getRecursiva(n-1);
        }
    }

    public static int getIterativa(int n){
        if(n == 0 || n == 1){
            //Escenario base
            return 1;
        }
        int index = 1;
        for (int i = 1; i <= n; i++){
            index *= i;
        }
    return index;
    }
}
