/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author ok
 */

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class setMembership extends AdminPanel {

    public static void setMembershipStatus(String username, String newMembershipStatus, String newPaymentInfo) {
        File inputFile = new File("members.txt");
        File tempFile = new File("members_temp.txt");
        boolean userFound = false;

        // Calculate the expiration date
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        Date expirationDate = cal.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
        String expirationDateString = dateFormat.format(expirationDate);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();

                if (line.trim().equals("Username: " + username)) {
                    userFound = true;
                    writer.write(reader.readLine());
                    writer.newLine();

                    // Skip old membership line
                    reader.readLine();
                    // Write new membership line with expiration date
                    writer.write("Membership: " + newMembershipStatus + " | Expiring on " + expirationDateString);
                    writer.newLine();

                    // Skip old payment info line
                    reader.readLine();
                    // Write new payment info line
                    writer.write("Payment Info: " + newPaymentInfo);
                    writer.newLine();

                    // Continue writing the rest of the file
                    while ((line = reader.readLine()) != null && !line.startsWith("Username:")) {
                        writer.write(line);
                        writer.newLine();
                    }

                    // If we find another username, write it and exit the inner loop
                    if (line != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }

            if (!userFound) {
                JOptionPane.showMessageDialog(null, "Username not found in the file.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while processing the file.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Replace original file with updated file
        if (userFound) {
            if (!inputFile.delete()) {
                JOptionPane.showMessageDialog(null, "Could not delete original file.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!tempFile.renameTo(inputFile)) {
                JOptionPane.showMessageDialog(null, "Could not rename temporary file.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Membership status and payment info updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if (!tempFile.delete()) {
                JOptionPane.showMessageDialog(null, "Could not delete temporary file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}


