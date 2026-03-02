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

public class Train {
    private String id;      // Unique ID of the train
    private int capacity;   // Capacity of the train

    public Train(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    // Returns train ID
    public String getId() {
        return id;
    }

    // Returns train capacity
    public int getCapacity() {
        return capacity;
    }
}
