package Lab_7.ex3;

import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {
    private Queue<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product takeProduct() {
        return products.poll();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}
