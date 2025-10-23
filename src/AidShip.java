public class AidShip extends Ship implements Navigable, EmergencySupport {
    private double tonnage;
    private int crewSize;
    private String currentPort;
    private String aidType;
    private int suppliesOnBoard;
    private boolean hasHelipad;

    // For Navigable/EmergencySupport (we can keep simple stubs)
    private String status = "IDLE";
    private String currentLocation = "UNKNOWN";

    public AidShip(String registrationNumber, String name, int capacity,
                   double tonnage, int crewSize, String currentPort,
                   String aidType, int suppliesOnBoard, boolean hasHelipad) {
        super(registrationNumber, name, capacity);
        this.tonnage = tonnage;
        this.crewSize = crewSize;
        this.currentPort = currentPort;
        this.aidType = aidType;
        this.suppliesOnBoard = suppliesOnBoard;
        this.hasHelipad = hasHelipad;
    }

    // --- Driver-required getters/setters ---
    public double getTonnage() { return tonnage; }
    public void setTonnage(double tonnage) { this.tonnage = tonnage; }

    public int getCrewSize() { return crewSize; }
    public void setCrewSize(int crewSize) { this.crewSize = crewSize; }

    public String getCurrentPort() { return currentPort; }
    public void setCurrentPort(String currentPort) { this.currentPort = currentPort; }

    public String getAidType() { return aidType; }
    public void setAidType(String aidType) { this.aidType = aidType; }

    public int getSuppliesOnBoard() { return suppliesOnBoard; }
    public void setSuppliesOnBoard(int suppliesOnBoard) { this.suppliesOnBoard = suppliesOnBoard; }

    public boolean isHasHelipad() { return hasHelipad; }
    public void setHasHelipad(boolean hasHelipad) { this.hasHelipad = hasHelipad; }

    // --- Interfaces (simple implementations) ---
    @Override
    public void navigateTo(double latitude, double longitude) {
        this.currentLocation = "(" + latitude + "," + longitude + ")";
        this.status = "EN ROUTE";
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void provideAid() {
        this.status = "PROVIDING AID";
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "AidShip{" +
                "reg='" + getRegistrationNumber() + '\'' +
                ", name='" + getName() + '\'' +
                ", tonnage=" + tonnage +
                ", crewSize=" + crewSize +
                ", currentPort='" + currentPort + '\'' +
                ", aidType='" + aidType + '\'' +
                ", suppliesOnBoard=" + suppliesOnBoard +
                ", hasHelipad=" + hasHelipad +
                '}';
    }
}

