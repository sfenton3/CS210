public class DoubleList<T>{
  private DoubleNode<T> first; //actually the first node
  private DoubleNode<T> last; //actually the last node
  private int count;
  
  public DoubleList(){
    count = 0;
    first = last = null;
  }
  
  public void addFirst(T element){
    DoubleNode<T> newNode = new DoubleNode<T>(element);
    if (count == 0){
      first = last = newNode;
    }
    else {
      newNode.setNext(first);
      newNode.setPrev(first.getPrev()); //not needed null
      first.setPrev(newNode);
      first = newNode;
  
}
    count++;
  }
  
  public void removeFirst(){  
    if(count == 0)  
      first = last;
    else if(count == 1){
      first = last = null;
      count--;}
    else{
      DoubleNode tmp = first;
      first = first.getNext();
      first.setPrev(null);
      count--;
      
      
    }
      
  }
  
  public void addLast(T element){
    DoubleNode<T> newNode = new DoubleNode<T>(element);
    if (count == 0){
      last = first = newNode;
    }
    else {
      last.setNext(newNode);
      last = newNode;
    
    
  }
    count++;
  }
  public void removeLast(){
   if (count == 0)
     first = last;
   else{
     DoubleNode tmp = last;
     last = last.getPrev();
     last.setNext(null);
     count--;
    
  }
  }
  
  public void printFront(){
    while(first != null){
        System.out.println(first.getElement());
        first = first.getNext();
    }            
  }
  
  public void printBack(){
    while(last != null){
      System.out.println(last.getElement());
      last = last.getPrev();}
}  
  
  public static void main(String[] args){
    DoubleList<Integer> dll = new DoubleList<Integer>();
    dll.addLast(1);
    dll.addLast(5);
    dll.addLast(10);
    dll.removeFirst();
    dll.removeFirst();
    dll.removeFirst();
    dll.printFront();
    System.out.println(".............." + dll.count);
    
  }
  
}
  
  