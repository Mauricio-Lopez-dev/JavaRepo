/*
 * Authors: Mauricio Lopez
 * Date written:December 1, 2023
 */

import java.util.*;
import java.util.ArrayList;
 
public class TestPersonClass 
{
    // Global Variable
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        // Variables
        int choice = 0;
        ArrayList<Person> people = new ArrayList<>();
        
       do
        {
            choice = getChoice();
            switch (choice) 
            {
                case 1: // Create student
                    people.add(new Student());
                    break;

                case 2: // Create candidate
                    people.add(new Candidate());
                    break;

                case 3: // Create soldier
                    people.add(new Soldier());
                    break;

                case 4: // Displays ArrayList of people
                        displayAllPeople(people); 
                    break;

                case 5: // End program
                    System.out.println("Thanks for using our program, Goodbye!");
                    break;

                default: // Error message
                     System.out.println("Invalid selection, try again...");
            } // end switch
        }while (choice != 5); // end while
    }// end main
    
    public static int getChoice() 
    {
        String menu = "";
       
        // Output menu list
        menu += "******* MENU *******\n";
        menu += "[1] Add new Student\n";
        menu += "[2] Add new Candidate\n";
        menu += "[3] Add new Soldier\n";
        menu += "[4] Display all People\n";
        menu += "[5] Quit\n";
        
        return getInput(menu);
    } // end getChoice method
    
    public static int getInput(String message)
    {
        // Variable
        int choice = 0;
        
        boolean badInput = true;
        do
        {
            try
            {
                // Input
                System.out.print(message + "\nEnter here: ");
                choice = in.nextInt();
                badInput = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input. Try again.\n");
                badInput = true;
                in.nextLine();
            }
        }while(badInput);
            
        return choice;
    } // end getInput method
    
    public static void displayMessage(String message)
    {
        System.out.println(message);
    } // end displayMessage method
    
    public static void displayAllPeople(ArrayList<Person> people) 
    {
        for(Person thisPerson : people) 
        {
            displayMessage(thisPerson.toString());
            thisPerson.thisIsWhatIDo();
        } // end for
    } // end displayAllPeople method
} // end TestPersonClass 