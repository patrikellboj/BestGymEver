package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Customers {

    // Instansvariabel
    private List<SingleCustomer> listOfCustomers = new ArrayList<>();

    // Klassens konstruktor
    public Customers() {
        Path pathToFile = Paths.get("C:\\Users\\patri\\Documents\\objOrienteradProg\\Assignments\\Assignment-02\\customers.txt");
        String personNumber;
        String firstName;
        String lastName;
        LocalDate lastPayment;

        // Try with resource
        try(Scanner scan = new Scanner(pathToFile)) {
            while(scan.hasNext()) {
                personNumber = scan.next().replace(",", "");
                firstName = scan.next();
                lastName = scan.next();
                lastPayment = LocalDate.parse(scan.next());
                listOfCustomers.add(new SingleCustomer(
                        personNumber,
                        firstName,
                        lastName,
                        lastPayment));
            }
//            System.out.println(listOfCustomers);
            //scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }

    }

    public SingleCustomer getCustomer(String input) {
        SingleCustomer customer = null;
        // Loopa igenom alla kunder i listOfCustomers
        for (SingleCustomer i : listOfCustomers) {
            // Kolla om något av kunderna har samma hela namn, förnamn, efternamn eller personnummer som input.
            if (input.equalsIgnoreCase(i.getFullName()) ||
                    input.equalsIgnoreCase(i.getFirstName()) ||
                    input.equalsIgnoreCase(i.getLastName()) ||
                    input.equalsIgnoreCase(i.getPersonNumber())) {
                // Returnera den kund som vars hela namn, förnamn, efternamn eller personnummer matchar med input.
                return i;
            }
        }
        // returnera null om kunden INTE hittades.
        return customer;
    }
}



























//                try (Scanner sc = new Scanner(path)) {
//                    while (sc.hasNext()) {
//                        personnr = sc.next().replace(",", "");
//                        förNamn = sc.next();
//                        efterNamn = sc.next();
//                        senasteVistelse = LocalDate.parse(sc.next());
//                        kunder.add(new Kund(personnr, förNamn, efterNamn, senasteVistelse));
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
