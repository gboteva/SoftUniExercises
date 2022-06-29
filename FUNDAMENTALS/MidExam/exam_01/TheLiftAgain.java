package FundamentalsCourse.midExamMid.exam_01;

import java.util.Arrays;
import java.util.Scanner;

public class TheLiftAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int [] wagonsState = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum = Arrays.stream(wagonsState).sum() / wagonsState.length;

        while (people>0 && sum<4){
            for (int i = 0; i < wagonsState.length ; i++) {
                if (wagonsState[i]<4 && people>=4-wagonsState[i]){
                    people=people-(4 - wagonsState[i]);
                    wagonsState [i]=4;
                } else if (wagonsState[i]<4 && people<4-wagonsState[i]){
                    wagonsState[i] = wagonsState[i] + people;
                    people=0;
                }
            }
            sum = Arrays.stream(wagonsState).sum() / wagonsState.length;
        }

        if (sum==4 && people>0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            System.out.println(Arrays.toString(wagonsState).replaceAll("[\\[\\],]",""));
        } else if (sum==4 && people==0){
            System.out.println(Arrays.toString(wagonsState).replaceAll("[\\[\\],]",""));
        }else {
            System.out.println("The lift has empty spots!");
            System.out.println(Arrays.toString(wagonsState).replaceAll("[\\[\\],]",""));
        }

    }
}
