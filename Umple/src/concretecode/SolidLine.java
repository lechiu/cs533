package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

// line 224 "gameplotconcrete.ump"
public class SolidLine extends Shape
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SolidLine Attributes
  private Color aColor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SolidLine(int aLeft, int aTop, int aWidth, int aHeight)
  {
    super(aLeft, aTop, aWidth, aHeight);
    aColor = Color.black;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAColor(Color aAColor)
  {
    boolean wasSet = false;
    aColor = aAColor;
    wasSet = true;
    return wasSet;
  }

  public Color getAColor()
  {
    return aColor;
  }

  public void delete()
  {
    super.delete();
  }

  // line 233 "gameplotconcrete.ump"
  public void draw(Graphics g){
    Graphics2D g2 = (Graphics2D) g.create();
      	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      	g2.setColor(Color.BLACK);
      	g2.setStroke(new BasicStroke(8));
      	g2.fillRect(2,2,2,2);
	  	g2.drawLine(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight());
  }


  /**
   * Check whether (x,y) is inside the first point of line.
   */
  // line 243 "gameplotconcrete.ump"
  @Override
  public boolean containsPoint(int x, int y){
    //	  	if (x >= this.getLeft() && x < this.getLeft() + 10 && y >= this.getTop() && y < this.getTop() + 10)
		if ((x >= this.getLeft() - 10 && x <= this.getLeft() + 10 && y >= this.getTop() - 10 && y <= this.getTop() + 10) || (x >= this.getWidth() - 10 && x <= this.getWidth() + 10 && y >= this.getHeight() - 10 && y <= this.getHeight() + 10))
			return true;
		else
			return false;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "aColor" + "=" + (getAColor() != null ? !getAColor().equals(this)  ? getAColor().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}