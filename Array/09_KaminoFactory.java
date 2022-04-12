package Array_Ex;

import java.util.Arrays;
import java.util.Scanner;

public class decapitationKamino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int DNAlenght = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int maxCountOnes = 0;
        int maxSum = 0;
        int lastLeftIndex = DNAlenght - 1;
        int[] bestArray = new int[DNAlenght];
        int countInput = 0;
        int bestInput = 0;


        while (!input.equals("Clone them!")) {          //!+ значи сплитване по един или повече удивителни
            int[] inputArr = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();
            countInput++;

            int onesSum = 0;
            if (inputArr[inputArr.length - 1] == 1) {       //добавяме 1-ца към сумата, ако последната цифра е 1
                onesSum++;                                  //тъй като цикъла не стига до последния елемент
            }

            int currentCountOnes = 1;
            int currentIndex = 0;
            for (int i = 0; i < inputArr.length - 1; i++) { //за всеки вход проверяваме:
                if (inputArr[i] == 1) {                        // 1)най-дълга поредица 1-ци
                    onesSum++;                                 // 2)текуща сума на 1-ци
                    if (inputArr[i + 1] == 1) {                 //3) индекс, от който започват поредиците
                        currentCountOnes++;
                        currentIndex = i;
                    }
                }
            }                                   /*накрая имаме броя послед.1-ци за текущия вход;
                                                 индекса, от който започват и сумата на всички 1-ци на входа*/

            if (currentCountOnes > maxCountOnes) {     //проверяваме дали този вход е с максимум 1ци в поредица
                maxCountOnes = currentCountOnes;      //записваме го като максимален брой
                bestArray = inputArr;                 //запазваме входа като най-добър
                lastLeftIndex = currentIndex;         //запазваме индекса, от който започват 1-ците
                maxSum = onesSum;                     //запазваме сумата му като максимална
                bestInput = countInput;

            } else if (currentCountOnes == maxCountOnes) {     //ако имаме еднакви дължини на поредици
                if (currentIndex < lastLeftIndex) {                 //проверявяме чий първи индекс на поредицата
                    bestArray = inputArr;                           //е по-в ляво;
                    lastLeftIndex = currentIndex;
                    maxSum = onesSum;
                    bestInput = countInput;
                } else if (currentIndex == lastLeftIndex) {     //ако и индексите са еднакви:
                    if (onesSum > maxSum) {                         //проверяваме сумата
                        maxSum = onesSum;
                        bestArray = inputArr;
                        lastLeftIndex = currentIndex;
                        bestInput = countInput;
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestInput, maxSum);
        for (int best : bestArray) {
            System.out.print(best + " ");
        }

    }
}

