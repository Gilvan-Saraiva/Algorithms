import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java InsertionSort <tamanho da sequência> <tipo de sequência>");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String sequenceType = args[1];

        int[] arr = SortingUtils.generateSequence(size, sequenceType);

        System.out.println("Original Array (" + sequenceType + ", size=" + size + "): " + Arrays.toString(arr));

        long startTime = System.nanoTime();
        insertionSort(arr);
        long endTime = System.nanoTime();

        double elapsedTimeSeconds = (endTime - startTime) / 1e9; // Converter de nanossegundos para segundos

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Tempo de execução: " + elapsedTimeSeconds + " segundos");
    }
}
