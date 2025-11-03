class MyQueue {
    int size;
    int front;
    int rear;
    int arr[];

    // Constructor
    MyQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
    }

    // Insert (Enqueue)
    void insertQueue(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
            return;
        }
        arr[++rear] = data;
        System.out.println(data + " inserted");
    }

    // Delete (Dequeue)
    void deleteQueue() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(arr[front] + " removed");
        front++;
    }

    // Display
    void display() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Elements in Queue:");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {
        MyQueue list = new MyQueue(10);
        list.insertQueue(20);
        list.insertQueue(30);
        list.insertQueue(40);
        list.insertQueue(50);

        System.out.println("Before Deletion:");
        list.display();

        System.out.println("After Deletion:");
        list.deleteQueue();
        list.display();
    }
}
