import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10,20,15,12,40,25,18));
        Heap h = new Heap(numbers);

        h.printArr();
    }
}