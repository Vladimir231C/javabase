import java.util.Scanner;

public class Task6_Probability {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество торпед (n): ");
        int n = scanner.nextInt();

        System.out.print("Введите вероятность попадания торпеды (p): ");
        double p = scanner.nextDouble();

        System.out.print("Введите вероятность затопления лодки (p1): ");
        double p1 = scanner.nextDouble();

        // q = (1-p)(1-p1)
        double q = (1 - p) * (1 - p1);

        //  P(A) = p*p1*(1-q^n)/(1-q)
        double probability;
        if (q == 1) {
            // Если q=1, 
            probability = p * p1 * n;
        } else {
            probability = p * p1 * (1 - Math.pow(q, n)) / (1 - q);
        }

        System.out.println("\nРезультаты расчета:");
        System.out.printf("Количество торпед: %d\n", n);
        System.out.printf("Вероятность попадания торпеды: %.3f\n", p);
        System.out.printf("Вероятность затопления лодки: %.3f\n", p1);
        System.out.printf("Вероятность затопления корабля и подводной лодки: %.4f\n", probability);
        System.out.printf("(%.2f%%)\n", probability * 100);

        scanner.close();
    }
}