import java.util.Scanner;

public class Task5_ProjectileCoordinates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальную скорость (м/с): ");
        double velocity = scanner.nextDouble();

        System.out.print("Введите угол броска (градусы): ");
        double angleDegrees = scanner.nextDouble();

        
        double angleRadians = Math.toRadians(angleDegrees);
        final double GRAVITY = 9.81;

        // t = (2v₀sinα)/g
        double flightTime = (2 * velocity * Math.sin(angleRadians)) / GRAVITY;

        System.out.printf("Время полета: %.2f секунд\n", flightTime);

        System.out.print("Введите момент времени для расчета координат: ");
        double time = scanner.nextDouble();

        if (time > flightTime) {
            System.out.println("Время превышает время полета!");
            scanner.close();
            return;
        }

        //  x = v₀tcosα, y = v₀tsinα - (gt²)/2
        double x = velocity * time * Math.cos(angleRadians);
        double y = velocity * time * Math.sin(angleRadians) - (GRAVITY * time * time) / 2;

        System.out.printf("Координаты тела в момент времени %.2f с:\n", time);
        System.out.printf("x = %.2f м, y = %.2f м\n", x, y);

        scanner.close();
    }
}
