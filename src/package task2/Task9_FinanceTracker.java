import java.util.Scanner;

public class Task9_FinanceTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] dailyExpenses = new double[7];
        String[] days = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"};

        final double USD_RATE = 0.095; 
        final double EUR_RATE = 0.087; 

        while (true) {
            System.out.println("\n=== ФИНАНСОВЫЙ ТРЕКЕР ===");
            System.out.println("1. Внести расходы за день");
            System.out.println("2. Показать общую сумму расходов");
            System.out.println("3. Конвертировать в доллары");
            System.out.println("4. Конвертировать в евро");
            System.out.println("5. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nВыберите день недели:");
                    for (int i = 0; i < days.length; i++) {
                        System.out.println((i + 1) + ". " + days[i]);
                    }
                    System.out.print("Ваш выбор: ");
                    int dayChoice = scanner.nextInt() - 1;

                    if (dayChoice >= 0 && dayChoice < days.length) {
                        System.out.print("Введите расходы за " + days[dayChoice] + " (SEK): ");
                        dailyExpenses[dayChoice] = scanner.nextDouble();
                        System.out.println("Расходы сохранены!");
                    } else {
                        System.out.println("Неверный выбор дня!");
                    }
                    break;

                case 2:
                    double total = 0;
                    System.out.println("\n=== РАСХОДЫ ЗА НЕДЕЛЮ ===");
                    for (int i = 0; i < days.length; i++) {
                        System.out.printf("%s: %.2f SEK\n", days[i], dailyExpenses[i]);
                        total += dailyExpenses[i];
                    }
                    System.out.printf("ОБЩАЯ СУММА: %.2f SEK\n", total);
                    break;

                case 3:
                    total = 0;
                    for (double expense : dailyExpenses) {
                        total += expense;
                    }
                    System.out.printf("Общая сумма в долларах: %.2f USD\n", total * USD_RATE);
                    break;

                case 4:
                    total = 0;
                    for (double expense : dailyExpenses) {
                        total += expense;
                    }
                    System.out.printf("Общая сумма в евро: %.2f EUR\n", total * EUR_RATE);
                    break;

                case 5:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
}