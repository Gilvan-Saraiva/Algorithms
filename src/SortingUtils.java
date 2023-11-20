import java.util.Random;

public class SortingUtils {

    public static int[] generateSequence(int size, String type) {
        int[] sequence = new int[size];
        Random random = new Random();

        if (type.equals("ordered")) {
            for (int i = 0; i < size; i++) {
                sequence[i] = i;
            }
        } else if (type.equals("reverse_ordered")) {
            for (int i = 0; i < size; i++) {
                sequence[i] = size - i;
            }
        } else if (type.equals("almost_ordered")) {
            for (int i = 0; i < size; i++) {
                sequence[i] = i;
            }
            // Embaralha alguns elementos
            for (int i = 0; i < size / 10; i++) {
                int index1 = random.nextInt(size);
                int index2 = random.nextInt(size);
                int temp = sequence[index1];
                sequence[index1] = sequence[index2];
                sequence[index2] = temp;
            }
        } else if (type.equals("random")) {
            for (int i = 0; i < size; i++) {
                sequence[i] = random.nextInt(size);
            }
        }

        return sequence;
    }
}
