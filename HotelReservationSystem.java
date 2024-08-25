package HotelReservationPackage;
import java.util.Scanner;
class Room {
    private String roomType;
    private double pricePerNight;

    public Room(String roomType, double pricePerNight) {
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public double calculateTotalPrice(int numberOfNights) {
        return pricePerNight * numberOfNights;
    }
}

class SingleRoom extends Room {
    public SingleRoom(double pricePerNight) {
        super("Single", pricePerNight);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom(double pricePerNight) {
        super("Suite", pricePerNight);
    }
}

class Reservation {
    private String guestName;
    private int numberOfNights;
    private Room room;
    
    public Reservation(String guestName, int numberOfNights, Room room) {
        this.guestName = guestName;
        this.numberOfNights = numberOfNights;
        this.room = room;
    }

    public double getTotalPrice() {
        return room.calculateTotalPrice(numberOfNights);
    }

    public String getReservationDetails() {
        return "Guest Name: " + guestName + "\nRoom Type: " + room.getRoomType() +
               "\nNumber of Nights: " + numberOfNights + "\nTotal Price: $" + getTotalPrice();
    }
}

class Hotel {
    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    public void bookRoom(Reservation reservation) {
        System.out.println("Reservation confirmed for " + reservation.getReservationDetails());
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel("Grandview Hotel");

        while (true) {
            System.out.println("Welcome to Grandview Hotel Reservation System..");
            System.out.println("--------");
            System.out.print("Enter guest name: ");
            String guestName = sc.nextLine();
            System.out.print("Enter number of nights: ");
            int numberOfNights = sc.nextInt();
            sc.nextLine(); 

            System.out.println("Select room type:");
            System.out.println("1. Single Room\n2. Suite Room");
            int roomChoice = sc.nextInt();
            sc.nextLine();  

            Room room = null;
            switch (roomChoice) {
                case 1:
                    room = new SingleRoom(100.00); 
                    break;
                case 2:
                    room = new SuiteRoom(200.00);
                    break;
                default:
                    System.out.println("Invalid room type selected.");
                    continue;
            }

            Reservation reservation = new Reservation(guestName, numberOfNights, room);
            hotel.bookRoom(reservation);

            System.out.println("--------");
            System.out.println("1. Make another reservation\n2. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  

            if (choice == 2) {
                sc.close();
                break;
            }
        }
    }
}
