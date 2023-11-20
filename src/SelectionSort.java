import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Troca os elementos
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java SelectionSort <tamanho da sequência> <tipo de sequência>");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String sequenceType = args[1];

        int[] arr = SortingUtils.generateSequence(size, sequenceType);

        System.out.println("Original Array (" + sequenceType + ", size=" + size + "): " + Arrays.toString(arr));

        long startTime = System.nanoTime();
        selectionSort(arr);
        long endTime = System.nanoTime();

        double elapsedTimeSeconds = (endTime - startTime) / 1e9; // Converter de nanossegundos para segundos

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Tempo de execução: " + elapsedTimeSeconds + " segundos");
    }
}
