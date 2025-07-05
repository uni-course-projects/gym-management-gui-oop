/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ok
 */

public class FeedbackForm {


    public static void saveFeedback(String name, String feedback) {
        String feedbackStore = "Name: " + name + "\n" +
                          "Feedback: " + feedback + "\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt", true))) {
            writer.write(feedbackStore);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Feedback submitted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred while saving the feedback.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void addReportStatus(String name, String report) {
    File inputFile = new File("feedback.txt");
    File tempFile = new File("temp_feedback.txt");

    if (!inputFile.exists()) {
        JOptionPane.showMessageDialog(null, "Feedback file does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

        String line;
        boolean found = false;

        while ((line = reader.readLine()) != null) {
            if (line.equals("Name: " + name)) {
                String feedbackLine = reader.readLine();
                if (feedbackLine != null && feedbackLine.startsWith("Feedback: ")) {
                    writer.write(line);
                    writer.newLine();
                    writer.write(feedbackLine);
                    writer.newLine();
                    writer.write("Report Status: " + report);
                    writer.newLine();
                    writer.newLine();
                    found = true;
                    reader.readLine(); // Skip the old report status
                } else {
                    writer.write(line);
                    writer.newLine();
                }
            } else {
                writer.write(line);
                writer.newLine();
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Feedback from the specified name not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while adding the report status.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        if (!inputFile.delete()) {
            JOptionPane.showMessageDialog(null, "Could not delete original feedback file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            JOptionPane.showMessageDialog(null, "Could not rename temporary feedback file.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Report status added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SecurityException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred while renaming the temporary file.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    
}


 



