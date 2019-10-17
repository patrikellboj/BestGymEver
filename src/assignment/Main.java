package assignment;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SingleCustomer customer;
        // Skapa en lista med alla kunder från textfilen med kunder
        Customers customers = new Customers();

        while (true) {
            try {
                String input = JOptionPane.showInputDialog(
                        null,
                        "Mata in namn eller personnummer för att se om personen är medlem",
                        "Best Gym Ever!!",
                        JOptionPane.QUESTION_MESSAGE);

                if (input == null) {
                    break;
                }
                input = input.replaceAll("\\s+", " ").trim();
                // Kolla om kunden finns i systemet.
                customer = customers.getCustomer(input);

                if(customer == null) {
                    JOptionPane.showMessageDialog(null, "Kunden " + input + " fanns inte i systemet och är därmed obehörig.");
                } else {
                    customer.isMember();
                }
            } catch (NullPointerException e) {
                System.out.println("NullPointerException");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Exception");
                e.printStackTrace();
            }
        }
    }
}


