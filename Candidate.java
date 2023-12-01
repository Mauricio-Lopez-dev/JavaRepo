import java.util.*;

public class Candidate extends Person implements DominateHand
{
    // Data Fields
    private String party;
    private String position;
    private String whichHand;
    Scanner input = new Scanner(System.in);
	
    public Candidate() 
    {
        super();
	setParty(party);
	setPosition(position);
        setWhichHand(whichHand);
    } // end default constructor
    
    
    public String getParty() 
    {
        return party;
    } // end accessor method

    public void setParty(String party) 
    {
        do 
        {
            System.out.print("Please enter candidates Party: ");
            party = input.nextLine();

            if (!party.matches("[a-zA-Z]+"))
            {
                System.out.println("Letters only, please.");
            }
        } while (!party.matches("[a-zA-Z]+"));
				
        this.party = party;
    } //end mutator method

    public String getPosition()
    {
	return position;
    } // end accessor method

    public void setPosition(String position) 
    {
       do 
       {
            System.out.print("Please enter the position in the Party: ");
            position = input.nextLine();

            if (!position.matches("[a-zA-Z]+")) 
            {
		System.out.println("Letters only, please.");
            }
       }while(!position.matches("[a-zA-Z]+"));
								
        this.position = position;
    } // end mutator method

    public String getWhichHand()
    {
        return whichHand;
    } // end accessor method
    
     @Override
    public String toString()
    {	
        System.out.println("---------------------------------------------");
        String result = "\n" + "Candidate: ";        
        result       += super.toString() + "\n";
        result       += "Party: " + party + "\n";
        result       += "Position: " + position + "\n";
        result       += "This candidate is " + whichHand + " handed!";
        
	return result;
    } // end toString method
    
    public void setWhichHand(String whichHand)
    {
        boolean badInput = true;
        
        do
        {
            int num = dominateHand();
            switch(num)
            {
                case 1: 
                    whichHand = "Left";
                    badInput = false;
                    break;

                case 2:
                    whichHand = "Right";
                    badInput = false;
                    break;

                case 3:
                    whichHand = "ambidextrous";
                    badInput = false;
                    break;

                default:
                    System.out.println("Invaild choice. Try again.");
                    badInput = true;
            }
        }while(badInput);
        
        System.out.println("***DATA STORED***\n");
        this.whichHand = whichHand;
    } // end mutator method
    
    @Override
    public boolean equals(Object obj) 
    {
        if (!(obj instanceof Candidate)) 
        {
            return false;
        }

        Candidate aCandidate = (Candidate) obj;

        if (this.party != aCandidate.getParty()) 
        {
            return false;
        }
        return true;
    } // end equals method
    
    @Override
    public int dominateHand()
    {
        // Variables
        int num = 0;
        boolean badInput = true;
        
        do
        {
            try
            {
                System.out.println("Is the candidate left[1], right[2], or ambidextrous[3]?");
                num = input.nextInt();
                badInput = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invaild value. Try again.");
                badInput = true;
                input.nextLine();
            }
        }while(badInput); 
        return num;
    } // end dominateHand method
	
    @Override
    public void thisIsWhatIDo() 
    {
	System.out.println("I Promise things I can't promise!");
	System.out.println(" ");
    } // end thisIsWhatIDo method
}//end class