package Assignment_2;

/*
 * Name: Ibrahem Basher hamed ahmad.
 * Email: i.b7sher99@gmail.com
 * course number: CPCS_203.
 * section number: (12163)(EE). 
 * assignment title: Airline Ticket Reservation System.
 * date: Mar 24, 2021.
 */

import Assignment_2.Airport;
import Assignment_2.Airline;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Booking {

    private long bookingNo;
    private Flight flight;
    private Airline airline;
    private Airport airport;
    Date flightDate;
    private String name;
    private Date dob;
    Boolean isBusinessClass;
    private int baggageWeight;

    public Booking(long bookingNo, Flight flight, Airline airline, Airport airport, Date flightDate, String name, Date dob, Boolean isBusinessClass, int baggageWeight) {
        this.bookingNo = bookingNo;
        this.flight = flight;
        this.airline = airline;
        this.airport = airport;
        this.flightDate = flightDate;
        this.name = name;
        this.dob = dob;
        this.isBusinessClass = isBusinessClass;
        this.baggageWeight = baggageWeight;
    }

    public void setBookingNo(long bookingNo) {
        this.bookingNo = bookingNo;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setIsBusinessClass(Boolean isBusinessClass) {
        this.isBusinessClass = isBusinessClass;
    }

    public void setBaggageWeight(int baggageWeight) {
        this.baggageWeight = baggageWeight;
    }

    public long getBookingNo() {
        return bookingNo;
    }

    public Flight getFlight() {
        return flight;
    }

    public Airline getAirline() {
        return airline;
    }

    public Airport getAirport() {
        return airport;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public Boolean getIsBusinessClass() {
        return isBusinessClass;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    public double CaalculateFare() {

        double TotalFare = flight.getFare();

        // calculate Cabin Class
        if (this.isBusinessClass == true) {
            TotalFare = TotalFare * 1.4;
        }
        // calculate Age.
        LocalDate today = LocalDate.now();
        LocalDate birthDate = LocalDate.of(getDob().getYear(), getDob().getMonth() + 1, getDob().getDate());
        int year = Period.between(birthDate, today).getYears();

        if (year <= 2) {
            TotalFare *= 0.1;
        } else if (year <= 12) {
            TotalFare *= 0.7;
        }
        // calculate Baggage Allowance.
        if (this.isBusinessClass == true && this.baggageWeight > 50) {
            TotalFare += (this.baggageWeight - 50) * 30;
        } else if (this.isBusinessClass == false && this.baggageWeight > 30) {
            TotalFare += (this.baggageWeight - 30) * 30;
        }

        return TotalFare;
    }
}
