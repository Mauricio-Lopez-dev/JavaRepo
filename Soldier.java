import java.util.Scanner;

public class Soldier extends Person implements SoldierRelaxing
{
    // Data Fields
    private String rank;
    private String branch; 
    private boolean officer;
    Scanner in = new Scanner(System.in);
	
    public Soldier() 
    {
        super();
	makeAnOfficer();
    } // end default constructor

    public String getRank() 
    {
	return rank;
    } // end accessor method

    public void setRank(String rank) 
    {
        // Conversion
        String temp1 = rank.toUpperCase();
        rank = temp1;
        
        
        
	this.rank = rank;
    } // end mutator method

    public String getBranch() 
    {
        return branch;
    } // end accessor method

    public void setBranch(String branch) 
    {
        // Conversion
        String temp1 = Character.toString(branch.toUpperCase().charAt(0));
        String temp2 = branch.toLowerCase().substring(1);
        branch = temp1 + temp2;
        
	this.branch = branch;
    } // end mutator method

    public boolean getIsOfficer()
    {		
	return officer;
    } // end accessor method

    public void setIsOfficer(boolean officer) 
    {			
	this.officer = officer;
    } // end mutator method
    
    @Override
    public String toString() 
    {
        String result = "\n" + "Soldier: ";
        result       += super.toString() + "\n";
        result       += "Rank: " + getRank() + "\n";
        result       += "Branch: " + getBranch() + "\n";
        result       += "Officer: " + getIsOfficer();
                
        return result;
    } // end toString method
    
    public void makeAnOfficer()
    {
        // Variables
        String[] rank = {"pri", "spc", "sgt", "ssg", "sfc", "ms", "sm", "csm", "sma"};
        String[] branch = {"Army", "Air Force", "Navy", "Marines", "Coast Guard"};
		
        System.out.println("Military ranks: ");
        for(int i = 0; i < rank.length; i++)
        {
            System.out.print(rank[i] + ", ");   
        }	
            System.out.print("\nWhat is the soldier's rank? ");
            String answer = in.nextLine();
		
        while (!answer.matches("[a-zA-Z]+")) 
        {
            System.out.println("Letters only, please.");
            System.out.print("What is the soldier's rank? ");
            answer = in.nextLine();
        }
        setRank(answer);
		
            System.out.println("Branches in the United States: ");
        for(int i = 0; i < branch.length; i++)
        {
            System.out.print(branch[i] + ", ");
        }
            System.out.print("\nWhat branch do they serve in? ");
            String inputBranch = in.nextLine();

        while (!inputBranch.matches("[a-zA-Z]+")) 
        {
            System.out.println("Letters only, please.");
            System.out.print("What branch do they serve in? ");
            inputBranch = in.nextLine();
        }	
	setBranch(inputBranch);      
            System.out.print("Are they an officer? (Enter 'true' or 'false'): ");
            String input = in.nextLine();
	    
        while (!input.matches("[a-zA-Z]+")) 
	{
            System.out.println("Letters only, please.");
            System.out.print("What is the officers rank?: ");
            input = in.nextLine();
        }
	    System.out.println("***DATA STORED***\n");
        boolean areTheyAnOfficer = Boolean.parseBoolean(input);
        setIsOfficer(areTheyAnOfficer);
    } // end makeAnOfficer method

    @Override
    public boolean equals(Object obj) 
    {
        if (!(obj instanceof Soldier)) 
        {
            return false;
        }

        Soldier aSoldier = (Soldier) obj;

        if (this.rank != aSoldier.getRank()) 
        {
            return false;
        }
        return true;
    } // end equals method
    
    @Override
    public void thisIsWhatIDo() 
    {		
	System.out.println("I Serve my people and my country! ");
        System.out.println(onVacation());
    } // end thisIsWhatIDo method
	
    @Override
    public String onVacation()
    {
        String result = "But I am on vacation!\n";
        
        return result;
    } // end onVacation method
}//class Soldier class