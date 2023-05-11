import java.awt.*;
import java.text.*;
public class TriangleCommand extends Command {
  private Triangle triangle;
  private int pointCount;
  public TriangleCommand() {
    this(null, null, null);
    pointCount = 0;
  }

  
 public TriangleCommand(Point point) {
    this(point, null, null);
    pointCount = 1;
  }
 public TriangleCommand(Point pointA, Point pointB, Point pointC) {
	    triangle = new Triangle(pointA, pointB, pointC);
	    pointCount = 3;
	  }
  

  
  public void setTrianglePoint(Point point) {
    if (++pointCount == 1) {
      triangle.setPointA(point);
    } 
    else if (pointCount == 2) {
        triangle.setPointB(point);
       }
    else if (pointCount == 3) {
     triangle.setPointC(point);
    }
  }
  public void execute() {
    model.addItem(triangle);
  }
  public boolean undo() {
    model.removeItem(triangle);
    return true;
  }
  public boolean redo() {
    execute();
    return true;
  }
  //might need to fix this
  public boolean end() {
    if (triangle.getPointA() == null) {
    	
      undo();
      return false;
    }
    if(triangle.getPointB() == null) {
    	triangle.setPointB(triangle.getPointB());
    	//undo();
    	return false;
    	
    }
    if (triangle.getPointC() == null) {
       triangle.setPointC(triangle.getPointC());
    }
    return true;
  }
}