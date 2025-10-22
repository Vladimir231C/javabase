import java.util.Random;

public class Task3_TestGrade {
    public static void main(String[] args) {
        Random random = new Random();
        int score = random.nextInt(100) + 1;

        String grade;
        if (score >= 90) {
            grade = "отлично";
        } else if (score >= 60) {
            grade = "хорошо";
        } else if (score >= 40) {
            grade = "удовлетворительно";
        } else {
            grade = "неудовлетворительно";
        }

        System.out.println("Баллы: " + score + " - оценка: " + grade);
    }
}
