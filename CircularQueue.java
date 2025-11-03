import java.util.*;

class CircularQueue {
    int maxsize;
    int arr[];
    int front;
    int rear;

    CircularQueue(int size) {
        maxsize = size;
        arr = new int[maxsize];
        front = -1;
        rear = -1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    boolean isFull() {
        return (rear + 1) % maxsize == front;
    }

    void add(int i) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % maxsize;
        }
        arr[rear] = i;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int item = arr[front];
        if (front == rear) { // only one element
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxsize;
        }
        return item;
    }

    int peek() {
        if (!isEmpty()) {
            return arr[front];
        } else {
            System.out.println("Queue is Empty");
            return -1;
        }
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue Elements: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % maxsize;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue list = new CircularQueue(5);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60); // will print "Queue is Full"

        list.display();

        System.out.println("Peek Element: " + list.peek());
        System.out.println("Dequeue Element: " + list.dequeue());
        System.out.println("After Dequeue Peek: " + list.peek());

        list.display();
    }
}
