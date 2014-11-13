/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 23 "gameplotconcrete.ump"
public class Binding
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static int nextBindingId = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private int bindingId;

  //Binding Associations
  private List<InBinding> inBindings;
  private List<OutBinding> outBindings;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Binding()
  {
    bindingId = nextBindingId++;
    inBindings = new ArrayList<InBinding>();
    outBindings = new ArrayList<OutBinding>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public int getBindingId()
  {
    return bindingId;
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

  public static int minimumNumberOfInBindings()
  {
    return 0;
  }

  public InBinding addInBinding(StartPoint aStartPoint)
  {
    return new InBinding(aStartPoint, this);
  }

  public boolean addInBinding(InBinding aInBinding)
  {
    boolean wasAdded = false;
    if (inBindings.contains(aInBinding)) { return false; }
    Binding existingBinding = aInBinding.getBinding();
    boolean isNewBinding = existingBinding != null && !this.equals(existingBinding);
    if (isNewBinding)
    {
      aInBinding.setBinding(this);
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
    //Unable to remove aInBinding, as it must always have a binding
    if (!this.equals(aInBinding.getBinding()))
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

  public static int minimumNumberOfOutBindings()
  {
    return 0;
  }

  public OutBinding addOutBinding(EndPoint aEndpoint)
  {
    return new OutBinding(this, aEndpoint);
  }

  public boolean addOutBinding(OutBinding aOutBinding)
  {
    boolean wasAdded = false;
    if (outBindings.contains(aOutBinding)) { return false; }
    Binding existingBinding = aOutBinding.getBinding();
    boolean isNewBinding = existingBinding != null && !this.equals(existingBinding);
    if (isNewBinding)
    {
      aOutBinding.setBinding(this);
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
    //Unable to remove aOutBinding, as it must always have a binding
    if (!this.equals(aOutBinding.getBinding()))
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

  public void delete()
  {
    for(int i=inBindings.size(); i > 0; i--)
    {
      InBinding aInBinding = inBindings.get(i - 1);
      aInBinding.delete();
    }
    for(int i=outBindings.size(); i > 0; i--)
    {
      OutBinding aOutBinding = outBindings.get(i - 1);
      aOutBinding.delete();
    }
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "bindingId" + ":" + getBindingId()+ "]"
     + outputString;
  }
}