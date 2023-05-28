import java.util.ArrayList;
import java.util.Scanner;

public class CommandLine {
    Scanner scanner = new Scanner(System.in);
    Boolean intermediateRes;
    SortArray sortAlg;

    public void UserInterface() {

        while (true) {
            InputFile();
            while (true) {
                int sort = InputAlgorithm();
                if (sort == 5) {
                    break;
                }
                while (true) {
                    int resFormat = ResFormat();
                    switch (resFormat) {
                        case 1:
                            intermediateRes = false;
                            break;
                        case 2:
                            intermediateRes = true;
                            break;
                    }
                    if (resFormat == 3) {
                        break;
                    }
                    PrintRes(sort);
                }
            }
        }
    }

    public void PrintRes(int sort) {
        ArrayList<String> result = new ArrayList<>();
        switch (sort) {
            case 1:
                result = sortAlg.simpleSort(intermediateRes);
                break;
            case 2:
                result = sortAlg.EfficientSort(intermediateRes);
                break;
            case 3:
                result = sortAlg.Non_Comparison_Sort(intermediateRes);
                break;
//            case 4: sortAlg.
        }
        String msg = "\u001B[34mFinal Sorted Result :\u001B[0m";
        if (intermediateRes) {
            msg = "\u001B[34mIntermediate Results :\u001B[31m";
        }
        System.out.println(msg);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        System.out.println("");

    }

    public int ResFormat() {
        System.out.println("\u001B[33mCHOOSE RESULT FORMAT :\u001B[0m");
        System.out.println("1.Final Sorted Results");
        System.out.println("2.Intermediate Results");
        System.out.println("3.Return To Sorting Algorithms Menu");
        String option = scanner.nextLine();
        while (!(option.equals("1") || option.equals("2") || option.equals("3"))) {
            System.out.println("\u001B[31mINVALID INPUT\u001B[0m");
            option = scanner.nextLine();
        }
        System.out.println("");
        return Integer.valueOf(option);


    }


    public void InputFile() {
        System.out.println("\u001B[33mEnter the input file path: \u001B[0m");

        String path = scanner.nextLine();

        sortAlg = new SortArray(path);
        while (sortAlg.file_path_error) {
            System.out.println("\u001B[31mERROR opening the file\u001B[0m");
            System.out.println("\u001B[33mEnter the input file path: \u001B[0m");
            path = scanner.nextLine();
            sortAlg = new SortArray(path);
        }

        System.out.println("\u001B[32mFile successfully read\u001B[0m");
        System.out.println("");


    }

    public int InputAlgorithm() {
        System.out.println("\u001B[33mCHOOSE A SORTING ALGORITHM :\u001B[0m");
        System.out.println("1.Simple Sort");
        System.out.println("2.Efficient Sort");
        System.out.println("3.Non-Comparison Sort");
        System.out.println("4.Heap Sort");
        System.out.println("5.Return To Previous Menu");
        String option = scanner.nextLine();
        while (!(option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4") || option.equals("5"))) {
            System.out.println("\u001B[31mINVALID INPUT\u001B[0m");
            option = scanner.nextLine();
        }
        System.out.println("");
        return Integer.valueOf(option);


    }


    public boolean isValidInput(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
