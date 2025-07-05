/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author masho
 */
public class AccountSystem {

    public AccountSystem() 
    {
        
    }
    
     public boolean PasswordMatch(char[] password1, char[] password2)            
    {
       if (password1.length != password2.length)
       {
            return false;
       }
       
       for (int i = 0; i < password1.length; i++) 
        {
            if (password1[i] != password2[i])
                return false;  
        }
        
        return true;
    }
     
   public boolean checkCredentials(String username, char[] password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("members.txt"))) {
            String line; // is empty
            while ((line = reader.readLine()) != null) { // if not empty
                if (line.startsWith("Username: " + username.trim())) { // Remove whitespace
                    line = reader.readLine(); // Read next line which contains password
                    if (line != null && line.startsWith("Password: ")) {
                        String storedPassword = line.substring("Password: ".length()).trim(); // Remove whitespace
                        if (storedPassword.equals(new String(password))) {
                            // Check for membership status
                            line = reader.readLine(); // Read next line which should contain membership status
                            if (line != null && line.startsWith("Membership: ")) {
                                String membershipStatus = line.substring("Membership: ".length()).trim(); // Remove whitespace
                                if (!membershipStatus.isEmpty()) {
                                    return true; // Username, password, and membership status match
                                } else {
                                    // No membership status
                                    JOptionPane.showMessageDialog(null, "You do not have a membership status. Please apply for membership.");
                                    return false;
                                }
                            } else {
                                // No membership status line
                                JOptionPane.showMessageDialog(null, "You do not have a membership status. Please apply for membership.");
                                return false;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Username or password does not match, or membership status is missing
    }
   
    public boolean saveCredentials(String username, char[] password) {
        File file = new File("members.txt");

        // Check if the file already exists
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                return false;
            }
        }

        // Check if the username already exists
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("Username: ") && line.substring(10).equals(username)) {
                    JOptionPane.showMessageDialog(null, "Username already exists. Registration failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return false;
        }

        // Check if the password contains alphabets, numbers, and special characters
        String passwordStr = new String(password);
        if (!passwordStr.matches("^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$")) {
            JOptionPane.showMessageDialog(null, "Password must contain alphabets, numbers, and special characters. Registration failed.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Append the new account information to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println("Username: " + username);
            writer.println("Password: " + passwordStr);
            writer.println();

            System.out.println("Account registered successfully.");
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            return false;
        }
    }  
    
     private static final String FILE_NAME = "members.txt";

    public static void addMembership(String username, String membershipType) {
        File file = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        // Check if the file already exists
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check if the membership type is valid
        if (!isValidMembership(membershipType)) {
            JOptionPane.showMessageDialog(null, "Invalid membership type.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Scanner scanner = new Scanner(file);
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            boolean usernameFound = false;

            // Iterate through each line in the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // If the line contains the username, add membership status with expiry date
                if (line.startsWith("Username: " + username.trim())) {
                    writer.println(line);
                    line = scanner.nextLine(); // Read the next line which is "Password: "
                    writer.println(line);
                    writer.println("Membership: " + membershipType.trim() + " | Expiring on " + getExpiryDate());
                    usernameFound = true;
                } else {
                    writer.println(line);
                }
            }

            if (!usernameFound) {
                JOptionPane.showMessageDialog(null, "Username not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Rename the temp file to the original file
        try {
            Files.move(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error renaming file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Membership added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void addPaymentInfo(String username, String paymentInfo) {
        File file = new File("members.txt");
        File tempFile = new File("temp.txt");

        // Check if the file already exists
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Scanner scanner = new Scanner(file);
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

            boolean usernameFound = false;

            // Iterate through each line in the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // If the line contains the username, add payment info
                if (line.startsWith("Username: " + username.trim())) {
                    writer.println(line);
                    line = scanner.nextLine(); // Read the next line which is "Password: "
                    writer.println(line);
                    line = scanner.nextLine(); // Read the next line which is "Membership: "
                    writer.println("Payment Info: " + paymentInfo); // Add payment info
                    writer.println(line);
                    usernameFound = true;
                } else {
                    writer.println(line);
                }
            }

            if (!usernameFound) {
                JOptionPane.showMessageDialog(null, "Username not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Rename the temp file to the original file
        try {
            Files.move(tempFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error renaming file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Payment information added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static String getExpiryDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1); // Add 1 month to the current date
        Date expiryDate = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        return sdf.format(expiryDate);
    }

    // Method to check if the membership type is valid
    private static boolean isValidMembership(String membershipType) 
    {
    return "Basic".equals(membershipType) || "Premium".equals(membershipType);
    }
    
     public static void findPassword(String username, String paymentInfo) {
        try (BufferedReader br = new BufferedReader(new FileReader("members.txt"))) {
            String line;
            String foundUsername = null;
            String foundPassword = null;
            String foundPaymentInfo = null;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    foundUsername = line.substring(10).trim();
                } else if (line.startsWith("Password: ")) {
                    foundPassword = line.substring(10).trim();
                } else if (line.startsWith("Payment Info: ")) {
                    foundPaymentInfo = line.substring(14).trim();
                    
                    // Now we have the complete set of info for one user
                    if (foundUsername != null && foundPassword != null && foundPaymentInfo != null) {
                        if (foundUsername.equals(username) && foundPaymentInfo.equals(paymentInfo)) {
                            JOptionPane.showMessageDialog(null, "Your password is: " + foundPassword, "Password Found", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        
                        // Reset for next user in file
                        foundUsername = null;
                        foundPassword = null;
                        foundPaymentInfo = null;
                    }
                }
            }

            // If we finish the loop without finding the username and payment info
            JOptionPane.showMessageDialog(null, "Username or Payment Info not found.", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
     }
}
    

