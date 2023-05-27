import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
     SortArray sortArray=new SortArray("test1.txt");
     ArrayList<String> result = sortArray.Non_Comparison_Sort(true);
     for(String s:result)
     {
         System.out.println(s);
     }
    }
}