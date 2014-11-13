package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.util.*;

// line 61 "gameplotconcrete.ump"
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
  private Shape shape;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Mission(Position aPosition, ReturnPoint aReturnPoint, Shape aShape)
  {
    super(aPosition);
    description = "";
    isDynamic = false;
    bindings = new ArrayList<Binding>();
    if (!setReturnPoint(aReturnPoint))
    {
      throw new RuntimeException("Unable to create Mission due to aReturnPoint");
    }
    if (!setShape(aShape))
    {
      throw new RuntimeException("Unable to create Mission due to aShape");
    }
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

  public Shape getShape()
  {
    return shape;
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

  public boolean setReturnPoint(ReturnPoint aNewReturnPoint)
  {
    boolean wasSet = false;
    if (aNewReturnPoint != null)
    {
      returnPoint = aNewReturnPoint;
      wasSet = true;
    }
    return wasSet;
  }

  public boolean setShape(Shape aNewShape)
  {
    boolean wasSet = false;
    if (aNewShape != null)
    {
      shape = aNewShape;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    bindings.clear();
    returnPoint = null;
    shape = null;
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "description" + ":" + getDescription()+ "," +
            "isDynamic" + ":" + getIsDynamic()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "returnPoint = "+(getReturnPoint()!=null?Integer.toHexString(System.identityHashCode(getReturnPoint())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "shape = "+(getShape()!=null?Integer.toHexString(System.identityHashCode(getShape())):"null")
     + outputString;
  }
}