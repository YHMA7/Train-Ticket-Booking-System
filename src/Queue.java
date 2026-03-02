/**
 *
 * @author Yazan
 */
/*
Course : CPCS 204
Name : Yazan Hussain Alyami
University ID : 2339804
Section : CS7
Name of lab instructor :  Ali Alkhathlan
Problem number :  1
Assignment number :  #3
*/

public class Queue<T> {
    private Node<T> front; // Front element of the queue
    private Node<T> rear;  // Rear element of the queue

    public Queue() {
        this.front = this.rear = null;
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Adds an item to the rear of the queue
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }

    // Removes and returns the front item from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    // Returns the front item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        return front.data;
    }

    // Returns the current size of the queue
    public int size() {
        int count = 0;
        Node<T> current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
