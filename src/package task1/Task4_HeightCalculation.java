public class Task4_HeightCalculation {
    public static void main(String[] args) {

        double initialVelocity = 20.0;        // начальная скорость (м/с)
        double time = 2.0;                    // время полета (с)
        final double GRAVITY = 9.81;          // ускорение свободного падения (м/с²)

        //  h = v₀t - (gt²)/2
        double height = initialVelocity * time - (GRAVITY * time * time) / 2;

        System.out.printf("Начальная скорость: %.1f м/с\n", initialVelocity);
        System.out.printf("Время: %.1f с\n", time);
        System.out.printf("Ускорение свободного падения: %.2f м/с²\n", GRAVITY);
        System.out.printf("Высота тела через %.1f секунд: %.2f метров\n", time, height);
    }
}
