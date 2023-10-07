import static utils.Sorting.Sorter.swap;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{9,3, 2, 1, 8, 7, 6, 5, 4};
        sort(array);
    }

    public static void sort(int[] N) {
        for (int i = N.length / 2 - 1; i >= 0; i--) {
            //    COMPARACIONES++;
            heapify(N, N.length, i);
        }
        for (int i = N.length - 1; i >= 0; i--) {
            int tmp = N[0];
            N[0] = N[i];
            N[i] = tmp;
          //     MOVIMIENTOS++;
            heapify(N, i, 0);
        }
    }

    public static void heapify(int N[], int n, int k) {

        int largest = k;
        int leftChild = 2 * k + 1;
        int rightChild = 2 * k + 2;

        // If left child is larger than root
        if (leftChild < n && N[leftChild] > N[largest]) {
            largest = leftChild;

            if (rightChild < n && N[rightChild] > N[largest]) {
                largest = rightChild;

                if (largest != k) {
                    int swap = N[k];
                    N[k] = N[largest];
                    N[largest] = swap;
                    swap(N, largest, n);

                    heapify(N, n, largest);
                }
            }
        }
    }
}

