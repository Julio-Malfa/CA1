/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.io.BufferedReader;
import java.io.FileReader;
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
            
            while ((student = reader.readLine()) !=null) {
                String[] splitStr = student.split(" ");
                String firstName = splitStr[0];
                String secondName = splitStr[1];
                String numofClasses = reader.readLine();
                String studentNumber = reader.readLine();
                // Validating first name
                if (!firstName.matches("[a-zA-Z]+")){
                    System.out.println("Invalid first name: " + firstName);
                }
                // Validating second name
                if (!secondName.matches("[a-zA-Z0-9]+")) {
                    System.out.println("Invalid second name: " + secondName);
                }
                //lets test if the variables created will display
                System.out.println(firstName + " " + secondName + " " + numofClasses + " " + studentNumber);
            }
            reader.close();
        } catch (IOException e){
            System.out.println("Error reading the file: Student.txt");
        }
    }
    
}
