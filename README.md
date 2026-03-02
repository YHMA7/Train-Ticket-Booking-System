# Train Ticket Booking System

A specialized Java application developed for the **CPCS-204: Data Structures** course at **King Abdulaziz University**. This system simulates a real-world ticketing environment, focusing on efficient data management using custom-built data structures.

---

## 🚀 Key Features
* **Custom Data Structures**: Built from scratch without using built-in libraries, including **Linked Lists (Nodes)**, **Generic Stacks**, and **Generic Queues**.
* **Confirmed Booking Management**: Uses a **Stack** structure to manage confirmed passengers, allowing for specific cancellation logic (LIFO approach for last-in confirmed seats).
* **Automated Waiting List**: Implements a **Queue** (FIFO) to manage passengers when the train reaches full capacity, ensuring fair priority for the next available seat.
* **Dynamic Cancellation & Re-assignment**: When a booking is cancelled, the system automatically pulls the next eligible passenger from the waiting list to fill the vacancy.
* **File-Based Processing**: Supports bulk command execution via `input.txt` and logs all operations (bookings, cancellations, and status reports) into `output.txt`.

---

## 🏗️ System Architecture
The project follows a modular design with dedicated classes for each entity:
* **TrainTicketBookingSystem**: The main engine that processes commands like `add_train`, `book`, and `cancel`.
* **Stack <T>**: Used for managing `Confirmed Bookings`.
* **Queue <T>**: Used for the `Waiting List` and `Passenger` records.
* **Node <T>**: The foundational building block for the linked-based data structures.
* **Entities**: Includes `Train`, `Passenger`, and `Ticket` classes to maintain data integrity.

---

## 🛠️ Tech Stack
* **Language**: Java.
* **Concepts**: Data Structures (Stacks, Queues, Linked Lists), Generics, File I/O.
* **Environment**: Developed and tested as part of the academic curriculum at KAU.
