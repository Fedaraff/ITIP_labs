package Lab_7.ex3;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Warehouse source = new Warehouse();
        Warehouse destination = new Warehouse();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            source.addProduct(new Product(random.nextInt(30) + 10));
        }

        Loader loader1 = new Loader("Грузчик 1", source, destination);
        Loader loader2 = new Loader("Грузчик 2", source, destination);
        Loader loader3 = new Loader("Грузчик 3", source, destination);

        loader1.start();
        loader2.start();
        loader3.start();

        loader1.join();
        loader2.join();
        loader3.join();

        System.out.println("Все товары перенесены!");
    }
}