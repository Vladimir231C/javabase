import java.util.Calendar;
import java.util.Date;

/**
 * Класс фитнес‑клуба. Хранит посетителей по зонам и проверяет правила доступа.
 */
public class FitnessClub {

    private static final int CLUB_OPEN = 6;
    private static final int CLUB_CLOSE = 24;

    // посетители в разных зонах (без коллекций — обычные массивы)
    private final Membership[] gymMembers = new Membership[100];
    private final Membership[] poolMembers = new Membership[100];
    private final Membership[] groupMembers = new Membership[100];
    private final Membership[] spaMembers = new Membership[100];

    private int gymCount = 0;
    private int poolCount = 0;
    private int groupCount = 0;
    private int spaCount = 0;

    /**
     * Регистрация посещения конкретной зоны.
     */
    public boolean registerInZone(Membership membership, String zone) {
        if (membership == null || zone == null) {
            return false;
        }

        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        // проверяем режим работы клуба
        if (currentHour < CLUB_OPEN || currentHour >= CLUB_CLOSE) {
            System.out.println("Клуб закрыт для " + membership.getOwner().getFirstName());
            return false;
        }

        // проверяем окончание абонемента
        if (new Date().after(membership.getExpirationDate())) {
            System.out.println("Абонемент истёк у " + membership.getOwner().getFirstName());
            return false;
        }

        // дальше работаем только через полиморфизм (никаких instanceof)
        if (!membership.hasAccessTo(zone)) {
            System.out.println("Абонемент типа " + membership.getType() + " не даёт доступа в " + zone);
            return false;
        }

        if (currentHour < membership.getAccessFrom() || currentHour >= membership.getAccessTo()) {
            System.out.println("Сейчас не время посещения по этому абонементу");
            return false;
        }

        Membership[] targetArray = getArrayByZone(zone);
        if (targetArray == null) {
            return false;
        }

        int count = getCountByZone(zone);

        // проверка, что клиент не зашёл в эту зону второй раз
        for (int i = 0; i < count; i++) {
            if (targetArray[i] != null &&
                    targetArray[i].getOwner().getId() == membership.getOwner().getId()) {
                System.out.println(membership.getOwner().getFirstName() + " уже находится в " + zone);
                return true;
            }
        }

        if (count >= targetArray.length) {
            System.out.println("В зоне " + zone + " нет свободных мест");
            return false;
        }

        targetArray[count] = membership;
        increaseCount(zone);

        System.out.println("Клиент " + membership.getOwner().getFirstName() + " вошёл в " + zone);
        return true;
    }

    /**
     * Клиент покидает конкретную зону.
     */
    public void leaveZone(Membership membership, String zone) {
        if (membership == null || zone == null) {
            return;
        }

        Membership[] targetArray = getArrayByZone(zone);
        if (targetArray == null) {
            return;
        }

        int count = getCountByZone(zone);

        for (int i = 0; i < count; i++) {
            if (targetArray[i] == membership) {
                // сдвигаем массив влево
                for (int j = i; j < count - 1; j++) {
                    targetArray[j] = targetArray[j + 1];
                }
                targetArray[count - 1] = null;
                decreaseCount(zone);

                System.out.println("Клиент " + membership.getOwner().getFirstName() + " вышел из " + zone);
                break;
            }
        }
    }

    /**
     * Закрытие клуба: все зоны очищаются.
     */
    public void closeClub() {
        clearArray(gymMembers, gymCount);
        clearArray(poolMembers, poolCount);
        clearArray(groupMembers, groupCount);
        clearArray(spaMembers, spaCount);

        gymCount = 0;
        poolCount = 0;
        groupCount = 0;
        spaCount = 0;

        System.out.println("Клуб закрывается. Все клиенты покинули залы.");
    }

    /**
     * Смена абонемента для клиента: старый абонемент вычищается из всех зон,
     * возвращаем новый объект абонемента.
     */
    public Membership changeMembership(Client client, Membership newMembership) {
        if (client == null || newMembership == null) {
            return null;
        }

        gymCount = removeClientFromArray(gymMembers, gymCount, client);
        poolCount = removeClientFromArray(poolMembers, poolCount, client);
        groupCount = removeClientFromArray(groupMembers, groupCount, client);
        spaCount = removeClientFromArray(spaMembers, spaCount, client);

        System.out.println("Клиент " + client.getFirstName() +
                " получил новый абонемент типа " + newMembership.getType());

        return newMembership;
    }

    // ==================== ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ====================

    private void clearArray(Membership[] array, int count) {
        for (int i = 0; i < count; i++) {
            array[i] = null;
        }
    }

    /**
     * Удаляет все вхождения клиента из массива и возвращает новое количество элементов.
     */
    private int removeClientFromArray(Membership[] array, int count, Client client) {
        int newCount = count;
        for (int i = 0; i < newCount; i++) {
            if (array[i] != null && array[i].getOwner().getId() == client.getId()) {
                for (int j = i; j < newCount - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[newCount - 1] = null;
                newCount--;
                i--; // остаёмся на том же индексе, т.к. элементы сдвинулись
            }
        }
        return newCount;
    }

    private Membership[] getArrayByZone(String zone) {
        if (zone.equals("gym")) {
            return gymMembers;
        }
        if (zone.equals("pool")) {
            return poolMembers;
        }
        if (zone.equals("group")) {
            return groupMembers;
        }
        if (zone.equals("spa")) {
            return spaMembers;
        }
        return null;
    }

    private int getCountByZone(String zone) {
        if (zone.equals("gym")) {
            return gymCount;
        }
        if (zone.equals("pool")) {
            return poolCount;
        }
        if (zone.equals("group")) {
            return groupCount;
        }
        if (zone.equals("spa")) {
            return spaCount;
        }
        return 0;
    }

    private void increaseCount(String zone) {
        if (zone.equals("gym")) {
            gymCount++;
        } else if (zone.equals("pool")) {
            poolCount++;
        } else if (zone.equals("group")) {
            groupCount++;
        } else if (zone.equals("spa")) {
            spaCount++;
        }
    }

    private void decreaseCount(String zone) {
        if (zone.equals("gym")) {
            gymCount--;
        } else if (zone.equals("pool")) {
            poolCount--;
        } else if (zone.equals("group")) {
            groupCount--;
        } else if (zone.equals("spa")) {
            spaCount--;
        }
    }
}