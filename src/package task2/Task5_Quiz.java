import java.util.Scanner;

public class Task5_Quiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        String[][] questions = {
                {"Какая столица Франции?", "1. Лондон", "2. Берлин", "3. Париж", "3"},
                {"Сколько планет в Солнечной системе?", "1. 8", "2. 9", "3. 7", "1"},
                {"Какое животное самое большое?", "1. Слон", "2. Синий кит", "3. Жираф", "2"},
                {"Какой язык программирования мы изучаем?", "1. Python", "2. Java", "3. C++", "2"},
                {"Сколько дней в високосном году?", "1. 365", "2. 366", "3. 364", "2"},
                {"Какая самая длинная река в мире?", "1. Амазонка", "2. Нил", "3. Волга", "1"},
                {"Кто написал 'Войну и мир'?", "1. Достоевский", "2. Толстой", "3. Чехов", "2"},
                {"Сколько цветов у радуги?", "1. 6", "2. 7", "3. 8", "2"},
                {"Какая самая высокая гора в мире?", "1. К2", "2. Эверест", "3. Килиманджаро", "2"},
                {"Какой химический элемент обозначается как Au?", "1. Серебро", "2. Золото", "3. Алюминий", "2"}
        };

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nВопрос " + (i + 1) + ": " + questions[i][0]);
            System.out.println(questions[i][1]);
            System.out.println(questions[i][2]);
            System.out.println(questions[i][3]);

            System.out.print("Ваш ответ (1-3): ");
            String answer = scanner.nextLine();

            if (answer.equals(questions[i][4])) {
                System.out.println("Правильно!");
                score++;
            } else {
                System.out.println("Неправильно! Правильный ответ: " + questions[i][4]);
            }
        }

        System.out.println("\n=== РЕЗУЛЬТАТ ===");
        System.out.println("Правильных ответов: " + score + " из " + questions.length);

        scanner.close();
    }
}