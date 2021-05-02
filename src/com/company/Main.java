
package com.company;

 class Heap<T extends Comparable<T>>{
     private Object[] Heap;
     private int size;
     private int maxsize = 15;

     public Heap()
     {
         this.size = 0;
         Heap = new Object[this.maxsize + 1];
         Heap[0] = 0;
     }
     private int parent(int i)
     {
         return i / 2;
     }
     private int leftChild(int i)
     {
         return (2 * i);
     }

     private int rightChild(int i)
     {
         return (2 * i) + 1;
     }

     private boolean isLeaf(int i)
     {
         if (i >= (size / 2)) {
             if(i <= size) {
                 return true;
             }
         }
         else{
             return false;
         }
         return false;

     }
     private void swap(int a, int b)
     {

         T tmp;
         tmp = (T) Heap[a];
         Heap[a] = Heap[b];
         Heap[b] = tmp;
     }

     private void minHeapify(int i)
     {
        T position = (T)Heap[i];
        T left = (T) Heap[leftChild(i)];
         T right = (T) Heap[rightChild(i)];

         if (isLeaf(i) == false) {

             if (position.compareTo(left) > 0 || position.compareTo(right) > 0) {


                 if ( left.compareTo(right) < 0) {
                     swap(i, leftChild(i));
                     minHeapify(leftChild(i));
                 }
                 else {
                     swap(i, rightChild(i));
                     minHeapify(rightChild(i));
                 }
             }
             else{
                 return;
             }
         }
         else{
             return;
         }
     }
     public void insert(T element)
     {
         if (size >= maxsize) {
             return;
         }
         Heap[++size] = element;
         int current = size;
         T cur = (T)Heap[current];
         T parCur = (T)Heap[parent(current)];
         while (cur.compareTo(parCur) < 0) {
             swap(current, parent(current));
             current = parent(current);
              cur = (T)Heap[current];
              parCur = (T)Heap[parent(current)];
         }
         return;
     }


     public boolean empty(){
         if(size == 0){
             return true;
         }
        return false;
     }
     public int getSize(){
         return size;
     }
     public T getMin(){
         return (T)Heap[1];
     }
     public T extractMin()
     {
         T extracted = (T)Heap[1];
         Heap[1] = Heap[size--];
         minHeapify(1);
         return extracted;
     }
 }


public class Main {

    public static void main(String[] args) {
        Heap minHeap = new Heap();
        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.insert(8);
        minHeap.insert(24);
        minHeap.insert(18);
        minHeap.insert(4);
        minHeap.insert(15);
        minHeap.insert(5);

    }
}

