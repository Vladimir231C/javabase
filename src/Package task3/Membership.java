import java.util.Calendar;
import java.util.Date;

/**
 * Абстрактный базовый класс для всех типов абонементов.
 *
 * Здесь сосредоточена общая информация: владелец, дата регистрации,
 * дата окончания и "каркас" для правил доступа.
 */
public abstract class Membership {

    protected Client owner;            // владелец абонемента
    protected Date registrationDate;   // дата регистрации
    protected Date expirationDate;     // дата истечения

    public Membership(Client owner) {
        this.owner = owner;
        this.registrationDate = new Date();
        this.expirationDate = calculateExpiration();
    }

    /**
     * По умолчанию абонемент действует 1 год.
     * Если когда-нибудь понадобится другой срок, можно будет переопределить.
     */
    protected Date calculateExpiration() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(registrationDate);
        calendar.add(Calendar.YEAR, 1);
        return calendar.getTime();
    }

    // Базовый "контракт" для всех абонементов: каждый обязан сообщать
    // тип, разрешённые часы и проверять доступ к зоне.
    public abstract String getType();

    public abstract int getAccessFrom();

    public abstract int getAccessTo();

    public abstract boolean hasAccessTo(String zone);

    // Общие геттеры
    public Client getOwner() {
        return owner;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}