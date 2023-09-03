package Modulo1.Actividad3.process;

import Modulo1.utils.Stack;

public class InfijaAPostfija {
    private static int sacarPrioridadDeOperador(char operador){
        int jerarquia = 0;
        if(operador == ('^')) jerarquia = 3;
        if(operador == ('*') ||operador == ( '/')) jerarquia = 2;
        if(operador ==('+')|| operador == ('-')) jerarquia = 1;
        return jerarquia;
    }


    public static boolean buscarOperador(char operador) {
        char[] arregloOp = {'^', '*', '/', '+', '-'};

        for(int i = 0; i < arregloOp.length; i++) {
            if(arregloOp[i] == operador) return true;
        }
        return false;
    }


    public static String convertirNotacion(String entrada) {

        String salidaPostfija = " ";
        Stack<Character> operadores = new Stack<>();
        int prioridadOpAnterior = 0;


        for (int i = 0; i < entrada.length(); i++) {
            char aux = entrada.charAt(i);

             if(aux == ' ') continue;

            boolean esOperador = buscarOperador(aux);

            if (esOperador) {

                int prioridadOpNuevo = sacarPrioridadDeOperador(aux);

                if (prioridadOpNuevo == prioridadOpAnterior && !operadores.isEmpty()) {
                    salidaPostfija = salidaPostfija + operadores.pop().get();
                    operadores.push(aux); // Si ya hay algo en la pila, pero los operadores son del mismo valor, sólo se mete a la pila
                } else if (prioridadOpNuevo > prioridadOpAnterior) {
                    operadores.push(aux); // Se mete a la pila sólo si es mayor que el que ya estaba ahí
                } else {
                    while (operadores.isEmpty()) {
                        salidaPostfija = salidaPostfija + operadores.pop().get();
                    }
                    operadores.push(aux);
                }
                prioridadOpAnterior = prioridadOpNuevo;
            }
            else {
                salidaPostfija = salidaPostfija + aux;
            }

         }
        while ( operadores.size() > 0){
            salidaPostfija = salidaPostfija + operadores.pop().get();
        }

    return salidaPostfija;
    }

    public static float hacerOperacion(float num1, float num2, char operador) {
        switch (operador) {
            case '^':
                return (float) Math.pow(num1, num2);
            case '*':
                return (num1 * num2);

            case '/':
                return (num1 / num2);

            case '+':
                return (num1 + num2);

            case '-':
                return (num1 - num2);

        }
        return 0;
    }


    public static String resolverOpPostfija(String entrada) {
        float num1;
        float num2;

        Stack<Float> pilaDeNumeros = new Stack<>();
        for (int i = 0; i < entrada.length(); i++) {

            char aux = entrada.charAt(i);

            boolean esOperador = buscarOperador(aux);

            if (esOperador) {
                num1 = pilaDeNumeros.pop().get();
                num2 = pilaDeNumeros.pop().get();

                float resultadoFinal = hacerOperacion(num1, num2, aux);
                pilaDeNumeros.push(resultadoFinal);

            } else {
                float num = Float.parseFloat(String.valueOf(aux));
                pilaDeNumeros.push(num);
            }
        }
        return pilaDeNumeros.pop().get().toString();

    }

}
