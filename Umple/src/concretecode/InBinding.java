package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 18 "gameplotconcrete.ump"
public class InBinding
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //InBinding Associations
  private StartPoint startPoint;
  private Binding binding;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public InBinding(StartPoint aStartPoint, Binding aBinding)
  {
    boolean didAddStartPoint = setStartPoint(aStartPoint);
    if (!didAddStartPoint)
    {
      throw new RuntimeException("Unable to create inBinding due to startPoint");
    }
    boolean didAddBinding = setBinding(aBinding);
    if (!didAddBinding)
    {
      throw new RuntimeException("Unable to create inBinding due to binding");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public StartPoint getStartPoint()
  {
    return startPoint;
  }

  public Binding getBinding()
  {
    return binding;
  }

  public boolean setStartPoint(StartPoint aStartPoint)
  {
    boolean wasSet = false;
    if (aStartPoint == null)
    {
      return wasSet;
    }

    StartPoint existingStartPoint = startPoint;
    startPoint = aStartPoint;
    if (existingStartPoint != null && !existingStartPoint.equals(aStartPoint))
    {
      existingStartPoint.removeInBinding(this);
    }
    startPoint.addInBinding(this);
    wasSet = true;
    return wasSet;
  }

  public boolean setBinding(Binding aBinding)
  {
    boolean wasSet = false;
    if (aBinding == null)
    {
      return wasSet;
    }

    Binding existingBinding = binding;
    binding = aBinding;
    if (existingBinding != null && !existingBinding.equals(aBinding))
    {
      existingBinding.removeInBinding(this);
    }
    binding.addInBinding(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    StartPoint placeholderStartPoint = startPoint;
    this.startPoint = null;
    placeholderStartPoint.removeInBinding(this);
    Binding placeholderBinding = binding;
    this.binding = null;
    placeholderBinding.removeInBinding(this);
  }

}