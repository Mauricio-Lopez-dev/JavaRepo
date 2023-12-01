import java.util.*;

public class Date 
{
    // Data Fields
    private int month;
    private int day;
    private int year;
    private int febDays = 28;
    Scanner in = new Scanner(System.in);

    public Date() 
    {
        createDate();
    } // end default constructor

    public int getMonth() 
    {
        return month;
    } // end accessor method

    public void setMonth(int month) 
    {
        // Variables
        int maxMonths = 12;
        int minMonths = 1;

        // Validation
        while (month < minMonths || month > maxMonths) 
        {
            System.out.print("Invalid entry for the month. Enter a value between 01 - 12: ");
            month = in.nextInt();
        } // end while

        this.month = month;
    } // end mutator method

    public int getDay() 
    {
        return day;
    } // end accessor method

    public void setDay(int day) 
    {
        // Variables
        int maxDays = 31;
        int minDays = 1;

        // Validation
        while (day < minDays || day > maxDays) 
        {
            System.out.print("Invalid entry for the day. Enter a value between 01 - 31: ");
            day = in.nextInt();
        } // end while
        
        // Below loops until you enter the right date in each case 
        switch (month) 
        {
            case 2:
                // Validation - Leap Year
            	 if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) 
                 {
                     febDays = 29;
                 }

                 while (day < minDays || day > febDays) 
                 {
                     System.out.print("The month of February does not have " + day + " days. Enter a new day value: ");
                     day = in.nextInt();
                 } // end while
                 break;
          
            case 4:
                
                maxDays = 30;
                while (day < minDays || day > maxDays) 
                {
                    System.out.print("The month of April does not have " + day + " days. \nEnter a new day value: ");
                    day = in.nextInt();
                }
                break;

            case 6:
                maxDays = 30;
                while (day < minDays || day > maxDays) 
                {
                    System.out.print("The month of June does not have " + day + " days. \nEnter a new day value: ");
                    day = in.nextInt();
                }
                break;

            case 9:
                maxDays = 30;
                while (day < minDays || day > maxDays) 
                {
                    System.out.print("The month of September does not have " + day + " days. \nEnter a new day value: ");
                    day = in.nextInt();
                }
                break;

            case 11:
                maxDays = 30;
                while (day < minDays || day > maxDays) 
                {
                    System.out.print("The month of November does not have " + day + " days. Enter a new day value: ");
                    day = in.nextInt();
                }
                break;

                default: // exit out of the switch
        } // end switch
    } // end mutator method
       
    public int getYear()
    {
        return year;
    } // end accessor method
    
    public void setYear(int year) 
    {
        // Variables
        int currentYear = 2023; 
        int oldestYear = 1900; 

        // Validation
        while (year < oldestYear || year > currentYear)
        {
            System.out.print("Invalid entry. Enter a value of " + oldestYear + " - " + currentYear + " : ");
            year = in.nextInt();
        }
        this.year = year;
    } // end mutator method 
    
    @Override
    public String toString() 
    {
        String result = "DOB:     ";
        result += String.format("%02d", month) + "/";
        result += String.format("%02d", day) + "/";
        result += year;

        return result;
    } // end toString method

    public void createDate() 
    {
        // Variable
        boolean badInput = true;
        
        do
        {
            try
            {
                System.out.println("---------------------------------------------");
                System.out.println("Enter the date of birth starting with year, month, and day.");

                // Input - Year
                System.out.print("Enter the year: ");
                year = in.nextInt();
                setYear(year);

                // Input - Month
                System. out.print("Enter the month: ");
                month = in.nextInt();
                setMonth(month);

                // Input - Day
                System.out.print("Enter the day: ");
                day = in.nextInt(); 
                setDay(day);
                badInput = false;
            }
            catch(InputMismatchException mistake)
            {
                System.out.println("Invaild input. Value must be an integer");
                badInput = true;
            }
        }while(badInput);
    } // end createDate method
} // end Date class