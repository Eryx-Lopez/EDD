package utils.MathSeries;

public class FibonacciSerie {
    public static int getRecursiva(int n){
        if(n == 0|| n == 1){
            //Escenario base
            return 1;
        }
        else{
            //Escenario general
            return getRecursiva(n-1) + getRecursiva(n-2);
        }
    }
    public static int getIterativa(int n){
        if(n == 0|| n == 1){
            //Escenario base
            return 1;
        }
        int next = 1;
        int index = 1;
        int temp;

        for (int i = 1; i <= n; i++){
            temp = index;
            index = next;
            next += temp;
        }
        return index;
    }
}
