import java.awt.Point;
public class Triangle extends Item {

  private Point pointA;
  private Point pointB;
  private Point pointC;
  public Triangle(Point pointA, Point pointB, Point pointC) {
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
  }
 // public Triangle(Point pointA, Point pointB, Point pointC) {
  //  this.pointA = pointA;
   // pointB = null;
   // pointC = null;
 // }
  public Triangle() {
	  pointA = null;
	  pointB = null;
	  pointC = null;
  }
  public boolean includes(Point point) {
    return ((distance(point, pointA ) < 10.0) || (distance(point, pointB)< 10.0) || distance(point, pointC) < 10.0);
  }
  public void render() {

    uiContext.drawTriangle(pointA, pointB, pointC);
  }
  public void setPointA(Point point) {
    pointA = point;
  }
  public void setPointB(Point point) {
    pointB = point;
  }
  public void setPointC(Point point) {
	   pointC = point;
	  }
  public Point getPointA() {
    return pointA;

  }
  public Point getPointB() {
    return pointB;
  }
  public Point getPointC() {
	    return pointC;
	  }
  public String toString() {
    return "Triangle  from " + pointA + " to " + pointB + " to " + pointC;
    
  }
}