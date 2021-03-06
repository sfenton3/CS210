import java.util.ArrayList;

/**
 * Project 1: Polynomial Manipulation, including Arithmetic, evaluation at 
 * specific x value, Newton's root method, derivation, comparison, and
 * toString capabilities
 * 
 * @author Scott Fenton
 * @version 10/03/2016
 * 
 */
  
 public class Polynomial implements Comparable<Polynomial>
{
  ArrayList<Integer> list = new ArrayList<Integer>();
  
    
  public Polynomial(Integer...nums){
    for (int i =0; i < nums.length; i++){
      if ((nums[i] == 0) && i == nums.length-1)
        continue;
      else
        list.add(nums[i]);
    }
    this.list = list;
  }
  
  
  
  /**
   * @return Returns a string value of the polynomial given any number of integers
   */
  public String toString(){   
      
  String result = "";
  String add = "";
  for (int i = 0; i < list.size(); i++){
    //skips zero's
    if (list.get(i) == 0)
      continue;
    //if first term is negative, special notation  
    else if (Math.abs(list.get(i)) == list.get(i) && i == list.size()-1){
        add = String.valueOf(list.get(i)) + "x^" + String.valueOf(i);}            
    //if positive, need to add addition sign  
    else if (Math.abs(list.get(i)) == list.get(i)){
        add = "+" + String.valueOf(list.get(i)) + "x^" + String.valueOf(i);}
    //if negative, don't neeed to add sign      
    else{
        add = String.valueOf(list.get(i)) + "x^" + String.valueOf(i);}
           
    result = add + " " + result;
     }
    return result.trim();
  }
  
  /**
   *@param that a Polynomial object
   *@return Returns 1,0,-1
   */
  public int compareTo(Polynomial that){
   int max = (that.list.size() > this.list.size()) ? that.list.size() : this.list.size();
   
   //Make both arrays equal size
   while (true){
    if (this.list.size() != max)
     this.list.add(0);
    if (that.list.size() != max)
     that.list.add(0);
    else
     break;
   }
   for (int i = max-1; i > 0; i--){
    if (this.list.get(i-1) > that.list.get(i-1))
     return 1;
    else if (this.list.get(i-1) < that.list.get(i-1))
     return -1;
    else
     continue;
     
   }return 0;
  }   
  /**
   * @param that a Polynomial object
   * @return Returns True if both Polynomials are equal, False if not equal
   */
  public boolean equals(Polynomial that){
    for (int i = list.size()-1; i >=0; i--){
     if (this.list.get(i) != that.list.get(i)){
       return false;}
     else 
       continue;
   }
   return true;
     
  }
  /**
   * @param that a Polynomial object
   * @return Returns two polynomials added together
   */
  public Polynomial plus(Polynomial that){
   int min = (that.list.size() < this.list.size()) ? that.list.size() : this.list.size();
   int max = (that.list.size() > this.list.size()) ? that.list.size() : this.list.size();
   Integer[] newPoly = new Integer[max];
   
   
   for (int i = 0; i < min; i++){
    newPoly[i] = that.list.get(i) + this.list.get(i);
   }
   //if arrays are of different sizes, add this if greater, add that if greater size array
   if (min != max){
     for (;min < max; min++){
       if (this.list.size() == max)
         newPoly[min] = this.list.get(min);
       else
         newPoly[min] = that.list.get(min);
   }
   }
      return new Polynomial(newPoly);
  }
  
  
   /**
   * @param that a Polynomial object
   * @return Returns this polynomial minus that polynomial
   */ 
  public Polynomial minus(Polynomial that){
   int min = (that.list.size() < this.list.size()) ? that.list.size() : this.list.size();
   int max = (that.list.size() > this.list.size()) ? that.list.size() : this.list.size();
   Integer[] newPoly = new Integer[max];
   
   for (int i = 0; i < min; i++){
    newPoly[i] = this.list.get(i) - that.list.get(i);
   }
   //if arrays are of different sizes, add positive if this-that, or negative if that-this
   if (min != max){
     for (;min < max; min++){
       if (this.list.size() == max)
         newPoly[min] = this.list.get(min);
       else
         newPoly[min] = -that.list.get(min);
   

   }
   }
      return new Polynomial(newPoly);
  }
  /**
   * @param that a Polynomial object
   * @return Returns a polynomial multiplied by another polynomial
   */ 
  public Polynomial multiply(Polynomial that){
   int min = (that.list.size() < this.list.size()) ? that.list.size() : this.list.size();
   int max = (that.list.size() > this.list.size()) ? that.list.size() : this.list.size();
   Integer[] newPoly = new Integer[max+min];
   
   for(int i = 0; i < newPoly.length;i++)
     newPoly[i] = 0;
   //double for loop, goes through every combination of each polynomial and multiplies them  
   for(int i = 0; i < min; i++){
     for(int j= 0; j < max; j++){
       if (this.list.size() == min){
         newPoly[j+i] += this.list.get(i) * that.list.get(j);
       }
       else{
         newPoly[j+i] += that.list.get(i) * this.list.get(j);
       }
     }
   }  
      return new Polynomial(newPoly);
  }
  /**
   * @param that a Polynomial object
   * @return Returns two polynomials in a polynomial array
   * one representing a quotient, another a remainder
   */
  public Polynomial[] divide(Polynomial that){
  int thislength = this.list.size();
  int thatlength = that.list.size();
  int max = this.list.size() - that.list.size();
  Polynomial[] r = new Polynomial[2];

 
  if (that.compareTo(new Polynomial(0)) == 0){
   int x = 1/0;
   return r;}
  //if denominator is greater than numerator, there is no quotient, and remainder is denominator
  else if (thislength < thatlength){
    r[0] = new Polynomial(0);
    r[1] = this;}
  //If numerator is greater than or equal to denominator, there is a valid quotient
  else{
      Integer[] quotient = new Integer[max+1];
      for(int i = 0; i < quotient.length;i++)
        quotient[i] = 0;
      for(; max >= 0; max--){
        quotient[max] = this.list.get(thislength-1) / that.list.get(thatlength-1);}
      r[0] = new Polynomial(quotient);
      r[1] = new Polynomial(0);     
   
   }return r;
  }  
  
