/**
 * VIP‑абонемент: доступ во все зоны, с 6 до 24.
 */
public class VIPMembership extends Membership {

    private final String type = "VIP";
    private final String[] allowedZones = {"gym", "pool", "group", "spa"};
    private final int accessFrom = 6;
    private final int accessTo = 24;

    public VIPMembership(Client owner) {
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
        for (int i = 0; i < allowedZones.length; i++) {
            if (allowedZones[i].equals(zone)) {
                return true;
            }
        }
        return false;
    }
}