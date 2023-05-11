import java.awt.*;
import java.util.*;
public class RotateCommand extends Command {
  private Item item;
  private Point RotatePoint;
  public RotateCommand() {
  }
  public boolean setPoint(Point point) {
	boolean found = false;
    Enumeration enumeration = model.getItems();
    while (enumeration.hasMoreElements()) {
      item = (Item)(enumeration.nextElement());
      if (item.includes(point)) {
        model.markSelected(item);
		found = true;
		System.out.println("point here"+ point);
        break;
      }
    }
	return found;
  }
  
  public void rotate(Point point) {
	  
	  int X1 =0;
	  int X2 = 0;
	  int Y1 = 0;
	  int Y2 = 0;
	  int xr = 0;
	  int yr = 0;

      X1 = Math.round((float) (point.getX()));
      Y1 = Math.round((float) (point.getY()));
      X2 = Math.round((float) (point.getX()));
      Y2 = Math.round((float) (point.getY()));
	  X2= X2 +(Y2-Y1);
	  Y2 = Y2 + (X1-X2);
  }
  
  //public void render() {
	   // uiContext.drawLine(X1, X2);
	//  } 
  
  public boolean undo() {
    model.unSelect(item);
    return true;
  }
  public boolean  redo() {
    execute();
    return true;
  }
  public void execute() {
    model.markSelected(item);
  }
}
