package Array_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isTop = false;

        for (int i = 0; i < input.length; i++) {
            if (i== input.length-1){
                System.out.print(input[i]);
                break;
            }
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] <= input[j]) {
                    isTop = false;
                    break;
                } else {
                    isTop = true;
                }
            }
            if (isTop){
                System.out.print(input[i]+" ");
            }
        }
    }
}
