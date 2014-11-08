package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.util.*;

// line 47 "gameplotconcrete.ump"
public class Mission extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Mission Attributes
  private String description;
  private boolean isDynamic;

  //Mission Associations
  private List<Binding> bindings;
  private ReturnPoint returnPoint;
  private RoundRectShape roundRectShape;
  private Trigger trigger;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Mission(Position aPosition, String aDescription, ReturnPoint aReturnPoint, RoundRectShape aRoundRectShape, Trigger aTrigger)
  {
    super(aPosition);
    description = aDescription;
    isDynamic = false;
    bindings = new ArrayList<Binding>();
    if (aReturnPoint == null || aReturnPoint.getMission() != null)
    {
      throw new RuntimeException("Unable to create Mission due to aReturnPoint");
    }
    returnPoint = aReturnPoint;
    if (aRoundRectShape == null || aRoundRectShape.getMission() != null)
    {
      throw new RuntimeException("Unable to create Mission due to aRoundRectShape");
    }
    roundRectShape = aRoundRectShape;
    if (aTrigger == null || aTrigger.getMission() != null)
    {
      throw new RuntimeException("Unable to create Mission due to aTrigger");
    }
    trigger = aTrigger;
  }

  public Mission(Position aPosition, String aDescription, Position aPositionForReturnPoint, int aSizeForRoundRectShape, Position aPositionForTrigger, BlackTriangle aBlackTriangleForTrigger)
  {
    super(aPosition);
    description = aDescription;
    isDynamic = false;
    bindings = new ArrayList<Binding>();
    returnPoint = new ReturnPoint(aPositionForReturnPoint, this);
    roundRectShape = new RoundRectShape(aSizeForRoundRectShape, this);
    trigger = new Trigger(aPositionForTrigger, this, aBlackTriangleForTrigger);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsDynamic(boolean aIsDynamic)
  {
    boolean wasSet = false;
    isDynamic = aIsDynamic;
    wasSet = true;
    return wasSet;
  }

  public String getDescription()
  {
    return description;
  }

  public boolean getIsDynamic()
  {
    return isDynamic;
  }

  public boolean isIsDynamic()
  {
    return isDynamic;
  }

  public Binding getBinding(int index)
  {
    Binding aBinding = bindings.get(index);
    return aBinding;
  }

  public List<Binding> getBindings()
  {
    List<Binding> newBindings = Collections.unmodifiableList(bindings);
    return newBindings;
  }

  public int numberOfBindings()
  {
    int number = bindings.size();
    return number;
  }

  public boolean hasBindings()
  {
    boolean has = bindings.size() > 0;
    return has;
  }

  public int indexOfBinding(Binding aBinding)
  {
    int index = bindings.indexOf(aBinding);
    return index;
  }

  public ReturnPoint getReturnPoint()
  {
    return returnPoint;
  }

  public RoundRectShape getRoundRectShape()
  {
    return roundRectShape;
  }

  public Trigger getTrigger()
  {
    return trigger;
  }

  public static int minimumNumberOfBindings()
  {
    return 0;
  }

  public boolean addBinding(Binding aBinding)
  {
    boolean wasAdded = false;
    if (bindings.contains(aBinding)) { return false; }
    bindings.add(aBinding);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBinding(Binding aBinding)
  {
    boolean wasRemoved = false;
    if (bindings.contains(aBinding))
    {
      bindings.remove(aBinding);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addBindingAt(Binding aBinding, int index)
  {  
    boolean wasAdded = false;
    if(addBinding(aBinding))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBindings()) { index = numberOfBindings() - 1; }
      bindings.remove(aBinding);
      bindings.add(index, aBinding);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBindingAt(Binding aBinding, int index)
  {
    boolean wasAdded = false;
    if(bindings.contains(aBinding))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBindings()) { index = numberOfBindings() - 1; }
      bindings.remove(aBinding);
      bindings.add(index, aBinding);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBindingAt(aBinding, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    bindings.clear();
    ReturnPoint existingReturnPoint = returnPoint;
    returnPoint = null;
    if (existingReturnPoint != null)
    {
      existingReturnPoint.delete();
    }
    RoundRectShape existingRoundRectShape = roundRectShape;
    roundRectShape = null;
    if (existingRoundRectShape != null)
    {
      existingRoundRectShape.delete();
    }
    Trigger existingTrigger = trigger;
    trigger = null;
    if (existingTrigger != null)
    {
      existingTrigger.delete();
    }
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "," +
            "isDynamic" + ":" + getIsDynamic()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "returnPoint = "+(getReturnPoint()!=null?Integer.toHexString(System.identityHashCode(getReturnPoint())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "roundRectShape = "+(getRoundRectShape()!=null?Integer.toHexString(System.identityHashCode(getRoundRectShape())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "trigger = "+(getTrigger()!=null?Integer.toHexString(System.identityHashCode(getTrigger())):"null")
     + outputString;
  }
}