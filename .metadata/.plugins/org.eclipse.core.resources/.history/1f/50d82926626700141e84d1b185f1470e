package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.util.*;

// line 69 "gameplotconcrete.ump"
public class ChoicePoint extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ChoicePoint Associations
  private BlueCircle blueCircle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ChoicePoint(Position aPosition, BlueCircle aBlueCircle)
  {
    super(aPosition);
    if (!setBlueCircle(aBlueCircle))
    {
      throw new RuntimeException("Unable to create ChoicePoint due to aBlueCircle");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public BlueCircle getBlueCircle()
  {
    return blueCircle;
  }

  public boolean setBlueCircle(BlueCircle aNewBlueCircle)
  {
    boolean wasSet = false;
    if (aNewBlueCircle != null)
    {
      blueCircle = aNewBlueCircle;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    blueCircle = null;
    super.delete();
  }

}