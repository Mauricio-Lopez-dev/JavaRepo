import java.util.*;

public class Name 
{
    // Data fields
    private String firstName;
    private char middleInitial;
    private String lastName;
    Scanner in = new Scanner(System.in);
    
    public Name()
    {
       createName();
    } // end default constructor
    
    public String getFirstName() 
    {
        return firstName;
    } // end accessor method

    public void setFirstName(String firstName) 
    {
        // Conversion - First name
        String temp1 = Character.toString(firstName.toUpperCase().charAt(0));
        String temp2 = firstName.toLowerCase().substring(1);
        firstName = temp1 + temp2;
      
        this.firstName = firstName;
        
    } // end mutator method

    public char getMiddleInitial() 
    {
        return middleInitial;
    } // end accessor method

    public void setMiddleInitial(char middleInitial) 
    {
        // Conversion - Middle initial
        middleInitial = Character.toUpperCase(middleInitial);
        
        this.middleInitial = middleInitial;
    } // end mutator method
    
    public String getLastName() 
    {
        return lastName;
    } // end accessor method

    public void setLastName(String lastName) 
    {
        // Conversion - last name 
        String temp1 = Character.toString(lastName.toUpperCase().charAt(0));
        String temp2 = lastName.toLowerCase().substring(1);
        lastName = temp1 + temp2;
        
        this.lastName = lastName;
    } // end mutator method
   
    @Override
    public String toString() 
    {
        String result = " ";
        
        // Validation
       if (middleInitial != ' ')
       {
           result = firstName + " " + middleInitial + ". " + lastName + "\n";
       }
       else
       {
           result = firstName + " " + lastName + "\n";
       }
      
        return result;
    } // end toString method
    
    public void createName()
    {
        // Variables 
        boolean badInput = true;
        
        do
        {
           try 
           { 
                // Input
                System.out.print("\nPlease enter the first name: ");
                firstName = in.nextLine();
                while(!firstName.matches("[a-zA-Z]+"))
                {
                    System.out.println("Letters only, please.");
                    System.out.print("\nPlease enter the first name: ");
                    firstName = in.nextLine();
                }

                System.out.print("Please enter the middle intial or enter space if no middle initial: ");
                String temp = in.nextLine();
                while(!temp.matches("[a-zA-Z]+"))
                {
                    System.out.println("It must be a letter.");
                    System.out.print("Please enter the middle intial or enter space if no middle initial: ");
                    temp = in.nextLine();
                }
                
                // Validation
                if(temp == " ")
                {
                    middleInitial = ' ';
                }
                else
                {
                    middleInitial = temp.charAt(0);
                }

                System.out.print("Please enter the last name: ");
                lastName = in.nextLine();
                while(!lastName.matches("[a-zA-Z]+"))
                {
                    System.out.println("Letters only, please.");
                    System.out.print("\nPlease enter the first name: ");
                    lastName = in.nextLine();
                }

                // Mutators
                setFirstName(firstName);
                setMiddleInitial(middleInitial);
                setLastName(lastName);
                
                badInput = false;
           }
           catch(InputMismatchException mistake)
           {
               System.out.println("Invalid entry. It must contain only letters.");
               badInput = true;
           }
        }while(badInput);
    } // end getAName method
} // end Name class