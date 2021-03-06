//********************************************************************
//  SortingAndSearching.java    Authors: Lewis/Chase
//  modified by Bob  Wilson 10/28/2015
//  Demonstrates sorting and searching on an array of objects.
//********************************************************************

public class SortingAndSearching<T extends Comparable<T>>  
{
   private int compareCount;
   private int memoryCount;
   private int maxMemoryCount;

   public SortingAndSearching()
   {
     compareCount = 0;
     memoryCount = 0;
     maxMemoryCount = 0;
   }

   public void resetCompareCount()
   {
     compareCount = 0;
   }

   public int getCompareCount()
   {
     return compareCount;
   }
   
   public int getMaxMemoryCount()
   {
     return maxMemoryCount;
   }
   /********************************************************************
     Sorts the specified array of objects using the quick sort
     algorithm.
   ********************************************************************/
   public void quickSort (T[] data, int min, int max)
   {
      int indexofpartition;

      if (max - min  > 0)
      {
         /** Create partitions */
         indexofpartition = findPartition(data, min, max);

         /** Sort the left side */
         quickSort(data, min, indexofpartition - 1);

         /** Sort the right side */
         quickSort(data, indexofpartition + 1, max);
      }
   }

   /********************************************************************
     Used by the quick sort algorithm to find the partition.
   ********************************************************************/
   private int findPartition (T[] data, int min, int max)
   {
      int left, right;
      T temp, partitionelement;
      
      //causes worst case behavior in already sorted algorithms
      partitionelement = data[(min + max) / 2]; // use first element as partition
      left = min;
      right = max;
   
      while (left<right)
      {
         /** search for an element that is > the partitionelement */
         while (compareCount++ != -1 && data[left].compareTo(partitionelement) <=0 &&
                            left < right)
            left++;

         /** search for an element that is < the partitionelement */
         while (compareCount++ != -1 && data[right].compareTo(partitionelement) > 0)
            right--;

         /** swap the elements  */
         if (left<right)
         {
            temp = data[left];
            data[left] = data[right];
            data[right] = temp;
         }
      }

      /** move partition element to partition index*/
      temp = data[min];
      data[min] = data[right];
      data[right] = temp;
         
      return right;
   }

   /********************************************************************
     Sorts the specified array of objects using the merge sort
     algorithm.
   ********************************************************************/
   @SuppressWarnings("unchecked")
   public void mergeSort (T[] data, int min, int max)
   {
      T[] temp;
      int index1, left, right;

      /** return on list of length one */
      if (min==max)
         return; 

      /** find the length and the midpoint of the list */
      int size = max - min + 1;
      int pivot = (min + max) / 2;
      //temp = (T[])(new Comparable[size]);
      mergeSort(data, min, pivot); // sort left half of list
      mergeSort(data, pivot + 1, max); // sort right half of list
      temp = (T[])(new Comparable[size]);
      
      /** copy sorted data into workspace */
      for (index1 = 0; index1 < size; index1++){
         temp[index1] = data[min + index1];
         memoryCount++;
      }
      if (maxMemoryCount < memoryCount)
        maxMemoryCount = memoryCount / 2;
      memoryCount = 0;

      
      /** merge the two sorted lists */
      left = 0;
      right = pivot - min + 1;
      for (index1 = 0; index1 < size; index1++)
      {
         if (right <= max - min)
            if (left <= pivot - min)
               if (compareCount++ != -1 && temp[left].compareTo(temp[right]) > 0)
                  data[index1 + min] = temp[right++];
               
               else
                  data[index1 + min] = temp[left++];
            else
               data[index1 + min] = temp[right++];
         else
            data[index1 + min] = temp[left++];
      }
      if (maxMemoryCount < memoryCount)
        maxMemoryCount = memoryCount;
      memoryCount = 0;
   }

   /********************************************************************
     Sorts the specified array of objects using a bubble sort
     algorithm.
   ********************************************************************/
   public void bubbleSort (T[] data)
   {
      int position, scan;
      T temp;
      int swap = 0;

      for (position =  data.length - 1; position >= 0; position--)
      {
         swap = 0;
         for (scan = 0; scan <= position - 1; scan++)
         {
            if (compareCount++ != -1 && data[scan].compareTo(data[scan+1]) > 0)
            {
               /** Swap the values */
               temp = data[scan];
               data[scan] = data[scan + 1];
               data[scan + 1] = temp;
               swap++;
            }
           

         }
         if (swap == 0)
           break;
      }
   }

   /********************************************************************
     Searches the specified array of objects using a linear search
     algorithm.
   ********************************************************************/
   public boolean linearSearch (T[] data,int min, int max, T target)
   {
      int index = min;
      boolean found = false;

      while (!found && index <= max) 
      {
         if (compareCount++ != -1 && data[index].compareTo(target) == 0) 
            found = true;
         index++;
      }

      return found;
   }

   /********************************************************************
     Searches the specified array of objects using a binary search
     algorithm.
   ********************************************************************/
   public boolean binarySearch (T[] data, int min, int max, T target)
   {  
      boolean found = false;
      int midpoint = (min + max) / 2;  // determine the midpoint

      if (compareCount++ != -1 && data[midpoint].compareTo(target) == 0)
         found = true;

      else if (compareCount++ != -1 && data[midpoint].compareTo(target) > 0)
      {
         if (min <= midpoint - 1)
            found = binarySearch(data, min, midpoint - 1, target);
      }
      
      else if (midpoint + 1 <= max)
         found = binarySearch(data, midpoint + 1, max, target);

      return found;
   }

   /********************************************************************
     Sorts the specified array of integers using the selection
     sort algorithm.
   ********************************************************************/
   public void selectionSort (T[] data)
   {
      int min;
      T temp;
      
      for (int index = 0; index < data.length-1; index++)
      {
         min = index;
         for (int scan = index+1; scan < data.length; scan++)
            if (compareCount++ != -1 && data[scan].compareTo(data[min])<0)
               min = scan;

         /** Swap the values */
         temp = data[min];
         data[min] = data[index];
         data[index] = temp;
      }
   }
   /********************************************************************
     Sorts the specified array of objects using an insertion
     sort algorithm.
   ********************************************************************/
   public void insertionSort (T[] data)
   {
      for (int index = 1; index < data.length; index++)
      {
         T key = data[index];
         int position = index;

         /** Shift larger values to the right */
         while (compareCount++ != -1 && position > 0 && data[position-1].compareTo(key) > 0)
         {
            data[position] = data[position-1];
            position--;
         }
            
         data[position] = key;
      }
   }
}  /*201540*/
