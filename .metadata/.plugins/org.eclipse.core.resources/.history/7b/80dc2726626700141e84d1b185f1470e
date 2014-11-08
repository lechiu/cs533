package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 120 "gameplotconcrete.ump"
public class RoundRectShape
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RoundRectShape Attributes
  private int size;
  private String colour;

  //RoundRectShape Associations
  private Mission mission;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RoundRectShape(int aSize, Mission aMission)
  {
    size = aSize;
    colour = "black";
    if (aMission == null || aMission.getRoundRectShape() != null)
    {
      throw new RuntimeException("Unable to create RoundRectShape due to aMission");
    }
    mission = aMission;
  }

  public RoundRectShape(int aSize, Position aPositionForMission, String aDescriptionForMission, ReturnPoint aReturnPointForMission, Trigger aTriggerForMission)
  {
    size = aSize;
    colour = "black";
    mission = new Mission(aPositionForMission, aDescriptionForMission, aReturnPointForMission, this, aTriggerForMission);
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

  public Mission getMission()
  {
    return mission;
  }

  public void delete()
  {
    Mission existingMission = mission;
    mission = null;
    if (existingMission != null)
    {
      existingMission.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "size" + ":" + getSize()+ "," +
            "colour" + ":" + getColour()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mission = "+(getMission()!=null?Integer.toHexString(System.identityHashCode(getMission())):"null")
     + outputString;
  }
}