package Lab_2;

public class Headphones extends ComputerPeripheral {
    private String type;
    private boolean noiseCancelling;

    public Headphones() {
        super();
        this.type = "Over-ear";
        this.noiseCancelling = false;
    }

    public Headphones(String brand, String connection, double price, String type, boolean noiseCancelling) {
        super(brand, connection, price);
        this.type = type;
        this.noiseCancelling = noiseCancelling;
    }

    @Override
    public String getDeviceInfo() {
        return "Наушники " + getBrand() + " [" + type + "] ID:" + getObjectId();
    }

    @Override
    public void performAction() {
        System.out.println("Наушники " + getBrand() + " воспроизводят звук");
    }

    // Специфичные методы
    public void playMusic(String song) {
        System.out.println("Играет: " + song);
    }

    // Геттеры/сеттеры
    public String getType() { return type; }
    public boolean hasNoiseCancelling() { return noiseCancelling; }
    public void setType(String type) { this.type = type; }
    public void setNoiseCancelling(boolean nc) { this.noiseCancelling = nc; }
}