package Lab_2;

public abstract class ComputerPeripheral {
    private static int objectCount = 0;

    private String brand;
    private String connectionType;
    private double price;
    private int objectId;

    // Конструкторы
    public ComputerPeripheral(String brand, String connectionType, double price) {
        this.brand = brand;
        this.connectionType = connectionType;
        this.price = price;
        this.objectId = ++objectCount;
    }

    // Абстрактные методы
    public abstract String getDeviceInfo();
    public abstract void performAction();

    // Геттеры
    public String getBrand() { return brand; }
    public String getConnectionType() { return connectionType; }
    public double getPrice() { return price; }
    public int getObjectId() { return objectId; }
    public static int getTotalObjects() { return objectCount; }

    // Сеттеры
    public void setBrand(String brand) { this.brand = brand; }
    public void setConnectionType(String type) { this.connectionType = type; }
    public void setPrice(double price) { this.price = price; }

    // Общий метод
    public String getBasicInfo() {
        return brand + " (" + connectionType + ") - " + price + " руб.";
    }
}