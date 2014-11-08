/* 
 *-------------------------------------------------------------- 80 columns ---|
 * The RectShape class defines a simple rectangular shape object. 
 * It tracks its bounding box, selected state, and the canvas it is being 
 * drawn in. It has some basic methods to select, move, and resize the 
 * rectangle. It has methods that draw the shape in the selected or unselected 
 * states and updates the canvas whenever the state or bounds of the rectangle 
 * change. The code that is there works properly, but you will need to extend 
 * and change the code to support additional features. 
 *
 * @version      1.0 10/13/99
 * @author       Julie Zelenski
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

// this import needed on mac os 9x
// import com.sun.java.util.collections.*;


public class DrawingCanvas extends JPanel
{
	/**
	 * Constructor for creating a new empty DrawingCanvas. We set up
	 * our size and background colors, instantiate an empty vector of shapes,
	 * and install a listener for mouse events using our inner class
	 * CanvasMouseHandler
	 */
	public DrawingCanvas(Toolbar tb, int width, int height)
	{
		setPreferredSize(new Dimension(width, height));
		setBackground(Color.white);
		toolbar = tb;
		allShapes = new ArrayList();
		selectedShape = null;
		CanvasMouseHandler handler = new CanvasMouseHandler();
		addMouseListener(handler);
		addMouseMotionListener(handler);
	}
	
	
	/**
	  * All components are responsible for drawing themselves in
	  * response to repaint() requests.  The standard method a component
	  * overrides is paint(Graphics g), but for Swing components, the default
	  * paint() handler calls paintBorder(), paintComponent() and paintChildren()
	  * For a Swing component, you override paintComponent and do your
	  * drawing in that method.  For the drawing canvas, we want to
	  * clear the background, then iterate through our shapes asking each
	  * to draw. The Graphics object is clipped to the region to update
	  * and we use to that avoid needlessly redrawing shapes outside the
	  * update region.
	  */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Rectangle clipRect = g.getClipBounds();
		
		Iterator iter = allShapes.iterator();
		while (iter.hasNext()) {
			((Rect)iter.next()).draw(g, clipRect);
		}
	}
			

	/**
	  * Changes the currently selected shape. There is at most
	  * one shape selected at a time on the canvas. It is possible
	  * for the selected shape to be null. Messages the shape to
	  * change its selected state which will in turn refresh the
	  * shape with the knobs active.
	  */
	protected void setSelectedShape(Rect shapeToSelect)
	{
		if (selectedShape != shapeToSelect) { // if change in selection
			if (selectedShape != null)  // deselect previous selection
		 		selectedShape.setSelected(false);
	 		selectedShape = shapeToSelect; // set selection to new shape
			if (selectedShape != null) {
				shapeToSelect.setSelected(true);
	 		}
		}
	}
	
	
	/**
	  * A hit-test routine which finds the topmost shape underneath a
	  * given point.We search Vector of shapes in back-to-front order
	  * since shapes created later are added to end and drawn last, thus 
	  * appearing to be "on top" of the earlier ones.  When a click comes 
	  * in, we want to select the top-most shape.
	  */
	protected Rect shapeContainingPoint(Point pt)
	{
		for (int i = allShapes.size()-1; i >= 0; i--)
		{
			Rect r = (Rect)allShapes.get(i);
			if (r.inside(pt)) return r;
		}
		return null;
	}
	

	/*
	 * The inner class CanvasMouseHandler is the object that handles the 
	 * mouse actions (press, drag, release) over the canvas. Since there is 
	 * a bit of state to drag during the various operations (which shape, 
	 * where we started from, etc.) it is convenient to encapsulate all that 
	 * state with this little convenience object and register it as the 
	 * handler for mouse events on the canvas.
	 */
	protected class CanvasMouseHandler extends MouseAdapter implements MouseMotionListener
	{
		Point dragAnchor;		// variables using to track state during drag operations
		int dragStatus;
		
		/** When the mouse is pressed we need to figure out what
		  * action to take.  If the tool mode is arrow, the click might
		  * be a select, move or reisze. If the tool mode is one of the
		  * shapes, the click initiates creation of a new shape.
		  */
		 public void mousePressed(MouseEvent event) 
		{
			Rect clicked = null;
			Point curPt = event.getPoint();
			
			if (toolbar.getCurrentTool() == Toolbar.SELECT) {
								// first, determine if click was on resize knob of selected shape
				if (selectedShape != null && (dragAnchor = selectedShape.getAnchorForResize(curPt)) != null) {
					dragStatus = DRAG_RESIZE;	// drag will resize this shape
				} else if ((clicked = shapeContainingPoint(curPt)) != null) { // if not, check if any shape was clicked
					setSelectedShape(clicked); 	
					dragStatus = DRAG_MOVE;		// drag will move this shape 
					dragAnchor = curPt;
				} else {	// else this was a click in empty area, deselect selected shape,
					setSelectedShape(null);
					dragStatus = DRAG_NONE;		// drag does nothing in this case
				}
			} else {
				Rect newShape = new Rect(curPt, DrawingCanvas.this);   // create rect here
	 			allShapes.add(newShape);
	 			setSelectedShape(newShape);
				dragStatus = DRAG_CREATE;		// drag will create (resize) this shape 
				dragAnchor = curPt;
			}
		}
		
		/** As the mouse is dragged, our listener will receive periodic
		  * updates as mouseDragged events. When we get an update position,
		  * we update the move/resize event that is in progress.
		  */
		public void mouseDragged(MouseEvent event) 
		{
			Point curPt = event.getPoint();

			switch (dragStatus) {
				case DRAG_MOVE:
					selectedShape.translate(curPt.x - dragAnchor.x, curPt.y - dragAnchor.y);
					dragAnchor = curPt; // update for next dragged event 
					break;
				case DRAG_CREATE: case DRAG_RESIZE:
					selectedShape.resize(dragAnchor, curPt);
					break;
			}
		}
		
		public void mouseMoved(MouseEvent e) {}
	
		static final int DRAG_NONE = 0, DRAG_CREATE = 1, DRAG_RESIZE = 2, DRAG_MOVE = 3;
	}


   /** A little helper routine that will be useful for the load & save
     * operations.  It brings up the standard JFileChooser dialog and
     * allows the user to specify a file to open or save. The return
     * value is the full path to the chosen file or null if no file was
     * selected.
     */
   	protected String filenameChosenByUser(boolean forOpen)
	{
   		JFileChooser fc = new JFileChooser(System.getProperty("user.dir") + java.io.File.separator + "Documents");
   		int result = (forOpen? (fc.showOpenDialog(this)) : fc.showSaveDialog(this));
   		java.io.File chosenFile = fc.getSelectedFile();
   		if (result == JFileChooser.APPROVE_OPTION && chosenFile != null)
			return chosenFile.getPath();
		return null; // return null if no file chosen or dialog cancelled
	}


	/* These are the unimplemented menu commands.  The menus are already
	 * set up to send the correct messages to the canvas, but the
	 * method bodies themselves are currently completely empty. It will
	 * be your job to fill them in!
	 */
	public void cut() {}
	public void copy() {}
	public void paste() {}
	public void delete() {}   
	public void clearAll() {}   
	public void loadFile() {}
	public void saveToFile() {}
	public void bringToFront() {}
	public void sendToBack() {}
   
   
	protected ArrayList allShapes;		// list of all shapes on canvas
	protected Rect selectedShape;	// currently selected shape (can be null at times)
	protected Toolbar toolbar;		// reference to toolbar to message for tool&color settings
}

