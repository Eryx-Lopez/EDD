package Modulo1.ExamenRapido4;

import java.util.ArrayList;

public class OchoReinas {

    public static void getSolutions(int column, ArrayList solution, ArrayList<Boolean> visited){
        ArrayList solutionsList = new ArrayList<>();
        ArrayList<Boolean> visitedList = new ArrayList<>();

        if (column == solution.size()){
            solutionsList.add(solution);
        }
        else{
            for(int row = 0; row < solution.size(); row++){
                if (visited.get(row)){
                    return;
                }
                if (!isValid(solution, row, column)){
                    return;
                }
                ArrayList solutionClone = (ArrayList) solution.clone();
                ArrayList visitedClone = (ArrayList) visited.clone();

                solutionClone.set(column, row);
                visitedClone.set(row, true);

                getSolutions(column + 1, solutionClone, visitedClone);
            }
        }
    }

    public static boolean isValid(ArrayList solution, int row, int column){

        /*Crea una segunda variable (queenRow y queenColumn) con la que se va comprando
        la hilera y la columna correspondiente y para no hacer doble fórmula, se agarra el
        valor absoluto de la resta para obtener las diagonales, de ser así, significaría que
        hay otra reina que cruza, por lo que devuelve falso.
         */

        for (int i = 0; i < row; i++) {
            int queenRow = (int) solution.get(i);
            int queenColumn = i;
            if (queenRow == row || queenColumn == column || Math.abs(queenRow - row) == Math.abs(queenColumn - column)) {
                return false;
            }
        }
        return true;
    }
}
