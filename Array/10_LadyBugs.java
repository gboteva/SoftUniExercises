package Array_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[] initIndexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        int[] bugArray = new int[size];                   //създаваме нов масив от указаните елементи
        for (int i = 0; i < initIndexes.length; i++) {
            int bugIndex = initIndexes[i];               // пълним масива, съобразно подадените индекси;
            if (bugIndex >= 0 && bugIndex < size) {      //като проверяваме дали същите са в масива;
                bugArray[bugIndex] = 1;                //ако не са -> не правим нищо, съгласно условието
            }                                   //The given indexes may or may not be inside the field range
        }


        while (!command.equals("end")) {
            String[] moveCommand = command.split(" ");
            int index = Integer.parseInt(moveCommand[0]);
            String direction = moveCommand[1];
            int lenghtFly = Integer.parseInt(moveCommand[2]);

            if (index > size - 1 || index<0 || bugArray[index] == 0) {
                command = scanner.nextLine();
                continue;
            }
            bugArray[index] = 0;

            if (direction.equals("right")) {
                index+=lenghtFly;
                while (index < size && bugArray[index] == 1) {
                    index += lenghtFly;
                }
                if (index < size) {
                    bugArray[index] = 1;
                }

            } else if (direction.equals("left")) {
                index-=lenghtFly;

                while (index>=0 && bugArray[index]==1){
                    index-=lenghtFly;
                }
                if (index>=0){
                    bugArray[index] =1;
                }

            }

            command = scanner.nextLine();
        }
        for (int bug : bugArray) {
            System.out.print(bug + " ");
        }
    }
}

