import java.util.Scanner;

class CircularQueue {
    int[] queue;
    int front;
    int rear;
    int size;

    CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }

    // Enqueue operation
    void enqueue(int value) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is Full!");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        queue[rear] = value;

        System.out.println(value + " inserted into the queue.");
    }

    // Dequeue operation
    void dequeue() {
        if (front == -1) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.println(queue[front] + " deleted from the queue.");

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    // Display operation
    void display() {
        if (front == -1) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.print("Circular Queue: ");

        int i = front;

        while (true) {
            System.out.print(queue[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }
}

public class CircularQueuePractical {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int size = sc.nextInt();

        CircularQueue cq = new CircularQueue(size);

        while (true) {
            System.out.println("\n--- Circular Queue Menu ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    cq.enqueue(value);
                    break;

                case 2:
                    cq.dequeue();
                    break;

                case 3:
                    cq.display();
                    break;

                case 4:
                    System.out.println("Program exited.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}