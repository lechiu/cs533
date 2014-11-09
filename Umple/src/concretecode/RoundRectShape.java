package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.awt.Color;
import java.awt.Graphics;

// line 201 "gameplotconcrete.ump"
public class RoundRectShape extends Shape
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RoundRectShape(int aLeft, int aTop, int aWidth, int aHeight)
  {
    super(aLeft, aTop, aWidth, aHeight);
    System.out.println("Round Rect shape created");
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

  // line 207 "gameplotconcrete.ump"
  public void draw(Graphics g){
    g.setColor(Color.black);
		g.fillRoundRect(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight(),this.getWidth()/3,this.getHeight()/3);
		g.drawRoundRect(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight(),this.getWidth()/3,this.getHeight()/3);
		g.drawString("M", this.getLeft(), this.getTop());
  }

}