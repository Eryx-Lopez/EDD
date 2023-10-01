package utils.Sorting;

public class SorterFactory {
    public static Sorter getSorter(Sorter.SorterMethods method){

        return switch (method){
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
            case SELECTION -> new Sorter(){
                @Override
                public void sort(int[] N) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;
                    for(int i = 0;i < N.length-1;i++){
                        int minIndex = i;
                        for(int j = i + 1;j < N.length;j++){
                            COMPARACIONES++;
                            if(N[minIndex] > N[j]){
                                minIndex = j;
                            }
                        }
                        if(minIndex != i){
                            MOVIMIENTOS++;
                            swap(N,minIndex,i);
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
                    while(knuthsForm < N.length/3){
                        COMPARACIONES++;
                        knuthsForm = 3 * knuthsForm + 1;
                    }
                    while (knuthsForm >= 1){
                        for(int i = knuthsForm; i < N.length; i++){
                            int j = i;
                            while (j > knuthsForm && N[j] < N[j-knuthsForm]){
                                    swap(N, j, j-knuthsForm);
                                    MOVIMIENTOS++;
                                    j = j-knuthsForm;
                            }
                        }
                        knuthsForm = knuthsForm/3;
                    }
                }
            };
            case HEAP -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    for(int i = N.length/2 - 1; i >= 0; i--){
                        COMPARACIONES++;
                        heapify(N, N.length, i);
                        for (int j = N.length - 1; i > 0; i--){
                            swap(N, 0, i);
                            MOVIMIENTOS++;
                            heapify(N, i, 0);
                        }
                    }

                }
                public void heapify(int N[], int n, int k){
                    {
                        int largest = k;
                        int leftChild = 2 * k + 1;
                        int rightChild = 2 * k + 2;

                        // If left child is larger than root
                        if(leftChild < n && N[leftChild] > N[largest]){
                            largest = leftChild;
                            if (rightChild < n && N[rightChild] > N[largest]){
                                if (largest != k){
                                    swap(N, k, largest);
                                }
                            }
                        }
                            heapify(N, n, largest);
                    }
                }
            };
            case QUICK -> null;
            case MERGE -> new Sorter() {
                @Override
                public void sort(int[] N) {
                    COMPARACIONES = 0;
                    MOVIMIENTOS = 0;

                    int n = N.length;
                    if (n < 2) {
                        return;
                    }
                    int division = n / 2;
                    int[] left = new int[division];
                    int[] right = new int[n - division];

                    for (int i = 0; i < division; i++) {
                        left[i] = N[i];
                    }
                    for (int i = division; i < n; i++) {
                        right[i - division] = N[i];
                    }

                    sort(left);
                    sort(right);

                    merge(N, left, right);
                }

                public void merge(int[] arr, int[] left, int[] right) {
                    int n1 = left.length;
                    int n2 = right.length;
                    int i = 0, j = 0, k = 0;
                    int[] mergedArray = new int[n1 + n2];

                    while (i < n1 && j < n2) {
                        COMPARACIONES++;
                        if (left[i] <= right[j]) {
                            MOVIMIENTOS++;
                            mergedArray[k++] = left[i++];
                        } else {
                            MOVIMIENTOS++;
                            mergedArray[k++] = right[j++];
                        }
                    }

                    while (i < n1) {
                        MOVIMIENTOS++;
                        mergedArray[k++] = left[i++];
                    }
                    while (j < n2) {
                        MOVIMIENTOS++;
                        mergedArray[k++] = right[j++];
                    }
                    System.arraycopy(mergedArray, 0, arr, 0, arr.length);
                }
            };
            default -> throw new IllegalStateException("Unexpected value: " + method);
        };

    }


    //https://www.geeksforgeeks.org/bubble-sort/
    //https://visualgo.net/en/sorting
    //https://www.geeksforgeeks.org/shellsort/
    //https://www.tutorialspoint.com/data_structures_algorithms/shell_sort_algorithm.htm
    //https://www.toptal.com/developers/sorting-algorithms/shell-sort

}
