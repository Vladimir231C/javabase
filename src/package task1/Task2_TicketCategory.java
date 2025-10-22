import java.util.Scanner;

public class Task2_TicketCategory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        String category;
        if (age < 7) {
            category = "детский";
        } else if (age >= 7 && age <= 17) {
            category = "подросток";
        } else if (age >= 18 && age <= 60) {
            category = "взрослый";
        } else {
            category = "пенсионный";
        }

        System.out.println("Категория билета: " + category);
        scanner.close();
    }
}
