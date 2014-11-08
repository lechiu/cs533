package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.util.*;

// line 62 "gameplotconcrete.ump"
public class Trigger extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Trigger Associations
  private Mission mission;
  private BlackTriangle blackTriangle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Trigger(Position aPosition, Mission aMission, BlackTriangle aBlackTriangle)
  {
    super(aPosition);
    if (aMission == null || aMission.getTrigger() != null)
    {
      throw new RuntimeException("Unable to create Trigger due to aMission");
    }
    mission = aMission;
    if (aBlackTriangle == null || aBlackTriangle.getTrigger() != null)
    {
      throw new RuntimeException("Unable to create Trigger due to aBlackTriangle");
    }
    blackTriangle = aBlackTriangle;
  }

  public Trigger(Position aPosition, Position aPositionForMission, String aDescriptionForMission, ReturnPoint aReturnPointForMission, Diamond aDiamondForMission, int aSizeForBlackTriangle)
  {
    super(aPosition);
    mission = new Mission(aPositionForMission, aDescriptionForMission, aReturnPointForMission, aDiamondForMission, this);
    blackTriangle = new BlackTriangle(aSizeForBlackTriangle, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Mission getMission()
  {
    return mission;
  }

  public BlackTriangle getBlackTriangle()
  {
    return blackTriangle;
  }

  public void delete()
  {
    Mission existingMission = mission;
    mission = null;
    if (existingMission != null)
    {
      existingMission.delete();
    }
    BlackTriangle existingBlackTriangle = blackTriangle;
    blackTriangle = null;
    if (existingBlackTriangle != null)
    {
      existingBlackTriangle.delete();
    }
    super.delete();
  }

}