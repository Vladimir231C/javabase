import java.util.Scanner;

public class Task4_TaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите доход за месяц (SEK): ");
        double income = scanner.nextDouble();

        double taxRate;
        if (income <= 18800) {
            taxRate = 0.11;
        } else if (income <= 468700) {
            taxRate = 0.20;
        } else if (income <= 675700) {
            taxRate = 0.32;
        } else {
            taxRate = 0.40;
        }

        double taxAmount = income * taxRate;
        double netIncome = income - taxAmount;

        System.out.printf("Доход: %.2f SEK\n", income);
        System.out.printf("Налоговая ставка: %.0f%%\n", taxRate * 100);
        System.out.printf("Сумма налога: %.2f SEK\n", taxAmount);
        System.out.printf("Чистый доход: %.2f SEK\n", netIncome);

        scanner.close();
    }
}