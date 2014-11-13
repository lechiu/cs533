/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

// line 209 "gameplotconcrete.ump"
public class SolidLine extends Shape
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SolidLine(int aLeft, int aTop, int aWidth, int aHeight)
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

  // line 217 "gameplotconcrete.ump"
  public void draw(Graphics g){
    Graphics2D g2 = (Graphics2D) g.create();
      	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      	g2.setColor(super.getColor());
      	g2.setStroke(new BasicStroke(8));
      	g2.fillRect(2,2,2,2);
	  	g2.drawLine(this.getLeft(),this.getTop(),this.getWidth(),this.getHeight());
  }


  /**
   * Check whether (x,y) is inside the first point of line.
   */
  // line 227 "gameplotconcrete.ump"
  public boolean containsPoint(int x, int y){
    //	  	int x1 = this.getLeft();
		int y1 = this.getTop();
		int x2 = this.getWidth();
		int y2 = this.getHeight();
		
		double ydiff = (y2 - y1);
		double xdiff = (x2 - x1);
		if (xdiff == 0) {
			xdiff = +1;
		}
		double slope = (ydiff / xdiff);
		double b = y2 - slope * x2;

		int ymax = (int) (slope * x + b) + 5;
		int ymin = (int) (slope * x + b) - 5;

		if ((x <= Math.max(x1, x2)) && (x >= Math.min(x1, x2)) && (y <= ymax)
				&& (y >= ymin))
			return true;
		else
			return false;
  }

}