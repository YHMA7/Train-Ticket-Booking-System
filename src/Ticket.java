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

public class Ticket {
    private Passenger passenger; // Associated passenger for the ticket
    private Train train;         // Associated train for the ticket

    public Ticket(Passenger passenger, Train train) {
        this.passenger = passenger;
        this.train = train;
    }

    // Returns the passenger associated with this ticket
    public Passenger getPassenger() {
        return passenger;
    }

    // Returns the train associated with this ticket
    public Train getTrain() {
        return train;
    }
}
