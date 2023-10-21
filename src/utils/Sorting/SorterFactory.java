package utils.Sorting;

public class SorterFactory {
    /** Es un switch case que tiene como cases los diferentes métodos de sorteo
     *
     *
     * @param method el método que se usa
     * @return returnea el procedimiento del método
     */
    public static Sorter getSorter(Sorter.SorterMethods method) {

        return switch (method) {
            case BUBBLE -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;
                    boolean swapped = true;
                    while (swapped) {
                        swapped = false;
                        for (int i = 1; i < N.length - 1; i++) {
                            COMPARACIONES++;
                            if (N[i] > N[i + 1]) {
                                swap(N, i, i + 1);
                                MOVIMIENTOS++;
                                swapped = true;
                            }
                        }
                    }
                }
            };
            case SELECTION -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;
                    for (int i = 0; i < N.length - 1; i++) {
                        int minIndex = i;
                        for (int j = i + 1; j < N.length; j++) {
                            if (N[minIndex] > N[j]) {
                                minIndex = j;
                                COMPARACIONES++;

                            }
                        }
                        if (minIndex != i) {
                            MOVIMIENTOS++;
                            swap(N, minIndex, i);
                        }
                    }
                }

            };
            case INSERTION -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;
                    for (int i = 1; i < N.length; ++i) {
                        int firstElem = N[i];
                        int lastElemSorted = i - 1;

                        while (lastElemSorted >= 0 && N[lastElemSorted] > firstElem) {
                            COMPARACIONES++;
                            N[lastElemSorted + 1] = N[lastElemSorted];
                            MOVIMIENTOS++;
                            lastElemSorted--;
                        }
                    }
                }

            };
            case SHELL -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;

                    int knuthsForm = 1;
                    while (knuthsForm < N.length / 3) {
                        COMPARACIONES++;
                        knuthsForm = 3 * knuthsForm + 1;
                    }
                    while (knuthsForm >= 1) {
                        for (int i = knuthsForm; i < N.length; i++) {
                            int j = i;
                            while (j > knuthsForm && N[j] < N[j - knuthsForm]) {
                                swap(N, j, j - knuthsForm);
                                MOVIMIENTOS++;
                                j = j - knuthsForm;
                            }
                        }
                        knuthsForm = knuthsForm / 3;
                    }
                }
            };
            case HEAP -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;

                    for (int i = N.length / 2 - 1; i >= 0; i--) {
                        heapify(N, N.length, i);
                    }
                    for (int i = N.length - 1; i > 0; i--) {
                        swap(N, 0, i);
                        MOVIMIENTOS++;
                        heapify(N, i, 0);
                    }
                }

               void heapify(int N[], int n, int k) {
                    int largest = k;
                    int leftChild = 2 * k + 1;
                    int rightChild = 2 * k + 2;

                    // If left child is larger than root
                    if (leftChild < n && N[leftChild] > N[largest]) {
                        COMPARACIONES++;
                        largest = leftChild;
                    }
                    if (rightChild < n && N[rightChild] > N[largest]) {
                        COMPARACIONES++;
                        largest = rightChild;
                    }
                    if (largest != k) {
                         swap(N, k, largest);
                         MOVIMIENTOS++;
                         heapify(N, n, largest);
                    }
                }
            };
            case MERGE -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    int[] aux = sorter(N);
                    for (int i = 0; i < N.length; i++){
                        N[i] = aux[i];
                    }
                }

                public int[] sorter(int[] N){
                    if(N.length == 1){
                        return N;
                    }

                    int mitad = N.length/2;
                    int[] leftCopy = new int [mitad];
                    int[] rightCopy = new int [(N.length % 2) == 1 ? mitad + 1 : mitad];

                    //Copiar los valores del array
                    for(int i = 0; i < mitad; i++){
                        leftCopy[i] = N[i];
                    }
                    for(int i = mitad; i < N.length; i++){
                        rightCopy[i-mitad] = N[i];
                    }

                    leftCopy = sorter(leftCopy);
                    rightCopy = sorter(rightCopy);

                    return merge(leftCopy, rightCopy);
                }
                public int[] merge(int[] n1, int[] n2){

                    int[] N = new int[n1.length + n2.length];
                    int index1 = 0;
                    int index2 = 0;

                    for(int i = 0; i < N.length; i++){

                        if(index1 == n1.length){
                            N[i]= n2[index2];
                            index2++;
                            MOVIMIENTOS++;

                        } else if(index2 == n2.length){
                            N[i]= n1[index1];
                            index1++;
                            MOVIMIENTOS++;
                        }else if(n1[index1]< n2[index2]){
                            N[i]= n1[index1];
                            index1++;
                            COMPARACIONES++;
                            MOVIMIENTOS++;
                        }else{
                            N[i]= n2[index2];
                            index2++;
                            COMPARACIONES++;
                            MOVIMIENTOS++;
                        }
                    }

                    return N;
                }

            };
            case QUICK -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    sorter(N, 0, N.length-1);

                }
                public void sorter(int[] N, int left, int right){
                    int index;

                    if((right - left) > 0){
                        index = getPartition(N, left, right);
                        sorter(N, left, index-1);
                        sorter(N, index +1, right);
                    }
                }

                public int getPartition(int[] N, int left, int right){
                    int pivot = right;
                    int firstHigh = left;

                    for(int i = left; i < right; i++){
                        COMPARACIONES++;
                        if(N[i] < N[pivot]){
                            swap(N, i, firstHigh);
                            MOVIMIENTOS++;
                            firstHigh++;
                        }
                    }
                    swap(N, pivot, firstHigh);
                    MOVIMIENTOS++;
                    return firstHigh;
                }
            };
            case BINARIA -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;

                    int left = 0;
                    int right = N.length -1;

                    while (left <= right){
                        int n = left + (right - left)/2;
                        COMPARACIONES++;

                        if(N[n] == N.length){
                            MOVIMIENTOS++;
                            break;
                        }
                        if(N[n] < N.length){
                            left = n + 1;
                        }else{
                            right = n - 1;
                        }
                    }
                }
            };

            case SECUENCIAL -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;

                    for(int i = 0; i < N.length; i++){
                        COMPARACIONES++;

                        if (N[i] == N.length){
                            MOVIMIENTOS++;
                            return;
                        }
                    }
                }
            };

            //https://www.geeksforgeeks.org/bubble-sort/
            //https://visualgo.net/en/sorting
            //https://www.geeksforgeeks.org/shellsort/
            //https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm
            //https://www.toptal.com/developers/sorting-algorithms/shell-sort

        };
    }
}
