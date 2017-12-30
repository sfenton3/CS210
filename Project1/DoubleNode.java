public class DoubleNode<T>
{
  DoubleNode<T> next;
  DoubleNode<T> prev;
  T element;
  
  public DoubleNode(T element){
    this.element = element;
    next = prev = null;
  }
  public void setNext(DoubleNode<T> next){
    this.next = next;
  }
    
  public void setPrev(DoubleNode<T> prev){
    this.prev = prev;
  }
  
  public DoubleNode<T> getNext(){
    return this.next;
  }
  
    public DoubleNode<T> getPrev(){
    return this.prev;
    }
    
    public T getElement(){
      return this.element;
    }
}