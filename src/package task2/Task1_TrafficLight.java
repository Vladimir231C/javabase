import java.util.Random;

public class Task1_TrafficLight {
    public static void main(String[] args) {
        Random random = new Random();
        int colorCode = random.nextInt(3); // 0, 1 или 2

        String colorName;
        switch (colorCode) {
            case 0:
                colorName = "Красный";
                break;
            case 1:
                colorName = "Зеленый";
                break;
            case 2:
                colorName = "Желтый";
                break;
            default:
                colorName = "Неизвестный цвет";
        }

        System.out.println("Код цвета: " + colorCode);
        System.out.println("Цвет светофора: " + colorName);
    }
}
