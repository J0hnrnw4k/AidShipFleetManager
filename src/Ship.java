public class Ship{
    private String registrationNumber;
    private String name;
    private int capacity;

    public Ship(String registrationNumber, String name, int capacity) {
        this.registrationNumber = registrationNumber;
        this.name = name;
        this.capacity = capacity;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setRegistrationNumber(String registrationNumber) {
       this.registrationNumber = registrationNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return "Ship{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

