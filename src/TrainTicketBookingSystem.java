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

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

// Main booking system class managing train ticket bookings
public class TrainTicketBookingSystem {
    private Train train;                     // Single train in the system
    private Queue<Ticket> waitingList;       // Queue for passengers in waiting list
    private Stack<Ticket> confirmedBookings; // Stack for confirmed bookings
    private Queue<Passenger> passengers;     // Queue for passengers

    public TrainTicketBookingSystem() {
        waitingList = new Queue<>();
        confirmedBookings = new Stack<>();
        passengers = new Queue<>();
    }

    // Adds a train to the system
    public void addTrain(String trainId, int capacity, PrintWriter writer) {
        train = new Train(trainId, capacity);
        writer.println("Train " + trainId + " with capacity " + capacity + " has been added.");
    }

    // Adds a passenger to the system
    public void addPassenger(String passengerId, String name, PrintWriter writer) {
        Passenger passenger = new Passenger(passengerId, name);
        passengers.enqueue(passenger);
        writer.println("Passenger " + name + " (ID: " + passengerId + ") has been added to the system.");
    }

    // Books a seat for the specified passenger
    public void bookSeat(String passengerId, PrintWriter writer) {
        if (train == null) {
            writer.println("No train available.");
            return;
        }

        Passenger passenger = null;
        Queue<Passenger> tempQueue = new Queue<>();
        while (!passengers.isEmpty()) {
            Passenger p = passengers.dequeue();
            if (p.getId().equals(passengerId)) {
                passenger = p;
            }
            tempQueue.enqueue(p);
        }
        while (!tempQueue.isEmpty()) passengers.enqueue(tempQueue.dequeue());

        if (passenger == null) {
            writer.println("Passenger not found.");
            return;
        }

        if (confirmedBookings.size() < train.getCapacity()) {
            confirmedBookings.push(new Ticket(passenger, train));
            writer.println("Booking confirmed for Passenger " + passenger.getName() + " (ID: " + passengerId + ").");
        } else {
            waitingList.enqueue(new Ticket(passenger, train));
            writer.println("No seats for " + passenger.getName() + " (ID: " + passengerId + "), added to waiting list.");
        }
    }

    // Cancels a booking for the specified passenger
    public void cancelBooking(String passengerId, PrintWriter writer) {
        Stack<Ticket> tempStack = new Stack<>();
        boolean found = false;

        while (!confirmedBookings.isEmpty()) {
            Ticket ticket = confirmedBookings.pop();
            if (ticket.getPassenger().getId().equals(passengerId)) {
                found = true;
                writer.println("Booking cancelled for Passenger " + ticket.getPassenger().getName() + " (ID: " + passengerId + ").");
                break;
            } else {
                tempStack.push(ticket);
            }
        }
        while (!tempStack.isEmpty()) {
            confirmedBookings.push(tempStack.pop());
        }

        if (found && !waitingList.isEmpty()) {
            Ticket waitingTicket = waitingList.dequeue();
            confirmedBookings.push(waitingTicket);
            writer.println("Booking confirmed for Passenger " + waitingTicket.getPassenger().getName() + " (ID: " + waitingTicket.getPassenger().getId() + ").");
        }
    }

    // Displays the list of confirmed bookings
    public void showConfirmed(PrintWriter writer) {
        writer.println("------------------CONFIRMED PASSENGER------------------");
        writer.println("| Passenger ID    | Name            | Train ID        |");
        writer.println("| --------------- | --------------- | --------------- |");

        Stack<Ticket> tempStack = new Stack<>();
        while (!confirmedBookings.isEmpty()) {
            Ticket ticket = confirmedBookings.pop();
            Passenger passenger = ticket.getPassenger();
            writer.printf("| %-15s | %-15s | %-15s |%n", passenger.getId(), passenger.getName(), ticket.getTrain().getId());
            tempStack.push(ticket);
        }

        // Restore confirmedBookings stack after printing
        while (!tempStack.isEmpty()) {
            confirmedBookings.push(tempStack.pop());
        }
    }

    // Displays the list of passengers on the waiting list
    public void showWaiting(PrintWriter writer) {
        writer.println("------------------WAITING PASSENGER--------------------");
        writer.println("| Passenger ID    | Name            | Train ID        |");
        writer.println("| --------------- | --------------- | --------------- |");

        Queue<Ticket> tempQueue = new Queue<>();
        while (!waitingList.isEmpty()) {
            Ticket ticket = waitingList.dequeue();
            Passenger passenger = ticket.getPassenger();
            writer.printf("| %-15s | %-15s | %-15s |%n", passenger.getId(), passenger.getName(), ticket.getTrain().getId());
            tempQueue.enqueue(ticket);
        }

        // Restore waitingList queue after printing
        while (!tempQueue.isEmpty()) {
            waitingList.enqueue(tempQueue.dequeue());
        }
    }

    // Main method to read input commands and execute them
    public static void main(String[] args) {
        TrainTicketBookingSystem system = new TrainTicketBookingSystem();

        try (Scanner scanner = new Scanner(new File("input.txt"));
             PrintWriter writer = new PrintWriter("output.txt")) {

            // Read and process each command from the input file
            while (scanner.hasNextLine()) {
                String[] command = scanner.nextLine().split(" ");
                switch (command[0]) {
                    case "add_train":
                        system.addTrain(command[1], Integer.parseInt(command[2]), writer);
                        break;
                    case "add_passenger":
                        system.addPassenger(command[1], command[2], writer);
                        break;
                    case "book":
                        system.bookSeat(command[1], writer);
                        break;
                    case "cancel":
                        system.cancelBooking(command[1], writer);
                        break;
                    case "show_confirmed":
                        system.showConfirmed(writer);
                        break;
                    case "show_waiting":
                        system.showWaiting(writer);
                        break;
                    default:
                        writer.println("Invalid command: " + command[0]);
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

