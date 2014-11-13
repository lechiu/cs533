/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 103 "gameplotconcrete.ump"
public class ParallelFork extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParallelFork Associations
  private BarOrthogonalLine barOrthogonalLine;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ParallelFork(int aStoryLineNodeid, Position aPosition, BarOrthogonalLine aBarOrthogonalLine)
  {
    super(aStoryLineNodeid, aPosition);
    if (!setBarOrthogonalLine(aBarOrthogonalLine))
    {
      throw new RuntimeException("Unable to create ParallelFork due to aBarOrthogonalLine");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public BarOrthogonalLine getBarOrthogonalLine()
  {
    return barOrthogonalLine;
  }

  public boolean setBarOrthogonalLine(BarOrthogonalLine aNewBarOrthogonalLine)
  {
    boolean wasSet = false;
    if (aNewBarOrthogonalLine != null)
    {
      barOrthogonalLine = aNewBarOrthogonalLine;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    barOrthogonalLine = null;
    super.delete();
  }

}