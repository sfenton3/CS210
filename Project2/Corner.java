/**
 * @author Bob Wilson
 * @version 1.0, 12/20/2009
 * 
 * Corner class for Triangles in fractal pattern generation
 */

public class Corner
{
  protected int w;
  protected int d;
  
  public Corner(int w, int d)
  {
    this.w = w;
    this.d = d;
  }
  
  public Corner mid(Corner that)
  {
    return new Corner((this.w + that.w) / 2, (this.d + that.d) / 2);
  }
 
  public int len(Corner that)
  {
    return (int) Math.sqrt(Math.pow((this.w - that.w), 2) 
                         + Math.pow((this.d - that.d), 2));
  }
}