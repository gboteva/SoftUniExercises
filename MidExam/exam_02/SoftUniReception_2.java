package FundamentalsCourse.midExamMid.exam_02;

import java.util.Scanner;

public class SoftUniReception_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        int hour = 0;

        while (students > 0) {
            hour++;
            if (hour % 4 != 0) {
                students -= (first + second + third);
            }
        }
        System.out.println("Time needed: " + hour + "h.");
    }
}
