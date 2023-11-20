public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso: java Main <algoritmo> <tamanho da sequência> <tipo de sequência>");
            return;
        }

        String algorithm = args[0];
        int size = Integer.parseInt(args[1]);
        String sequenceType = args[2];

        switch (algorithm) {
            case "BubbleSort":
                BubbleSort.main(new String[]{String.valueOf(size), sequenceType});
                break;
            case "InsertionSort":
                InsertionSort.main(new String[]{String.valueOf(size), sequenceType});
                break;
            case "SelectionSort":
                SelectionSort.main(new String[]{String.valueOf(size), sequenceType});
                break;
            case "QuickSort":
                QuickSort.main(new String[]{String.valueOf(size), sequenceType});
                break;
            case "HeapSort":
                HeapSort.main(new String[]{String.valueOf(size), sequenceType});
                break;
            case "MergeSort":
                MergeSort.main(new String[]{String.valueOf(size), sequenceType});
                break;
            default:
                System.out.println("Algoritmo inválido. Escolha entre BubbleSort, InsertionSort, SelectionSort, QuickSort, HeapSort ou MergeSort.");
        }
    }
}
