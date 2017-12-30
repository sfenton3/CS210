import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/**
 * @author Bob Wilson
 * @version 1.0, 12/20/2009
 * 
 * Applet with fractal pattern repetition using
 * recursive drawing of triangles within triangles
 */

public class Recursive extends JApplet
{

 public void paint(Graphics screen)
 {
   screen.clearRect(0, 0, this.getWidth(), this.getHeight());
   screen.drawString("Recursive", 0 , 10);
   Corner x = new Corner(0, this.getHeight());
   Corner y = new Corner(this.getWidth(), this.getHeight());
   Corner z = new Corner(this.getWidth() / 2, 0);
   
   drawTriangle(screen, new Triangle(x, y, z));  
 }
 
 /**
  * recursive version of drawing
  */

 private void drawTriangle(Graphics screen, Triangle t)
 {
   // Write your code here
  
 }
} 
