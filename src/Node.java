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

public class Node<T> {
    T data;           // Data contained in the node
    Node<T> next;     // Pointer to the next node

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}
