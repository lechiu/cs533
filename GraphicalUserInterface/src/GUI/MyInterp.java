package GUI;    
	import java.awt.*;  
    import java.awt.event.*;  
    import java.awt.geom.*;  
    import java.util.*;  
    import java.util.List;  
    import javax.swing.*;  
    import javax.swing.event.MouseInputAdapter;  
       
    // Turn off generics warnings given by compiler for  
    // not using generic type parameters in Collections.  
    @SuppressWarnings("unchecked")  // j2se 1.5+  
       
    public class MyInterp extends JPanel{  
        ArrayList paths = new ArrayList();  
        PathWrangler2 wrangler = new PathWrangler2(this);  
        // Used to move all paths uniformly.  
        private AffineTransform at = new AffineTransform();  
       
        public MyInterp() {  
            paths.add(wrap(new Line2D.Double(50, 50, 200, 100)));  
            paths.add(wrap(new Ellipse2D.Double(100, 150, 50, 50)));  
            paths.add(wrap(new Rectangle2D.Double(150, 250, 75, 50)));  
        }  
       
        private Path2D.Double wrap(Shape s) {  
            return new Path2D.Double(s);  
        }  
       
        protected void paintComponent(Graphics g) {  
            super.paintComponent(g);  
            Graphics2D g2 = (Graphics2D)g;  
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  
                                RenderingHints.VALUE_ANTIALIAS_ON);  
            g2.setPaint(Color.blue);  
            for(int j = 0; j < paths.size(); j++) {  
                Path2D.Double path = (Path2D.Double)paths.get(j);  
                // Since you want to move all paths uniformly we  
                // can use a transform to keep track of them.  
                Shape s = at.createTransformedShape(path);  
                g2.draw(s);  
            }  
        }  
       
        public void transformPath(Path2D.Double path, AffineTransform at) {  
            path.transform(at);  
            repaint();  
        }  
       
        public void movePrimitives(int x, int y) {  
            at.translate(x, y);  
            repaint();  
        }  
       
        public AffineTransform getTransform() {  
            // Send a defensive copy.  
            return new AffineTransform(at);  
        }  
       
        public static void main(String[] args) {  
            JFrame f = new JFrame();  
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    //        f.add(new SDRx());  
            f.add(new MyInterp());  
            f.setSize(400,400);  
            f.setLocation(100,100);  
            f.setVisible(true);  
        }  
    }  
       
    class PathWrangler2 extends MouseInputAdapter {  
        MyInterp component;  
        // Used to move individual paths.  
        AffineTransform at = new AffineTransform();  
        final int S = 6;  
        Rectangle2D.Double net = new Rectangle2D.Double(0, 0, S, S);  
        Path2D.Double selectedPath;  
        Point offset = new Point();  
        boolean dragging = false;  
        boolean draggingScreen = false;  
       
        public PathWrangler2(MyInterp sdr) {  
            component = sdr;  
            component.addMouseListener(this);  
            component.addMouseMotionListener(this);  
        }  
       
        public void mousePressed(MouseEvent e) {  
            Point p = e.getPoint();  
            List list = component.paths;  
            Point2D xp = getXformedPoint(p);  
            net.setFrame(xp.getX()-S/2, xp.getY()-S/2, S, S);  
            for(int j = 0; j < list.size(); j++) {  
                Path2D.Double path = (Path2D.Double)list.get(j);  
                if(path.contains(xp) || path.intersects(net)) {  
                    selectedPath = path;  
                    Rectangle r = selectedPath.getBounds();  
                    offset.x = p.x - r.x;  
                    offset.y = p.y - r.y;  
                    dragging = true;  
                    break;  
                }  
            }  
            if(!dragging) {  
                offset.setLocation(p);  
                draggingScreen = true;  
            }  
        }  
       
        public Point2D getXformedPoint(Point p) {  
            // Transform a point in the component coordinate system  
            // to a point in the transformed path coordinate system  
            // so mousePressed points can find the transformed shapes  
            // drawn to the screen in component view.  
            AffineTransform xform = component.getTransform();  
            double determinant = xform.getDeterminant();  
            if(determinant != 0) {            // okay to invert  
                AffineTransform inv = null;  
                try {  
                    inv = xform.createInverse();  
                } catch(NoninvertibleTransformException e) {  
                    System.out.println("can't invert: " + e.getMessage());  
                    return null;  
                }  
                return inv.transform(p, null);  
            }  
            return null;  
        }  
       
        public void mouseReleased(MouseEvent e) {  
            dragging = false;  
            draggingScreen = false;  
        }  
       
        public void mouseDragged(MouseEvent e) {  
         if(draggingScreen) {  
                 Point p = e.getPoint();  
                 int x = p.x - offset.x;  
                 int y = p.y - offset.y;  
                 component.movePrimitives(x, y);  
                 offset.setLocation(p);  
            } else if(dragging) {  
                int x = e.getX() - offset.x;  
                int y = e.getY() - offset.y;  
                Rectangle r = selectedPath.getBounds();  
                at.setToTranslation(x-r.x, y-r.y);  
                component.transformPath(selectedPath, at);  
            }  
        }  
    }  