package concretecode;

import java.awt.Color;
import java.awt.Graphics;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/



// line 42 "gameplotconcrete.ump"
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

  // line 46 "gameplotconcrete.ump"
  public void draw(Graphics g){
    g.setColor(Color.black);
		g.fillRect(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight());
		g.drawRect(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight());
  }

}