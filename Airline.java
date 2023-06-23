
/*
 * Name: Ibrahem Basher hamed ahmad.
 * Email: i.b7sher99@gmail.com
 * course number: CPCS_203.
 * section number: (12163)(EE). 
 * assignment title: Airline Ticket Reservation System.
 * date: Mar 24, 2021.
 */
package Assignment_2;

public class Airline {

    private String towDigitCode;
    private String name;
    private String originCountry;
    private String website;

    public Airline(String towDigitCode, String name, String originCountry, String website) {
        this.towDigitCode = towDigitCode;
        this.name = name;
        this.originCountry = originCountry;
        this.website = website;
    }

    public void setTowDigitCode(String towDigitCode) {
        this.towDigitCode = towDigitCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTowDigitCode() {
        return towDigitCode;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "(New Airline Added)\tAirline No.: " + towDigitCode + " Airline: " + name + " Hub: " + originCountry + " URL: " + website
                + "\n------------------\n";
    }

}
