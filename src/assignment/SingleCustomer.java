package assignment;

import java.util.Date;
import java.time.LocalDate;

public class SingleCustomer {
    private String personNumber;
    private String firstName;
    private String lastName;
    private String fullName;
    private String memberMessage;
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
        // Kolla om nuvarande datum är FÖRE lastPayment + ett år. Sätt då till true, annars false.
        this.validMembership = LocalDate.now().isBefore(lastPayment.plusYears(1));
        this.setMemberMessage(validMembership);
    }

    // Setter
    public String setMemberMessage(boolean validMembership) {
        if(validMembership) {
            return this.memberMessage = "-medlem-";
        } else {
            return this.memberMessage = "-före detta medlem-";
        }
    }
    // Getters
    public String getFullName() {
        return this.fullName;
    }


    public String getPersonNumber() {
        return this.personNumber;
    }
//    public String getFirstName() {
//        return this.firstName;
//    }
//
//    public String getLastName() {
//        return this.lastName;
//    }

    // Override Objects toString metod.
    @Override
    public String toString() {
        return("Namn: " + this.fullName + "\n" +
                "Personnummer: " + this.personNumber + "\n" +
                "Personen är " + this.memberMessage + "\n" +
                "Senaste betalning: " + this.lastPayment + "\n");
    }
}
