package Lab_6;

public class Stack<T> {
    private Object[] elements;  // Храним элементы как Object[]
    private int size;           // Текущий размер стека

    // Создаем стек с указанным размером
    public Stack(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    // Добавляем элемент на вершину стека
    public void push(T element) {
        if (size == elements.length) {
            System.out.println("Стек переполнен!");
            return;
        }
        elements[size] = element;
        size++;
    }

    // Удаляем и возвращаем верхний элемент
    public T pop() {
        if (size == 0) {
            System.out.println("Стек пуст!");
            return null;
        }
        size--;
        @SuppressWarnings("unchecked")
        T element = (T) elements[size];  // Приводим обратно к типу T
        elements[size] = null;           // Убираем ссылку
        return element;
    }

    // Смотрим верхний элемент без удаления
    public T peek() {
        if (size == 0) {
            System.out.println("Стек пуст!");
            return null;
        }
        @SuppressWarnings("unchecked")
        T element = (T) elements[size - 1];  // Приводим обратно к типу T
        return element;
    }

    // Проверяем пуст ли стек
    public boolean isEmpty() {
        return size == 0;
    }

    // Показываем текущий размер
    public int size() {
        return size;
    }

    // Тестируем стек
    public static void main(String[] args) {
        // Стек для чисел
        Stack<Integer> numberStack = new Stack<>(5);

        numberStack.push(10);
        numberStack.push(20);
        numberStack.push(30);

        System.out.println("Верхний элемент: " + numberStack.peek());  // 30
        System.out.println("Размер: " + numberStack.size());           // 3

        System.out.println("Извлекли: " + numberStack.pop());          // 30
        System.out.println("Извлекли: " + numberStack.pop());          // 20
        System.out.println("Верхний теперь: " + numberStack.peek());   // 10

        // Стек для строк
        Stack<String> stringStack = new Stack<>(3);
        stringStack.push("Привет");
        stringStack.push("Мир");

        System.out.println("Строка: " + stringStack.pop());  // Мир
        System.out.println("Строка: " + stringStack.pop());  // Привет
    }
}