public class Main {
    public static void main(String[] args) {
     SortArray sortArray=new SortArray("test1.txt");
     int [] arr= sortArray.Non_Comparison_Sort(true);
     for (int i=0;i< arr.length;i++)
     {
         System.out.print(arr[i]+" ");
     }
    }
}