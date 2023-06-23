package Assignment_2;

/*
 * Name: Ibrahem Basher hamed ahmad.
 * Email: i.b7sher99@gmail.com
 * course number: CPCS_203.
 * section number: (12163)(EE). 
 * assignment title: Airline Ticket Reservation System.
 * date: Mar 24, 2021.
 */

public class Airport {

    private String threeDigitCode;
    private String city;
    private String name;

    public Airport(String threeDigitCode, String city, String name) {
        this.threeDigitCode = threeDigitCode;
        this.city = city;
        this.name = name;
    }

    public void setThreeDigitCode(String threeDigitCode) {
        this.threeDigitCode = threeDigitCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThreeDigitCode() {
        return threeDigitCode;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "(New Airport  Added)\tAirport Code: " + threeDigitCode + "\tCity: " + city + "\tName: " + name
                + "\n------------------\n";
    }

}
