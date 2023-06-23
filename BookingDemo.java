package Assignment_2;


import Assignment_2.Booking;
import Assignment_2.Airport;
import Assignment_2.Airline;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/*
 * Name: Ibrahem Basher hamed ahmad.
 * Email: i.b7sher99@gmail.com
 * course number: CPCS_203.
 * section number: (12163)(EE). 
 * assignment title: Airline Ticket Reservation System.
 * date: Mar 24, 2021.
 */
public class BookingDemo {

    // Every part of the file that has been read will be saved in command.
    static String command = null;
    // the index of Booking array and the total number of Booking.
    static int totalBokking = -1;

    public static void main(String[] args) throws FileNotFoundException {

        // opening the files.
        File fileDB = new File("inputDB.txt");
        File fileBooking = new File("inputBookings.txt");

        // check if the files exist or not.
        if (!fileDB.exists() || !fileBooking.exists()) {
            if (!fileDB.exists() && !fileBooking.exists()) {
                System.out.println("File \"inputDB.txt\" and \"inputBookings.txt\" are Not Found.");
                System.exit(0);
            } else if (!fileDB.exists()) {
                System.out.println("File \"inputDB.txt\" Not Found.");
                System.exit(0);
            } else {
                System.out.println("File \"inputBookings.txt\" Not Found.");
            }
            System.exit(0);
        }

        // reading data from files.
        Scanner readDB = new Scanner(fileDB);
        Scanner readBooking = new Scanner(fileBooking);

        // create new files for output.
        File printLog = new File("printLog.txt");
        File printBookings = new File("printBookings.txt");

        // object for writing data on file.
        PrintWriter writeLog = new PrintWriter(printLog);
        PrintWriter writeBooking = new PrintWriter(printBookings);

        // create array of object for Airline, Airport and Flight classes.
        Airline[] listAirline = new Airline[readDB.nextInt()];
        Airport[] listAirport = new Airport[readDB.nextInt()];
        Flight[] listFlight = new Flight[readDB.nextInt()];

        // print The main title of the Log file.
        writeLog.println("--------------- Air Ticket Reservation System Log ---------------\n\n");

        // Add and print Airline, Airport and Flight Records.
        int index = 0;
        do {
            command = readDB.next();
            if (command.equalsIgnoreCase("ADD_Airline")) {
                listAirline[index] = new Airline(readDB.next(), readDB.next(), readDB.next(), readDB.next());
                writeLog.println(listAirline[index].toString());
                index++;
                if (index > 5) {
                    index = 0;
                }
            } else if (command.equalsIgnoreCase("ADD_Airport")) {
                listAirport[index] = new Airport(readDB.next(), readDB.next(), readDB.next());
                writeLog.println(listAirport[index].toString());
                index++;
                if (index > 8) {
                    index = 0;
                }
            } else if (command.equalsIgnoreCase("ADD_Flight")) {
                listFlight[index] = new Flight(readDB.next(), readDB.next(), readDB.next(), readDB.nextDouble());
                writeLog.println(listFlight[index].toString());
                index++;

            }

        } while (!(command.equalsIgnoreCase("Quit")));
        // close writer and file.
        writeLog.flush();
        writeLog.close();
        readDB.close();

        // create array of object for Booking class.
        Booking[] listBooking = new Booking[readBooking.nextInt()];

        // print The main title of the booking tickets.
        writeBooking.println("--------------- Welcome to Air Ticket Reservation System ---------------\n\n");

        // Add Booking Records and Print all booking tickets with fare calculation.
        index = 0;
        do {
            command = readBooking.next();
            if (command.equalsIgnoreCase("NewBooking")) {
                GenerateBooking(readBooking, listFlight, listAirline, listAirport, listBooking, writeBooking);
                PrintBooking(listBooking[index], writeBooking);
                index++;
            }

        } while (!(command.equalsIgnoreCase("Quit")));
        // close writer and file.
        writeBooking.flush();
        writeBooking.close();
        readBooking.close();
    }

    // search for the airline object associated with the given code.
    private static Airline getAirline(Scanner readBooking, Airline[] listAirline) {
        command = readBooking.next();
        for (int i = 0; i < listAirline.length; i++) {
            if (command.matches(listAirline[i].getTowDigitCode())) {
                return listAirline[i];
            }
        }
        return null;
    }

    // search for the flight object associated with the given flight number.
    private static Flight getFlight(Scanner readBooking, Flight[] listFlight) {
        command = readBooking.next();
        for (int i = 0; i < listFlight.length; i++) {
            if (command.matches(listFlight[i].getFlightNo())) {
                return listFlight[i];
            }
        }
        return null;
    }

    // search for the airport object associated with the given code.
    private static Airport getAirport(Scanner readBooking, Airport[] listAirport) {
        command = readBooking.next();
        for (int i = 0; i < listAirport.length; i++) {
            if (command.matches(listAirport[i].getThreeDigitCode())) {
                return listAirport[i];
            }
        }
        return null;
    }

    private static Date getDate(Scanner readBooking) {
        Date date = new Date();
        date.setYear(readBooking.nextInt());
        date.setMonth(readBooking.nextInt());
        date.setDate(readBooking.nextInt());
        return date;
    }

    private static Booking GenerateBooking(Scanner readBooking, Flight[] listFlights, Airline[] listAirline, Airport[] listAirport, Booking[] listBooking, PrintWriter writeBooking) {
        totalBokking++;
        listBooking[totalBokking] = new Booking(System.currentTimeMillis(), getFlight(readBooking, listFlights), getAirline(readBooking, listAirline), getAirport(readBooking, listAirport), getDate(readBooking), readBooking.next(), getDate(readBooking), readBooking.nextBoolean(), readBooking.nextInt());
        return listBooking[totalBokking];
    }
  

    public static void PrintBooking(Booking listBooking, PrintWriter writeBooking) {

        writeBooking.println("Booking No. " + listBooking.getBookingNo());
        // Print Passenger Details
        writeBooking.print("\nPassenger Details\t");
        writeBooking.print("Passenger Name: " + listBooking.getName() + "\t\t");
        writeBooking.println("Date of Birth: " + listBooking.getDob().getYear() + "-" + listBooking.getDob().getDate() + "-" + listBooking.getDob().getMonth());
        // Print Flight Details
        writeBooking.print("\nFlight Details\tFlight Code: " + listBooking.getAirline().getTowDigitCode() + "-" + listBooking.getFlight().getFlightNo() + "\t\t\t");
        writeBooking.println(listBooking.flightDate.getYear() + "-" + listBooking.flightDate.getDate() + "-" + listBooking.flightDate.getMonth());
        writeBooking.println("\t\tDeparture: " + listBooking.getFlight().getDeparture() + "\t\t\tDestination: " + listBooking.getFlight().getDestination());
        // Print Airport Details
        writeBooking.println("\nAirport Details\tAirport Name: " + listBooking.getAirport().getName() + "(" + listBooking.getAirport().getThreeDigitCode() + "), " + listBooking.getAirport().getCity());
        // Print Airline Details
        writeBooking.println("\nAirline Details\tName: " + listBooking.getAirline().getName() + " based in " + listBooking.getAirline().getWebsite());
        // Print Fare Details
        writeBooking.println("\nFare Details\tRegular Fare: SAR " + listBooking.getFlight().getFare());
        writeBooking.printf("\t\tTotal Fare: SAR " + (double) (Math.round(listBooking.CaalculateFare())));
        writeBooking.print("\n───────────────────────────────────────────────────────\n");

    }
}
