import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            int partitionIndex = partition(arr, low, high);

            if (partitionIndex - 1 > low) {
                stack.push(low);
                stack.push(partitionIndex - 1);
            }

            if (partitionIndex + 1 < high) {
                stack.push(partitionIndex + 1);
                stack.push(high);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java QuickSort <tamanho da sequência> <tipo de sequência>");
            return;
        }

        int size = Integer.parseInt(args[0]);
        String sequenceType = args[1];

        int[] arr = SortingUtils.generateSequence(size, sequenceType);

        System.out.println("Original Array (" + sequenceType + ", size=" + size + "): " + Arrays.toString(arr));

        long startTime = System.nanoTime();
        quickSort(arr, 0, size - 1);
        long endTime = System.nanoTime();

        double elapsedTimeSeconds = (endTime - startTime) / 1e9; // Converter de nanossegundos para segundos

        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Tempo de execução: " + elapsedTimeSeconds + " segundos");
    }
}
