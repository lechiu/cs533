package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.util.*;
import java.util.*;

// line 1 "gameplotconcrete.ump"
public class StartPoint extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StartPoint Associations
  private Condition precondition;
  private List<InBinding> inBindings;
  private Shape shape;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StartPoint(Position aPosition, Shape aShape)
  {
    super(aPosition);
    inBindings = new ArrayList<InBinding>();
    if (!setShape(aShape))
    {
      throw new RuntimeException("Unable to create StartPoint due to aShape");
    }
    System.out.println("StartPoint created");
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Condition getPrecondition()
  {
    return precondition;
  }

  public boolean hasPrecondition()
  {
    boolean has = precondition != null;
    return has;
  }

  public InBinding getInBinding(int index)
  {
    InBinding aInBinding = inBindings.get(index);
    return aInBinding;
  }

  public List<InBinding> getInBindings()
  {
    List<InBinding> newInBindings = Collections.unmodifiableList(inBindings);
    return newInBindings;
  }

  public int numberOfInBindings()
  {
    int number = inBindings.size();
    return number;
  }

  public boolean hasInBindings()
  {
    boolean has = inBindings.size() > 0;
    return has;
  }

  public int indexOfInBinding(InBinding aInBinding)
  {
    int index = inBindings.indexOf(aInBinding);
    return index;
  }

  public Shape getShape()
  {
    return shape;
  }

  public boolean setPrecondition(Condition aNewPrecondition)
  {
    boolean wasSet = false;
    precondition = aNewPrecondition;
    wasSet = true;
    return wasSet;
  }

  public static int minimumNumberOfInBindings()
  {
    return 0;
  }

  public InBinding addInBinding(Binding aBinding)
  {
    return new InBinding(this, aBinding);
  }

  public boolean addInBinding(InBinding aInBinding)
  {
    boolean wasAdded = false;
    if (inBindings.contains(aInBinding)) { return false; }
    StartPoint existingStartPoint = aInBinding.getStartPoint();
    boolean isNewStartPoint = existingStartPoint != null && !this.equals(existingStartPoint);
    if (isNewStartPoint)
    {
      aInBinding.setStartPoint(this);
    }
    else
    {
      inBindings.add(aInBinding);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeInBinding(InBinding aInBinding)
  {
    boolean wasRemoved = false;
    //Unable to remove aInBinding, as it must always have a startPoint
    if (!this.equals(aInBinding.getStartPoint()))
    {
      inBindings.remove(aInBinding);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addInBindingAt(InBinding aInBinding, int index)
  {  
    boolean wasAdded = false;
    if(addInBinding(aInBinding))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInBindings()) { index = numberOfInBindings() - 1; }
      inBindings.remove(aInBinding);
      inBindings.add(index, aInBinding);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveInBindingAt(InBinding aInBinding, int index)
  {
    boolean wasAdded = false;
    if(inBindings.contains(aInBinding))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfInBindings()) { index = numberOfInBindings() - 1; }
      inBindings.remove(aInBinding);
      inBindings.add(index, aInBinding);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addInBindingAt(aInBinding, index);
    }
    return wasAdded;
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
    precondition = null;
    for(int i=inBindings.size(); i > 0; i--)
    {
      InBinding aInBinding = inBindings.get(i - 1);
      aInBinding.delete();
    }
    shape = null;
    super.delete();
  }

}