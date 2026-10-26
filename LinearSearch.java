import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

    public static int linearSearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] generateRandomArray(int size, int min, int max) {
        Random rand = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(max - min + 1) + min;
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer;

        System.out.println("What number are you searching for in the list below? Enter \"q\" to quit.");

        do {
            int[] numbers = generateRandomArray(10, 0, 100);
            Arrays.sort(numbers);

            for (int n : numbers) {
                System.out.print(n + " ");
            }
            System.out.print("  Number: ");
            answer = input.nextLine().trim();

            if (!answer.equalsIgnoreCase("q")) {
                try {
                    int target = Integer.parseInt(answer);
                    int index = linearSearch(numbers, target);

                    if (index != -1) {
                        System.out.println("The number " + target + " is found at index " + index + ".");
                    } else {
                        System.out.println("The number " + target + " is not found in the list of numbers.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a whole number or q to quit.");
                }
            }
        } while (!answer.equalsIgnoreCase("q"));

        System.out.println("Thank you for playing!");
        input.close();
    }
}