/**
 * Обычный абонемент: зал + спа, с 8 до 22.
 */
public class RegularMembership extends Membership {

    private final String type = "REGULAR";
    // без коллекций: обычный массив строк
    private final String[] allowedZones = {"gym", "spa"};
    private final int accessFrom = 8;
    private final int accessTo = 22;

    public RegularMembership(Client owner) {
        super(owner);
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getAccessFrom() {
        return accessFrom;
    }

    @Override
    public int getAccessTo() {
        return accessTo;
    }

    @Override
    public boolean hasAccessTo(String zone) {
        // простой перебор разрешённых зон
        for (int i = 0; i < allowedZones.length; i++) {
            if (allowedZones[i].equals(zone)) {
                return true;
            }
        }
        return false;
    }
}