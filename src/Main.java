import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//    CommandLine cl=new CommandLine();
//    cl.UserInterface();
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10,2,1,1000,5,40,85));
        Heap h = new Heap(numbers);
        h.heapSort();
        h.printArr();

    }}