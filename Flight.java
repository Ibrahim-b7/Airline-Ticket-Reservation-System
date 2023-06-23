package Assignment_2;

/*
 * Name: Ibrahem Basher hamed ahmad.
 * Email: i.b7sher99@gmail.com
 * course number: CPCS_203.
 * section number: (12163)(EE). 
 * assignment title: Airline Ticket Reservation System.
 * date: Mar 24, 2021.
 */

public class Flight {

    private String flightNo;
    private String departure;
    private String destination;
    private double fare;

    public Flight(String flightNo, String departure, String destination, double fare) {
        this.flightNo = flightNo;
        this.departure = departure;
        this.destination = destination;
        this.fare = fare;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public String toString() {
        return "(New Flight Added)\tFlight No.: " + flightNo + "\tDeparture: " + departure + "\tDestination: : " + destination  + "\tFare: SAR " + fare
                + "\n------------------\n";
    }

}
