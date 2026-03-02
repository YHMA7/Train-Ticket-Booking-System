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

public class Stack<T> {
    private Node<T> top; // Top element of the stack

    public Stack() {
        this.top = null;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Pushes an item onto the stack
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    // Removes and returns the top item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot POP; stack is empty.");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    // Returns the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        return top.data;
    }

    // Returns the current size of the stack
    public int size() {
        int count = 0;
        Node<T> current = top;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
