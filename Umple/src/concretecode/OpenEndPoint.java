package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 55 "gameplotconcrete.ump"
public class OpenEndPoint extends EndPoint
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OpenEndPoint Associations
  private WhiteCircle whiteCircle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OpenEndPoint(Position aPosition, Shape aShape, WhiteCircle aWhiteCircle)
  {
    super(aPosition, aShape);
    if (!setWhiteCircle(aWhiteCircle))
    {
      throw new RuntimeException("Unable to create OpenEndPoint due to aWhiteCircle");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public WhiteCircle getWhiteCircle()
  {
    return whiteCircle;
  }

  public boolean setWhiteCircle(WhiteCircle aNewWhiteCircle)
  {
    boolean wasSet = false;
    if (aNewWhiteCircle != null)
    {
      whiteCircle = aNewWhiteCircle;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    whiteCircle = null;
    super.delete();
  }

}