import java.util.Scanner;

public class Task1_Season {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца (1-12): ");
        int month = scanner.nextInt();

        String season;
        if (month >= 1 && month <= 2 || month == 12) {
            season = "зима";
        } else if (month >= 3 && month <= 5) {
            season = "весна";
        } else if (month >= 6 && month <= 8) {
            season = "лето";
        } else if (month >= 9 && month <= 11) {
            season = "осень";
        } else {
            season = "некорректный номер месяца!";
        }

        System.out.println("Время года: " + season);
        scanner.close();
    }
}