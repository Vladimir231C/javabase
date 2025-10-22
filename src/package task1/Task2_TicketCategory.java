import java.util.Scanner;

public class Task2_TicketCategory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите возраст посетителя: ");
        int age = scanner.nextInt();
        
        String category;
        
        if (age < 7) {
            category = "детский";
        } else if (age >= 7 && age <= 17) {
            category = "подросток";
        } else if (age >= 18 && age <= 60) {
            category = "взрослый";
        } else if (age >= 61) {
            category = "пенсионный";
        } else {
            category = "неопределенная категория";
        }
        
        System.out.println("Категория билета: " + category);
        
        scanner.close();
    }
}

