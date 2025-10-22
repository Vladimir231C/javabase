import java.util.Random;
import java.util.Scanner;

public class Task6_GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int secretNumber = random.nextInt(100) + 1;
        int attempts = 3;

        System.out.println("Я загадал число от 1 до 100. У вас " + attempts + " попытки!");

        for (int attempt = 1; attempt <= attempts; attempt++) {
            System.out.print("Попытка " + attempt + ": ");
            int guess = scanner.nextInt();

            if (guess == secretNumber) {
                System.out.println("Поздравляю! Вы угадали число!");
                break;
            } else if (guess < secretNumber) {
                System.out.println("Загаданное число БОЛЬШЕ");
            } else {
                System.out.println("Загаданное число МЕНЬШЕ");
            }

            if (attempt == attempts) {
                System.out.println("Попытки закончились! Загаданное число было: " + secretNumber);
            }
        }

        scanner.close();
    }
}