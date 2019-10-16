package assignment;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SingleCustomer customer;

        // Skapa en lista med alla kunder från textfilen med kunder
        Customers customers = new Customers();

        // TODO: 2019-10-16 Lägg input i en while loop. Om du får något av felen så ska programmet på nytt
        //  be användaren att skriva in något.
        try {
            String input = JOptionPane.showInputDialog("Mata in namn eller personnummer för att se om personen är medlem");
            customer = customers.getCustomer(input);
            System.out.println(customer.toString());
        }
        catch (NullPointerException e) {
            System.out.println("NullPointerException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }








    }
}
