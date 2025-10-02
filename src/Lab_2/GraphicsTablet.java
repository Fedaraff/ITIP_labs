package Lab_2;

public class GraphicsTablet extends ComputerPeripheral {
    private int pressureLevels;
    private boolean hasTouch;

    public GraphicsTablet() {
        super();
        this.pressureLevels = 2048;
        this.hasTouch = false;
    }

    public GraphicsTablet(String brand, String connection, double price, int levels, boolean touch) {
        super(brand, connection, price);
        this.pressureLevels = levels;
        this.hasTouch = touch;
    }

    @Override
    public String getDeviceInfo() {
        return "Планшет " + getBrand() + " [" + pressureLevels + " уровней] ID:" + getObjectId();
    }

    @Override
    public void performAction() {
        System.out.println("Планшет " + getBrand() + " рисует");
    }

    // Специфичные методы
    public void draw() {
        System.out.println("Рисуем с чувствительностью " + pressureLevels + " уровней");
    }

    // Геттеры/сеттеры
    public int getPressureLevels() { return pressureLevels; }
    public boolean hasTouch() { return hasTouch; }
    public void setPressureLevels(int levels) { this.pressureLevels = levels; }
    public void setHasTouch(boolean touch) { this.hasTouch = touch; }
}