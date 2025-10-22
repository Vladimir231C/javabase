import java.util.Scanner;

public class Task8_MovieList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] movies = new String[30];
        int movieCount = 0;

        System.out.println("Введите фильмы для просмотра (максимум 30). Для выхода введите 'exit'");

        while (movieCount < 30) {
            System.out.print("Фильм " + (movieCount + 1) + ": ");
            String movie = scanner.nextLine();

            if (movie.equalsIgnoreCase("exit")) {
                break;
            }

            movies[movieCount] = movie;
            movieCount++;
        }

        if (movieCount == 0) {
            System.out.println("Список фильмов пуст!");
        } else {
            System.out.println("\n=== ВАШ СПИСОК ФИЛЬМОВ ===");
            for (int i = 0; i < movieCount; i++) {
                System.out.println((i + 1) + ". " + movies[i]);
            }
        }

        scanner.close();
    }
}