  /**
   * @param x Accepts a double to evaluate polynomial with
   * @return Returns a polynomial evaluated at x
   */
  public double evaluate(double x){
    double result = 0;
    //calculates each x value in list
    for (int i = 0; i < this.list.size(); i++){
      double power = Math.pow(x, i);
      double coeff = this.list.get(i);
      
      result += coeff * power;
    }
    return result;
  
  }
  /**
   * @return Returns a polynomial with the power formula applied
   */
  public Polynomial derivative(){
    Integer[] newPoly = new Integer[list.size()];
    
    for(int i =0; i < newPoly.length; i++)
      newPoly[i] = 0;
    //skips last ax^0 value (equals 0), calculates power rule on each x value 
    for (int i = list.size()-1; i >= 0; i--){
      if (i == 0)
        continue;
      else
        newPoly[i-1] = list.get(i) * i;
      
    

  }
        return new Polynomial(newPoly);
  }
  /**
   * @param guess a guess at what value x is
   * @param TOLERANCE a constant value that has a return that must be within this value
   * @param iterations Maximum number of iterations through loop
   * @return the root of a polynomial with newtons root method applied 
   */
  public double root(double guess, double TOLERANCE, int iterations){
    Integer[] newPoly = new Integer[list.size()];
    int z = 0;
    for (Integer i : list){
        newPoly[z] = i;
        z++;
    }
    for (Integer i : newPoly){
        System.out.println(i);
    }
    Polynomial p1 = new Polynomial(newPoly);
    //returns guess if it equals 0, else it calculates newtons root method
    for (int i = iterations; i > 0 ; i--){
      if (guess == 0.0)
        return guess;
      guess = guess - (p1.evaluate(guess) / p1.derivative().evaluate(guess));
      

  
}  

      return guess;
}
 }