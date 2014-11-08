package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 125 "gameplotconcrete.ump"
public class BlackTriangle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BlackTriangle Attributes
  private int size;
  private String colour;

  //BlackTriangle Associations
  private Trigger trigger;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BlackTriangle(int aSize, Trigger aTrigger)
  {
    size = aSize;
    colour = "black";
    if (aTrigger == null || aTrigger.getBlackTriangle() != null)
    {
      throw new RuntimeException("Unable to create BlackTriangle due to aTrigger");
    }
    trigger = aTrigger;
  }

  public BlackTriangle(int aSize, Position aPositionForTrigger, Mission aMissionForTrigger)
  {
    size = aSize;
    colour = "black";
    trigger = new Trigger(aPositionForTrigger, aMissionForTrigger, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSize(int aSize)
  {
    boolean wasSet = false;
    size = aSize;
    wasSet = true;
    return wasSet;
  }

  public boolean setColour(String aColour)
  {
    boolean wasSet = false;
    colour = aColour;
    wasSet = true;
    return wasSet;
  }

  public int getSize()
  {
    return size;
  }

  public String getColour()
  {
    return colour;
  }

  public Trigger getTrigger()
  {
    return trigger;
  }

  public void delete()
  {
    Trigger existingTrigger = trigger;
    trigger = null;
    if (existingTrigger != null)
    {
      existingTrigger.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "size" + ":" + getSize()+ "," +
            "colour" + ":" + getColour()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "trigger = "+(getTrigger()!=null?Integer.toHexString(System.identityHashCode(getTrigger())):"null")
     + outputString;
  }
}