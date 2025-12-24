/**
 * Простейшая проверка работы клуба.
 */
public class Main {
    public static void main(String[] args) {
        Client client1 = new Client(1, "Пётр", "Лабзиев", 1990);
        Client client2 = new Client(2, "Катя", "Дарова", 1985);

        Membership regular = new RegularMembership(client1);
        Membership vip = new VIPMembership(client2);

        FitnessClub club = new FitnessClub();

        System.out.println("=== Доступ по исходным абонементам ===");
        club.registerInZone(regular, "gym");   // должно пустить
        club.registerInZone(regular, "pool");  // должно отказать

        club.registerInZone(vip, "pool");      // VIP в бассейн
        club.registerInZone(vip, "group");     // VIP на групповое занятие

        System.out.println();

        System.out.println("=== Смена абонемента клиента 1 на VIP ===");
        Membership newVipForClient1 = club.changeMembership(client1, new VIPMembership(client1));

        System.out.println();

        System.out.println("=== Проверка нового абонемента клиента 1 ===");
        club.registerInZone(newVipForClient1, "pool");

        System.out.println();

        System.out.println("=== Закрытие клуба ===");
        club.closeClub();
    }
}