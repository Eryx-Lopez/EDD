package utils.Sorting;

public class SorterFactory {
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
                            COMPARACIONES++;
                            if (N[minIndex] > N[j]) {
                                minIndex = j;
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
                        COMPARACIONES++;
                        int firstElem = N[i];
                        int lastElemSorted = i - 1;

                        while (lastElemSorted >= 0 && N[lastElemSorted] > firstElem) {
                            MOVIMIENTOS++;
                            N[lastElemSorted + 1] = N[lastElemSorted];
                            lastElemSorted--;
                        }
                    }
                }

            };
            case SHELL -> new Sorter() {
                @Override
                public void sort(int[] N) {
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
                    for (int i = N.length / 2 - 1; i >= 0; i--) {
                        COMPARACIONES++;
                        heapify(N, N.length, i);
                        for (int j = N.length - 1; i > 0; i--) {
                            swap(N, 0, i);
                            MOVIMIENTOS++;
                            heapify(N, i, 0);
                        }
                    }
                }

                public void heapify(int N[], int n, int k) {
                    {
                        int largest = k;
                        int leftChild = 2 * k + 1;
                        int rightChild = 2 * k + 2;

                        // If left child is larger than root
                        if (leftChild < n && N[leftChild] > N[largest]) {
                            largest = leftChild;
                            if (rightChild < n && N[rightChild] > N[largest]) {
                                if (largest != k) {
                                    swap(N, k, largest);
                                }
                            }
                        }
                        heapify(N, n, largest);
                    }
                }
            };
            case MERGE -> new Sorter() {
                @Override
                public void sort(int[] N) {
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
                    int[] n1 = new int [(N.length % 2) == 1 ? mitad + 1 : mitad];
                    int[] n2 = new int [mitad];
                    int[] n1copy = n1.clone();
                    int[] n2copy = n2.clone();
                    //Copiar los valores del array

                    sorter(n1copy);
                    sorter(n2copy);
                    return merge(n1copy, n2copy);
                }
                public int[] merge(int[] n1, int[] n2){
                    MOVIMIENTOS = 0;
                    COMPARACIONES = 0;

                    int[] N = new int[n1.length + n2.length];
                    int index1 = 0;
                    int index2 = 0;

                    for(int i = 0; i < N.length; i++){
                        COMPARACIONES++;
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
                            MOVIMIENTOS++;

                        }else{
                            N[i]= n2[index2];
                            index2++;
                            MOVIMIENTOS++;
                        }
                    }

                    return N;

                }

            };
            case QUICK -> null;


            //https://www.geeksforgeeks.org/bubble-sort/
            //https://visualgo.net/en/sorting
            //https://www.geeksforgeeks.org/shellsort/
            //https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm
            //https://www.toptal.com/developers/sorting-algorithms/shell-sort

        };
    }
}
