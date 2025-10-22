import java.util.Scanner;

public class Task10_ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] weeklyExpenses = new double[7];
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        final double USD_RATE = 0.095;
        final double EUR_RATE = 0.087;

        while (true) {
            System.out.println("\n=== EXPENSE TRACKER ===");
            System.out.println("1. Add daily expense");
            System.out.println("2. Show total expenses");
            System.out.println("3. Convert to USD");
            System.out.println("4. Convert to EUR");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nSelect day:");
                    for (int i = 0; i < weekDays.length; i++) {
                        System.out.println((i + 1) + ". " + weekDays[i]);
                    }
                    System.out.print("Your choice: ");
                    int dayIndex = scanner.nextInt() - 1;

                    if (dayIndex >= 0 && dayIndex < weekDays.length) {
                        System.out.print("Enter expenses for " + weekDays[dayIndex] + " (SEK): ");
                        weeklyExpenses[dayIndex] = scanner.nextDouble();
                        System.out.println("Expense saved!");
                    } else {
                        System.out.println("Invalid day selection!");
                    }
                    break;

                case 2:
                    double total = 0;
                    System.out.println("\n=== WEEKLY EXPENSES ===");
                    for (int i = 0; i < weekDays.length; i++) {
                        System.out.printf("%s: %.2f SEK\n", weekDays[i], weeklyExpenses[i]);
                        total += weeklyExpenses[i];
                    }
                    System.out.printf("TOTAL: %.2f SEK\n", total);
                    break;

                case 3:
                    total = calculateTotal(weeklyExpenses);
                    System.out.printf("Total in USD: %.2f USD\n", total * USD_RATE);
                    break;

                case 4:
                    total = calculateTotal(weeklyExpenses);
                    System.out.printf("Total in EUR: %.2f EUR\n", total * EUR_RATE);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static double calculateTotal(double[] expenses) {
        double total = 0;
        for (double expense : expenses) {
            total += expense;
        }
        return total;
    }
}