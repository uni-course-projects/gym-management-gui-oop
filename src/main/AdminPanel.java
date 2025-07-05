/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
/**
 *
 * @author 2312241
 */
    
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.BadLocationException;


public class AdminPanel extends JFrame {

    private JTextPane usernamesTextPane;

    public AdminPanel() {
        
    }

  public void UsernameMembershipDisplay(String filename) throws BadLocationException {
        setTitle("Usernames and Memberships Display");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);

        usernamesTextPane = new JTextPane();
        usernamesTextPane.setEditable(false);
        usernamesTextPane.setFont(new Font("Arial", Font.PLAIN, 14));
        usernamesTextPane.setBackground(Color.BLACK);

        StyledDocument doc = usernamesTextPane.getStyledDocument();
        SimpleAttributeSet usernameAttributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(usernameAttributes, "Arial");
        StyleConstants.setFontSize(usernameAttributes, 16);
        StyleConstants.setForeground(usernameAttributes, Color.WHITE);

        SimpleAttributeSet membershipAttributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(membershipAttributes, "Arial");
        StyleConstants.setFontSize(membershipAttributes, 14);
        StyleConstants.setForeground(membershipAttributes, Color.RED);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    doc.insertString(doc.getLength(), line + "\n", usernameAttributes);
                } else if (line.startsWith("Membership: ")) {
                    doc.insertString(doc.getLength(), line + "\n\n\n", membershipAttributes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(usernamesTextPane);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    
    
   public void removeMember(String usernameToRemove, String filePath) {
        try {
            List<String> fileContent = Files.readAllLines(Paths.get(filePath));
            List<String> updatedContent = new ArrayList<>();

            boolean userFound = false;
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).equals("Username: " + usernameToRemove)) {
                    userFound = true;
                    // Skip the next 3 lines (Password, Membership, PaymentInfo)
                    i += 3;
                } else {
                    updatedContent.add(fileContent.get(i));
                }
            }

            if (userFound) {
                Files.write(Paths.get(filePath), updatedContent);
                 JOptionPane.showMessageDialog(null, "User " + usernameToRemove + " and all their related information has been removed from the database.");
            } else {
                JOptionPane.showMessageDialog(null, "User " + usernameToRemove + " was not found in the database.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error processing the file: " + e.getMessage());
        }
        }
   
   
   
   public boolean setMembershipStatus(String username, String password, String newMembershipStatus, String newPaymentInfo) {
    File inputFile = new File("members.txt");
    File tempFile = new File("members_temp.txt");

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
        
        String line;
        boolean found = false;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
            if (line.startsWith("Username: " + username.trim())) {
                found = true;
                while ((line = reader.readLine()) != null && !line.startsWith("Username: ")) {
                    writer.write(line);
                    writer.newLine();                        
                        writer.write("Membership: " + newMembershipStatus);
                        writer.newLine();
                        writer.write("Payment Info: " + newPaymentInfo);
                        writer.newLine();
                    
                }
                if (line != null) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
        
        if (!found) {
            JOptionPane.showMessageDialog(null, "Username and password combination not found.");
            return false;
        }
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
    
    if (!inputFile.delete()) {
        JOptionPane.showMessageDialog(null, "Could not delete original file.");
        return false;
    }

    if (!tempFile.renameTo(inputFile)) {
        JOptionPane.showMessageDialog(null, "Could not rename temporary file.");
        return false;
    }

    return true;
}
   
   private JTextPane BookingsDisplay;

    public void bookingsDisplay (String filename) throws BadLocationException {
        setTitle("Bookings Display");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);

        BookingsDisplay = new JTextPane();
        BookingsDisplay.setEditable(false);
        BookingsDisplay.setFont(new Font("Arial", Font.PLAIN, 14));
        BookingsDisplay.setBackground(Color.BLACK);

        StyledDocument doc = BookingsDisplay.getStyledDocument();
        SimpleAttributeSet usernameAttributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(usernameAttributes, "Arial");
        StyleConstants.setFontSize(usernameAttributes, 16);
        StyleConstants.setForeground(usernameAttributes, Color.WHITE);

        SimpleAttributeSet bookingAttributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(bookingAttributes, "Arial");
        StyleConstants.setFontSize(bookingAttributes, 16);
        StyleConstants.setForeground(bookingAttributes, Color.RED);
        
        SimpleAttributeSet trainerAttributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(trainerAttributes, "Arial");
        StyleConstants.setFontSize(trainerAttributes, 16);
        StyleConstants.setForeground(trainerAttributes, Color.WHITE);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Username: ")) {
                    doc.insertString(doc.getLength(), line + "\n", usernameAttributes);
                } else if (line.startsWith("Booking: ")) {
                    doc.insertString(doc.getLength(), line + "\n", bookingAttributes);
                } else if (line.startsWith("Trainer Name: ")) {
                    doc.insertString(doc.getLength(), line + "\n\n", trainerAttributes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(BookingsDisplay);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }
    
    
     private JTextPane FeedbackDisplay;

    public void feedbackDisplay(String filename) throws BadLocationException {
        setTitle("Feedback Display");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);

        FeedbackDisplay = new JTextPane();
        FeedbackDisplay.setEditable(false);
        FeedbackDisplay.setFont(new Font("Arial", Font.PLAIN, 14));
        FeedbackDisplay.setBackground(Color.BLACK);

        StyledDocument doc = FeedbackDisplay.getStyledDocument();
        SimpleAttributeSet nameAttributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(nameAttributes, "Arial");
        StyleConstants.setFontSize(nameAttributes, 16);
        StyleConstants.setForeground(nameAttributes, Color.WHITE);

        SimpleAttributeSet feedbackAttributes = new SimpleAttributeSet();
        StyleConstants.setFontFamily(feedbackAttributes, "Arial");
        StyleConstants.setFontSize(feedbackAttributes, 16);
        StyleConstants.setForeground(feedbackAttributes, Color.RED);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name: ")) {
                    doc.insertString(doc.getLength(), line + "\n", nameAttributes);
                } else if (line.startsWith("Feedback: ")) {
                    doc.insertString(doc.getLength(), line + "\n\n", feedbackAttributes);
                }
            }
        } catch (IOException | BadLocationException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(FeedbackDisplay);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }
    
    }

    


    

