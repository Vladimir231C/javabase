/**
 * Обычный клиент фитнес‑клуба.
 * Здесь только данные владельца абонемента.
 */
public class Client {

    private final int id;
    private String firstName;
    private String lastName;
    private int birthYear;

    public Client(int id, String firstName, String lastName, int birthYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (id=" + id + ", год рождения " + birthYear + ")";
    }
}