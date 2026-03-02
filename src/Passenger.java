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

public class Passenger {
    private String id;   // Unique ID of the passenger
    private String name; // Name of the passenger

    public Passenger(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Returns passenger ID
    public String getId() {
        return id;
    }

    // Returns passenger name
    public String getName() {
        return name;
    }
}

