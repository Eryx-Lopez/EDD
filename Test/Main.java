import org.junit.Assert;
import org.junit.Test;
import utils.MathSeries.FactorialSerie;
import utils.MathSeries.FibonacciSerie;
import utils.Searches.BusquedaBinaria;

public class Main {
    @Test
    public void fibonacciRecursiveTest() {
        int n = 10;
        System.out.println(n);
        System.out.println(FibonacciSerie.getRecursiva(n));
        Assert.assertEquals(89, FibonacciSerie.getRecursiva(n));
    }
    @Test
    public void factorialRecursiveTest(){
        int n = 10;
        System.out.println(n);
        System.out.println(FactorialSerie.getRecursiva(n));
        Assert.assertEquals(3628800, FactorialSerie.getRecursiva(n));
    }
    @Test
    public void binarySearchRecursiveTest(){
        int nums[] = { 2, 4, 5, 6, 9, 11 };
        int target = 6;
        System.out.println(target);
        System.out.println("El target esta en el indice: " + BusquedaBinaria.getRecursive(nums,0, nums.length, target));
        Assert.assertEquals(3, BusquedaBinaria.getRecursive(nums,0, nums.length, target));
    }
    @Test
    public void fibonacciIterativeTest(){
        int n = 10;
        System.out.println(n);
        System.out.println(FibonacciSerie.getIterativa(n));
        Assert.assertEquals(89, FibonacciSerie.getIterativa(n));
    }
    @Test
    public void factorialIterativeTest(){
        int n = 10;
        System.out.println(n);
        System.out.println(FactorialSerie.getIterativa(n));
        Assert.assertEquals(3628800, FactorialSerie.getIterativa(n));
    }
    @Test
    public void binarySearchIterativeTest(){
        int nums[] = { 2, 4, 5, 6, 9, 11 };
        int target = 6;
        System.out.println(target);
        System.out.println("El target esta en el indice: " + BusquedaBinaria.getIterative(nums,0, nums.length, target));
        Assert.assertEquals(3, BusquedaBinaria.getIterative(nums,0, nums.length, target));

    }
}
