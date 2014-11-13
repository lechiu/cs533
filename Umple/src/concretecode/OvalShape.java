package concretecode;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.20.2.4305 modeling language!*/


import java.awt.Color;
import java.awt.Graphics;

// line 129 "gameplotconcrete.ump"
public class OvalShape extends Shape
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public OvalShape(int aLeft, int aTop, int aWidth, int aHeight)
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

  // line 135 "gameplotconcrete.ump"
//David Eck, http://math.hws.edu/eck/cs124/javanotes3/source/ShapeDraw.java, Accessed: 8, November, 2014
  public void draw(Graphics g){
    g.setColor(super.getColor());
		g.fillOval(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight());
		g.drawOval(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight());
  }

  // line 141 "gameplotconcrete.ump"
//Check whether (x,y) is inside this oval
//David Eck, http://math.hws.edu/eck/cs124/javanotes3/source/ShapeDraw.java, Accessed: 8, November, 2014
  public boolean containsPoint(int x, int y){
	double rx = this.getWidth()/2.0;   // horizontal radius of ellipse
	double ry = this.getHeight()/2.0;  // vertical radius of ellipse 
	double cx = this.getLeft() + rx;   // x-coord of center of ellipse
	double cy = this.getTop() + ry;    // y-coord of center of ellipse
	if ( (ry*(x-cx))*(ry*(x-cx)) + (rx*(y-cy))*(rx*(y-cy)) <= rx*rx*ry*ry )
		return true;
	else
		return false;
  }

}