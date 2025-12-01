package Lab_6;

public class Stack<T> {
    private Object[] elements;
    private int size;

    public Stack(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == elements.length) {
            System.out.println("Стек переполнен!");
            return;
        }
        elements[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0) {
            System.out.println("Стек пуст!");
            return null;
        }
        size--;
        @SuppressWarnings("unchecked")
        T element = (T) elements[size];
        elements[size] = null;
        return element;
    }

    public T peek() {
        if (size == 0) {
            System.out.println("Стек пуст!");
            return null;
        }
        @SuppressWarnings("unchecked")
        T element = (T) elements[size - 1];
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack<Integer> numberStack = new Stack<>(5);

        numberStack.push(10);
        numberStack.push(20);
        numberStack.push(30);

        System.out.println("Верхний элемент: " + numberStack.peek());
        System.out.println("Размер: " + numberStack.size());
        System.out.println("Извлекли: " + numberStack.pop());
        System.out.println("Извлекли: " + numberStack.pop());
        System.out.println("Верхний теперь: " + numberStack.peek());

        Stack<String> stringStack = new Stack<>(3);
        stringStack.push("Привет");
        stringStack.push("Мир");

        System.out.println("Строка: " + stringStack.pop());
        System.out.println("Строка: " + stringStack.pop());
    }
}