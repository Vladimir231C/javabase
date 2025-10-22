import java.util.Scanner;

public class Task3_BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите вес в кг: ");
        double weight = scanner.nextDouble();

        System.out.print("Введите рост в метрах: ");
        double height = scanner.nextDouble();

        double bmi = weight / (height * height);

        String result;
        if (bmi <= 16) {
            result = "Выраженный дефицит массы тела";
        } else if (bmi <= 18.5) {
            result = "Дефицит массы тела";
        } else if (bmi <= 25) {
            result = "Норма";
        } else if (bmi <= 30) {
            result = "Избыточная масса тела (предожирение)";
        } else if (bmi <= 35) {
            result = "Ожирение 1-й степени";
        } else if (bmi <= 40) {
            result = "Ожирение 2-й степени";
        } else {
            result = "Ожирение 3-й степени";
        }

        System.out.printf("Индекс массы тела: %.2f\n", bmi);
        System.out.println("Результат: " + result);

        scanner.close();
    }
}