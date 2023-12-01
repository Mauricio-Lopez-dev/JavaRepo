public abstract class Person 
{
    // Data Fields
    private Name name;
    private Date dob;
    
    // Abstract method
    public abstract void thisIsWhatIDo(); 
    
    public Person()
    {
        name = new Name();
        dob = new Date();
    } // end default constructor
      
    public Name getName()
    {
        return name;
    } // end accessor method
    
    public void setName(Name name)
    {
        this.name = name;
    } // end mutator method
    
    public Date getDate()
    {
        return dob;
    } // end accessor method
    
    public void setDate(Date dob)
    {
        this.dob = dob;
    } // end mutator method
    
    @Override
    public String toString()
    {
       System.out.println("---------------------------------------------");
       String result = "";
       result       += name.toString();    
       result       += dob.toString() + "\n"; 
     
       return result;
    } // end toString method
} // end Person class
