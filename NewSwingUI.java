import java.awt.Graphics;
import java.awt.*;
public class NewSwingUI implements UIContext {
  private Graphics graphics;
  private static NewSwingUI swingUI;
  private NewSwingUI() {
  }
  public static NewSwingUI getInstance() {
    if (swingUI == null) {
      swingUI = new NewSwingUI();
    }
    return swingUI;
  }
  public  void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }
  public void drawLabel(Label label) {
    if (label.getStartingPoint() != null) {
      if (label.getText() != null) {
        graphics.drawString(label.getText(), (int) label.getStartingPoint().getX(), (int) label.getStartingPoint().getY());
      }
    }
    int length = graphics.getFontMetrics().stringWidth(label.getText());
    graphics.drawString("_", (int) label.getStartingPoint().getX() + length, (int) label.getStartingPoint().getY());
  }
  public void drawLine(Point point1,  Point point2) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (point1 != null) {
      i1 = Math.round((float) (point1.getX()));
      i2 = Math.round((float) (point1.getY()));
      if (point2 != null) {
        i3 = Math.round((float) (point2.getX()));
        i4 = Math.round((float) (point2.getY()));
      } else {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    	}
  }
    
    
    public void drawTriangle(Point pointA,  Point pointB, Point pointC) {
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;

        if (pointA != null) {
          i1 = Math.round((float) (pointA.getX()));
          i2 = Math.round((float) (pointA.getY()));


          if (pointB != null) {
            i3 = Math.round((float) (pointB.getX()));
            i4 = Math.round((float) (pointB.getY()));
            graphics.drawLine(i1, i2, i3, i4);

            i1 = i3;
            i2 = i4;
            if  (pointC != null) {
              i3 = Math.round((float) (pointC.getX()));
              i4 = Math.round((float) (pointC.getY()));
              graphics.drawLine(i1, i2, i3, i4);

            i1 = i3;
            i2 = i4;
          }
        }
        }
        i3 = i1;
        i4 = i2;
        graphics.drawLine(i1, i2, Math.round((float) (pointA.getX())),Math.round((float) (pointA.getY())));

        	}

}
 
