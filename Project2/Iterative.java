import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * @author Bob Wilson
 * @version 1.0, 12/20/2009
 * 
 * Applet with fractal pattern repetition using 
 * iterative drawing of triangles within triangles
 */

public class Iterative extends JApplet
{
 public void paint(Graphics screen)
 {
   screen.clearRect(0, 0, this.getWidth(), this.getHeight());
   screen.drawString("Iterative: Stack vs Queue", 0 , 10);
   Corner x = new Corner(0, this.getHeight());
   Corner y = new Corner(this.getWidth(), this.getHeight());
   Corner z = new Corner(this.getWidth() / 2, 0);
   
   drawTriangle(screen, new Triangle(x, y, z));  
 }
 
 /** 
  * iterative version of drawing
  * Note: It can work with either stack or queue for saving triangles
  * in five places in the code below: comment/uncomment one or the other ***
  * The only difference is in the order that sub-triangles are drawn.
  */
 
 private void drawTriangle(Graphics screen, Triangle t)
 {
   Stack<Corner> lifo = new Stack<Corner>();
   Triangle a = new Triangle(new Corner(this.getWidth()/3, 2*this.getHeight()/3),new Corner(2 *this.getWidth()/3,2*this.getHeight()/3),new Corner(this.getWidth()/2,this.getHeight()));
   //Triangle b = new Triangle(new Corner(0, 2*this.getHeight()/3),new Corner(this.getWidth(),2*this.getHeight()/3),new Corner(this.getWidth()/3,this.getHeight()));

   
   
   a.draw(screen);
   //b.draw(screen);
   t.draw(screen);
   

 }
} 
