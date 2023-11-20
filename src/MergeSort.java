import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;

            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java MergeSort <tamanho da sequência> <tipo de sequência>");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String sequenceType = args[1];

        int[] arr = SortingUtils.generateSequence(size, sequenceType);

        System.out.println("Original Array (" + sequenceType + ", size=" + size + "): " + Arrays.toString(arr));

        long startTime = System.nanoTime();
        mergeSort(arr, 0, size - 1);
        long endTime = System.nanoTime();

        double elapsedTimeSeconds = (endTime - startTime) / 1e9; // Converter de nanossegundos para segundos

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Tempo de execução: " + elapsedTimeSeconds + " segundos");
    }
}
