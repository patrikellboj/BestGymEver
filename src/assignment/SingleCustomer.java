package assignment;

import java.util.Date;
import java.time.LocalDate;

public class SingleCustomer {
    private String personNumber;
    private String firstName;
    private String lastName;
    private String fullName;
    private LocalDate lastPayment;
    private boolean validMembership = false;

    public SingleCustomer(String personNumber,
                          String firstName,
                          String lastName,
                          LocalDate lastPayment) {
        this.personNumber = personNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastPayment = lastPayment;
        this.fullName = firstName + " " + lastName;
    }

    // Getters
    public String getFullName() {
        return this.fullName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPersonNumber() {
        return this.personNumber;
    }


    public LocalDate getLastPayment() {
        return this.lastPayment;
    }
    
    public boolean getValidMembership() {
        LocalDate temp = lastPayment.plusYears(1);
        validMembership = LocalDate.now().isBefore(temp);
        return this.validMembership;
    }

    // TODO: 2019-10-16 Parsa datum snyggare till utskrift, viktigt! 
    // Override Objects toString metod.
    @Override
    public String toString() {
        return("fullName: " + this.fullName + "\n" +
                "firstName: " + this.firstName + "\n" +
                "lastName: " + this.lastName + "\n" +
                "personnummer: " + this.personNumber + "\n" +
                "lastPayment: " + this.lastPayment + "\n" +
                "validMembership: " + this.validMembership + "\n");

    }
}
