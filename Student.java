import java.util.*;

public class Student extends Person implements StudentFavColor
{
   // Data Fields
   private String major;
   private double studentGPA;
   private boolean cheater;
   private int color;
   Scanner in = new Scanner(System.in);
  
    public Student() 
    {   
        super();
        makeAStudent();
        
    } // end default constructor
    
    public String getMajor()
    {
        return major;
    } // end accessor method
    
    public void setMajor(String major)
    {
        // Capitalization - First Letter
        String temp1 = Character.toString(major.toUpperCase().charAt(0));
        String temp2 = major.toLowerCase().substring(1);
        major = temp1 + temp2;
        
        this.major = major;
    } // end mutator method
    
    public double getStudentGPA()
    {
        return studentGPA;
    } // end accessor method
    
    public void setStudentGPA(double studentGPA)
    {   
        // Variables
        final double MIN = 0.0;
        final double MAX = 5.0;
        
        while(studentGPA < MIN || studentGPA > MAX)
        {
            System.out.println("You must enter a number between:");
            System.out.println(MIN + " and " + MAX);
            System.out.print("Enter GPA: ");
            studentGPA = in.nextDouble();
        }
        
        this.studentGPA = studentGPA;
    } // end mutator method
    
    public boolean getCheater()
    {
        return cheater;
    } // end accessor method
    
    public void setCheater(boolean cheater)
    {
        // Variables
        boolean validInput = false;
       
        while (!validInput)
            {
                System.out.print("Is the student a cheater? Enter 'true' or 'false': ");
                String userInput = in.next();

                if (userInput.equalsIgnoreCase("true")) 
                {
                    cheater = true;
                    validInput = true; 
                } 
                else if (userInput.equalsIgnoreCase("false")) 
                     {
                        cheater = false;
                        validInput = true;
                     } 
                else 
                {
                    System.out.println("Invalid input. Please enter 'true' or 'false'.");
                }
            } // end while
        this.cheater = cheater;
    } // end mutator method
            
    public int getColor()
    {
        return color;
    } // end accessor method
    
    public void setColor(int color)
    {
        this.color = color;
    } // end mutator method
    
    @Override
    public String toString() 
   {
       // Variables
       String[] colors = {"blue", "green", "red", "yellow", "white", "black", "pink", "purple"};
       String result = "";      
       boolean badIndex = true;
       int index = getColor();
       
       // Output
       System.out.println("---------------------------------------------");
       result = "\n" + "Student: ";
       result        += super.toString() + "\n";
        result        += "Major:     " + getMajor() + "\n";
       result        += "GPA:       " + getStudentGPA() + "\n";
       result        += "Cheater?   " + getCheater() + "\n";
       
       do
       {
           try
           {
            result += "This student's favorite color is " +  colors[index - 1] + "!\n";
            badIndex = false;
           }
           catch(ArrayIndexOutOfBoundsException e)
           {
               System.out.println("Invaild index. Try again");
               badIndex = true;
               in.nextLine();
           }
       }while(badIndex);
       
        // Validation
        if(getCheater())
        {
            result += "This student is a cheater?!?! Kick this student out of college!";
        }
        else
        {
            result += "Glad to know that this student is not a cheater! Bravo...";
        }
        return result;
   } // end toString method
    
    public void makeAStudent()
    {
        // Variable
        boolean badInput = true;
        
        do
        {
            try
            {
                // Input - Student Major
                System.out.print("Enter student's major: ");
                major = in.nextLine();
                setMajor(major);
                
                // Input - Student GPA
                System.out.print("Enter student's GPA: ");
                studentGPA = in.nextDouble();
                setStudentGPA(studentGPA); // Placed here for validation in setter
                
                // Input - Favorite Color
                setColor(Integer.parseInt(getFavColor()));
                
                // Input - Student Integrity
                setCheater(cheater);
                
                // Output
                System.out.println("***DATA STORED***\n");
                badInput = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invaild input. Try again");
                badInput = true;
                in.nextLine();
            }
        }while(badInput);
    } // end makeAStudent method
    
    @Override
    public boolean equals(Object obj) 
    {
        // Vaidation
        if (!(obj instanceof Student)) 
        {
            return false;
        }

        // Casting object
        Student aStudent = (Student) obj;

        // Validation
        if (this.studentGPA != aStudent.getStudentGPA()) 
        {
            return false;
        }
        return true;
    } // end equals method
 
    @Override
    public void thisIsWhatIDo()
    {
        System.out.println("I am a student who procrastinates and play video games");
    } // end thisIsWhatIDo method
    
    @Override
    public String getFavColor() 
    {
        // Variables
        boolean badInput = true;
        String result = "";
        int num = 0;
        
        do
        {
            try
            {
                System.out.print("Enter a number between 1 - 8 to discover your favorite color: ");
                num = in.nextInt();
                result = Integer.toString(num);
                badInput = false;
                
                if(num > 8)
                {
                    System.out.println("Invalid index.");
                    badInput = true;
                }
            }
            catch(Exception e)
            {
                System.out.println("Invaild value. Try again.");
                badInput = true;
                in.nextLine();
            }
        }while(badInput);
        
        return result;
    } // end dusplayFavColor method
} // end Student class 
