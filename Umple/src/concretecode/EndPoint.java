package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.util.*;

// line 35 "gameplotconcrete.ump"
public class EndPoint extends StoryLineNode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EndPoint Associations
  private List<OutBinding> outBindings;
  private Condition postcondition;
  private Shape shape;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EndPoint(Position aPosition, Shape aShape)
  {
    super(aPosition);
    outBindings = new ArrayList<OutBinding>();
    if (!setShape(aShape))
    {
      throw new RuntimeException("Unable to create EndPoint due to aShape");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public OutBinding getOutBinding(int index)
  {
    OutBinding aOutBinding = outBindings.get(index);
    return aOutBinding;
  }

  public List<OutBinding> getOutBindings()
  {
    List<OutBinding> newOutBindings = Collections.unmodifiableList(outBindings);
    return newOutBindings;
  }

  public int numberOfOutBindings()
  {
    int number = outBindings.size();
    return number;
  }

  public boolean hasOutBindings()
  {
    boolean has = outBindings.size() > 0;
    return has;
  }

  public int indexOfOutBinding(OutBinding aOutBinding)
  {
    int index = outBindings.indexOf(aOutBinding);
    return index;
  }

  public Condition getPostcondition()
  {
    return postcondition;
  }

  public boolean hasPostcondition()
  {
    boolean has = postcondition != null;
    return has;
  }

  public Shape getShape()
  {
    return shape;
  }

  public static int minimumNumberOfOutBindings()
  {
    return 0;
  }

  public OutBinding addOutBinding(Binding aBinding)
  {
    return new OutBinding(aBinding, this);
  }

  public boolean addOutBinding(OutBinding aOutBinding)
  {
    boolean wasAdded = false;
    if (outBindings.contains(aOutBinding)) { return false; }
    if (outBindings.contains(aOutBinding)) { return false; }
    EndPoint existingEndpoint = aOutBinding.getEndpoint();
    boolean isNewEndpoint = existingEndpoint != null && !this.equals(existingEndpoint);
    if (isNewEndpoint)
    {
      aOutBinding.setEndpoint(this);
    }
    else
    {
      outBindings.add(aOutBinding);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOutBinding(OutBinding aOutBinding)
  {
    boolean wasRemoved = false;
    //Unable to remove aOutBinding, as it must always have a Endpoint
    if (!this.equals(aOutBinding.getEndpoint()))
    {
      outBindings.remove(aOutBinding);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOutBindingAt(OutBinding aOutBinding, int index)
  {  
    boolean wasAdded = false;
    if(addOutBinding(aOutBinding))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOutBindings()) { index = numberOfOutBindings() - 1; }
      outBindings.remove(aOutBinding);
      outBindings.add(index, aOutBinding);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOutBindingAt(OutBinding aOutBinding, int index)
  {
    boolean wasAdded = false;
    if(outBindings.contains(aOutBinding))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOutBindings()) { index = numberOfOutBindings() - 1; }
      outBindings.remove(aOutBinding);
      outBindings.add(index, aOutBinding);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOutBindingAt(aOutBinding, index);
    }
    return wasAdded;
  }

  public boolean setPostcondition(Condition aNewPostcondition)
  {
    boolean wasSet = false;
    postcondition = aNewPostcondition;
    wasSet = true;
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
    for(int i=outBindings.size(); i > 0; i--)
    {
      OutBinding aOutBinding = outBindings.get(i - 1);
      aOutBinding.delete();
    }
    postcondition = null;
    shape = null;
    super.delete();
  }

}