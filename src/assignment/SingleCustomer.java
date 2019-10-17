package assignment;

import javax.swing.*;
import java.io.*;
import java.nio.channels.ScatteringByteChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        // Kolla om nuvarande datum är FÖRE lastPayment + ett år. Sätt då till true, annars false.
        this.validMembership = LocalDate.now().isBefore(lastPayment.plusYears(1));
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

    public void isMember() {
        if(this.validMembership) {
             int confirmOption = JOptionPane.showConfirmDialog(
                     null,
                     "Personen är medlem. Välkommen!\n" +
                             "Namn: " + this.fullName + "\n" +
                             "Personnummer: " + this.personNumber + "\n" +
                             "Senaste betalning: " + this.lastPayment + "\n" +
                             "Ska personen träna? \n",
                     "Medlem",
                     JOptionPane.YES_NO_OPTION);
             if(confirmOption == 0) {
                 File visitorFile = new File("C:\\Users\\patri\\Documents\\objOrienteradProg\\Assignments\\Assignment-02\\visitorFile.txt");
                 try(PrintWriter file = new PrintWriter(
                         new BufferedWriter(
                                 new FileWriter(visitorFile, true)))) {
                         file.print(textToFile());
                         JOptionPane.showMessageDialog(null, this.fullName + " lades till.");
                 } catch (IOException e) {
                     System.out.println("Input output exception. Problem att skriva till fil");
                     e.printStackTrace();
                 } catch (Exception e) {
                     System.out.println("Exception");
                     e.printStackTrace();
                 }
             }
        } else {
            JOptionPane.showConfirmDialog(
                    null,
                    "Personen är före detta medlem och måste betala årsavgift.\n" +
                            "Namn: " + this.fullName + "\n" +
                            "Personnummer: " + this.personNumber + "\n" +
                            "Senaste betalning: " + this.lastPayment + "\n",
                    "Före detta medlem",
                    JOptionPane.DEFAULT_OPTION);
        }
    }

    public String textToFile() {
        return ("Namn: " + this.fullName + "\n" +
                "Personnummer: " + this.personNumber + "\n" +
                "Senaste betalning: " + this.lastPayment + "\n" +
                "Tränade senast: " + LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm")) + "\n\n");
    }
}
