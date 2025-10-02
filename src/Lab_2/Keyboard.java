package Lab_2;

public class Keyboard extends ComputerPeripheral {
    private String type;
    private boolean hasBacklight;

    public Keyboard() {
        super();
        this.type = "Mechanical";
        this.hasBacklight = false;
    }

    public Keyboard(String brand, String connection, double price, String type, boolean backlight) {
        super(brand, connection, price);
        this.type = type;
        this.hasBacklight = backlight;
    }

    @Override
    public String getDeviceInfo() {
        return "Клавиатура " + getBrand() + " [" + type + "] ID:" + getObjectId();
    }

    @Override
    public void performAction() {
        System.out.println("Клавиатура " + getBrand() + " печатает текст");
    }

    // Специфичные методы
    public void type(String text) {
        System.out.println("Печатаем: " + text);
    }

    // Геттеры/сеттеры
    public String getType() { return type; }
    public boolean hasBacklight() { return hasBacklight; }
    public void setType(String type) { this.type = type; }
    public void setBacklight(boolean backlight) { this.hasBacklight = backlight; }
}