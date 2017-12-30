import java.util.Comparator;
public class MaxHeap
{
 private Comparator<String> cmp; // Comparator for String objects
 private String [] heapArray; // array for heap of Strings
 private final int ENOUGH = 10; // large enough size for heapArray
 private final int ROOT = 0; // index of root node is zero
 private int next;


 public MaxHeap (Comparator<String> cmp)
 {
 this.cmp = cmp;
 heapArray = new String[ENOUGH];
 next = ROOT; // initially the next node to be filled
 } // is the root node

 public int size()
 {
 return next;
 }
 public void add(String key)
   {
 // add new node at next position in array
 heapArray[next] = key;
 // and heapify on add
 int child = next++;
 boolean done = false;
 while (child != ROOT && !done) {
 done = true;
 int parent = (child - 1) / 2;
 if (cmp.compare(heapArray[parent], heapArray[child]) < 0) {
 swap(parent, child);
 child = parent;
 done = false; 
}
 }
   }


 public String remove(){
 if (size() == 0)
 return null;

 // pick up and save reference to root which is max
 String s = heapArray[ROOT];

 // and swap last with root
 heapArray[ROOT] = heapArray[--next];
 heapArray[next] = null; // clear alias

 // now heapify on remove
 int parent = ROOT;
 boolean done = false;
 while (!done) {
 done = true;
 if (2 * (parent + 1) < next) { // parent still has two children
 int largestChild =
 cmp.compare(heapArray[2*parent+1],heapArray[2*(parent+1)]) > 0 ?
 2*parent+1 : 2*(parent+1);
 if (cmp.compare(heapArray[parent], heapArray[largestChild]) < 0) {
 swap(parent, largestChild);
 parent = largestChild;
 done = false;
 } // else now we are done
 }
 else if (2 * parent + 1 < next) { // parent is in next to bottom level
 // right child is null but left is not
 int largestChild = 2 * parent + 1;
 if (cmp.compare(heapArray[parent], heapArray[largestChild]) < 0)
 swap(parent, largestChild);
 } // and now we are done
 // else no children so we must be done
 }
 return s;
 }

 // helper method to swap two elements in the heapArray
 private void swap(int node1, int node2)
 {
 String temp = heapArray[node1];
 heapArray[node1] = heapArray[node2];
 heapArray[node2] = temp;
 }

 public static void main(String [] args)
 {
 Comparator<String> comp = new Comparator<>(); 
 MaxHeap myMaxHeap = new MaxHeap(comp);
 myMaxHeap.add("One");
 System.out.println("Removing and printing everything");
 while (myMaxHeap.size() > 0)
 System.out.println(myMaxHeap.remove()); 
 }
}
 