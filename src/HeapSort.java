import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java HeapSort <tamanho da sequência> <tipo de sequência>");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String sequenceType = args[1];

        int[] arr = SortingUtils.generateSequence(size, sequenceType);

        System.out.println("Original Array (" + sequenceType + ", size=" + size + "): " + Arrays.toString(arr));

        long startTime = System.nanoTime();
        heapSort(arr);
        long endTime = System.nanoTime();

        double elapsedTimeSeconds = (endTime - startTime) / 1e9; // Converter de nanossegundos para segundos

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Tempo de execução: " + elapsedTimeSeconds + " segundos");
    }
}
