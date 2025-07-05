/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author masho
 */
public class MemberPanel {
    
    public static void showBookingConfirmation(String username, String trainerName) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneWeekLater = now.plusDays(7);

        // Generate a random time within the next week
        long startEpoch = now.toEpochSecond(java.time.ZoneOffset.UTC);
        long endEpoch = oneWeekLater.toEpochSecond(java.time.ZoneOffset.UTC);
        long randomEpoch = ThreadLocalRandom.current().nextLong(startEpoch, endEpoch);
        LocalDateTime randomDateTime = LocalDateTime.ofEpochSecond(randomEpoch, 0, java.time.ZoneOffset.UTC);

        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy | HH:mm");
        String formattedDateTime = randomDateTime.format(formatter);

        // Show the booking confirmation
        String message = String.format("You have booked a session with %s at the following time: %s", trainerName, formattedDateTime);
        JOptionPane.showMessageDialog(null, message, "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);

        // Save the booking to file
        saveBooking(username, formattedDateTime, trainerName);
    }
    
     private static void saveBooking(String username, String booking, String trainerName) {
        File inputFile = new File("bookings.txt");
        File tempFile = new File("temp_bookings.txt");

        boolean found = false;

        try {
            // Ensure the file exists, create if not
            if (!inputFile.exists()) {
                inputFile.createNewFile();
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.equals("Username: " + username)) {
                        found = true;
                        writer.write("Username: " + username);
                        writer.newLine();
                        writer.write("Booking: " + booking);
                        writer.newLine();
                        writer.write("Trainer Name: " + trainerName);
                        writer.newLine();
                        // Skip the old booking line and trainer name line
                        reader.readLine(); // Skip the old booking line
                        reader.readLine(); // Skip the old trainer name line
                    } else {
                        writer.write(line);
                        writer.newLine();
                    }
                }

                if (!found) {
                    writer.write("Username: " + username);
                    writer.newLine();
                    writer.write("Booking: " + booking);
                    writer.newLine();
                    writer.write("Trainer Name: " + trainerName);
                    writer.newLine();
                    writer.newLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while saving the booking.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Delete the original file and rename the temporary file
            if (!inputFile.delete()) {
                JOptionPane.showMessageDialog(null, "Could not delete original bookings file.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!tempFile.renameTo(inputFile)) {
                JOptionPane.showMessageDialog(null, "Could not rename temporary bookings file.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Booking saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while saving the booking.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

 
    public static void displayMemberDetails(String username) throws BadLocationException {
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBackground(Color.BLACK);
        textPane.setForeground(Color.WHITE);
        textPane.setFont(new Font("Arial", Font.PLAIN, 12));

        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setForeground(attributes, Color.WHITE);
        StyleConstants.setFontFamily(attributes, "Arial");
        StyleConstants.setFontSize(attributes, 16);

        boolean memberFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: " + username)) {
                    memberFound = true;
                    doc.insertString(doc.getLength(), line + "\n", attributes);
                    for (int i = 0; i < 3; i++) {
                        if ((line = reader.readLine()) != null) {
                            doc.insertString(doc.getLength(), line + "\n", attributes);
                        }
                    }
                    break;
                }
            }
        } catch (IOException | BadLocationException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (memberFound) {
            JScrollPane scrollPane = new JScrollPane(textPane);
            scrollPane.setPreferredSize(new Dimension(900, 600));
            scrollPane.getViewport().setBackground(Color.BLACK);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBackground(Color.BLACK);
            panel.add(scrollPane, BorderLayout.CENTER);

            JOptionPane.showMessageDialog(null, panel, "Member Details", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Member not found", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
     
     public static void changePassword(String username, String oldPassword, String newPassword, String filePath) {
        File inputFile = new File(filePath);
        File tempFile = new File("tempFile.txt");
        boolean isPasswordChanged = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            String currentUser = "";
            String currentPassword = "";
            boolean usernameFound = false;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    currentUser = line.substring(10).trim();
                    usernameFound = currentUser.equals(username);
                }

                if (usernameFound && line.startsWith("Password: ")) {
                    currentPassword = line.substring(10).trim();
                    if (currentPassword.equals(oldPassword)) {
                         if (newPassword.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$")) {
                        line = "Password: " + newPassword;
                        isPasswordChanged = true; }
                         else {
                             JOptionPane.showMessageDialog(null, "Password must contain alphabets, numbers, and special characters. Registration failed.", "Error", JOptionPane.ERROR_MESSAGE);
                         }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Fill The Required Info OR Old password does not match.", "Error", JOptionPane.ERROR_MESSAGE);
                        writer.close();
                        tempFile.delete();
                        return;
                    }
                }

                writer.write(line);
                writer.newLine();

                if (line.startsWith("PaymentInfo: ")) {
                    usernameFound = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while processing the file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (isPasswordChanged) {
            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
                JOptionPane.showMessageDialog(null, "Password changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "An error occurred while updating the file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            tempFile.delete();
        }
    }
}
     
    

  

