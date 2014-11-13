package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.awt.Color;
import java.awt.Graphics;

// line 43 "gameplotconcrete.ump"
public class RectShape extends Shape
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RectShape(int aLeft, int aTop, int aWidth, int aHeight)
  {
    super(aLeft, aTop, aWidth, aHeight);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

  // line 49 "gameplotconcrete.ump"
  public void draw(Graphics g){
    g.setColor(super.getColor());
		g.fillRect(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight());
		g.drawRect(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight());
  }

}