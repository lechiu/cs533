package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.util.*;

// line 103 "gameplotconcrete.ump"
public class ParallelFork extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ParallelFork Associations
  private BarOrthonanolLine barOrthonanolLine;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ParallelFork(Position aPosition, BarOrthonanolLine aBarOrthonanolLine)
  {
    super(aPosition);
    if (!setBarOrthonanolLine(aBarOrthonanolLine))
    {
      throw new RuntimeException("Unable to create ParallelFork due to aBarOrthonanolLine");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public BarOrthonanolLine getBarOrthonanolLine()
  {
    return barOrthonanolLine;
  }

  public boolean setBarOrthonanolLine(BarOrthonanolLine aNewBarOrthonanolLine)
  {
    boolean wasSet = false;
    if (aNewBarOrthonanolLine != null)
    {
      barOrthonanolLine = aNewBarOrthonanolLine;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    barOrthonanolLine = null;
    super.delete();
  }

}