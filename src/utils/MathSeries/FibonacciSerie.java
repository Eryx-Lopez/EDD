package utils.MathSeries;

public class FibonacciSerie {
    public static int get(int N){
        if(N == 0 || N == 1){
            return 1;
        }
        else{
            return get(N-1) + get(N-2);
        }
    }
}
