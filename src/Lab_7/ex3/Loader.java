package Lab_7.ex3;

public class Loader extends Thread {
    private static int totalWeight = 0;
    private static final int MAX_WEIGHT = 150;

    private Warehouse source;
    private Warehouse destination;
    private String name;

    public Loader(String name, Warehouse source, Warehouse destination) {
        this.name = name;
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void run() {
        try {
            while (!source.isEmpty()) {
                Product product = source.takeProduct();
                if (product == null) break;

                synchronized (Loader.class) {
                    if (totalWeight + product.getWeight() > MAX_WEIGHT) {
                        System.out.println(name + ": Набрано " + totalWeight + " кг, едем разгружать!");
                        Thread.sleep(1000);
                        totalWeight = 0;
                        System.out.println(name + ": Вернулся");
                    }

                    totalWeight += product.getWeight();
                    destination.addProduct(product);
                    System.out.println(name + " взял товар " + product.getWeight() + " кг, всего: " + totalWeight + " кг");
                }

                Thread.sleep(200);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}