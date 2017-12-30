import javax.swing.*;
import java.awt.*;

/**
 * @author Bob Wilson
 * @version 1.0, 12/20/2009
 * 
 * Triangle class for fractal pattern generation
 */

public class Triangle
{
  // indices for sub-triangles
  public static final int CORNER_ONE = 0;
  public static final int CORNER_TWO = 1;
  public static final int CORNER_THREE = 2;
  public static final int EDGE_ONE = 3;
  public static final int EDGE_TWO = 4;
  public static final int EDGE_THREE = 5;
  
  // smallest perimeter for triangle to be drawn
  public static final int SMALLEST = 30;
  
  private Corner x;
  private Corner y;
  private Corner z;
    
  public Triangle(Corner x, Corner y, Corner z)
  {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public void draw(Graphics screen)
  {
   screen.drawLine(x.w, x.d, y.w, y.d);
   screen.drawLine(y.w, y.d, z.w, z.d);
   screen.drawLine(z.w, z.d, x.w, x.d);
  }
  
  public int size()
  {
    // write your code here
    return 0;
  }
  
  public Triangle getNextLevel(int index)
  {
    Triangle t = null;
    // write your code here
    
    return t;
  }
}