/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author julio.malfa
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Fist commit just to test Git account.
        //Read from students.txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String student;
            //Reading and defining student's information
            while ((student = reader.readLine()) !=null) {
                String[] splitStr = student.split(" ");
                String firstName = splitStr[0];
                String secondName = splitStr[1];
                String numofClasses = reader.readLine();
                String studentNumber = reader.readLine();
                
                //Writing validated student in status.txt (place holder)
                if (ValidStudent(firstName, secondName, numofClasses, studentNumber)){
                BufferedWriter bw = new BufferedWriter(new FileWriter("status.txt", true));
                bw.write(studentNumber + " - " + secondName + "\n" + numofClasses + "\n");
                bw.close();                
                }
                
            }         
        
            reader.close();
        } catch (IOException e){
            System.out.println("Error reading the file: Student.txt");
        }
    }
// Validating Student information (First Name, Second Name, Num of Classes and Student Number)
    private static boolean ValidStudent(String firstName, String secondName, String numofClasses, String studentNumber){
        //Validating first name with letters only
        if(!firstName.matches("[a-zA-Z]+")){
            System.out.println("Invalid first name: " + firstName);
            return false;
        }
        
        //Validating second name with letters and or numbers
        if (!secondName.matches("[a-zA-Z0-9]+")) {
            System.out.println("Invalid second name: " + secondName);
            return false;
        }
        
        //Validating number of classes between 1 to 8 (1 and 8 included)
        try {
            int numofClassesInt = Integer.parseInt(numofClasses);
            if (numofClassesInt < 1 || numofClassesInt > 8) {
                System.out.println("Invalid number of classes: " + numofClasses);
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of classes: " + numofClasses);
            return false;
        }
        
        //Validating student number (placeholder)
        if (studentNumber.matches("\\d{2}[a-aA-Z]{2}\\d+")) {
            System.out.println("Invalid student number: " + studentNumber);
            return false;
        }
        
        return true;
    }
}
