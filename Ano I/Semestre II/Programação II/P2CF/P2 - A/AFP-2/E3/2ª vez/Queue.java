public class Queue<T>
{
  public Queue()
  {
    int maxSize=1024;
    size=head=tail=0;
    array = (T[]) new Object[maxSize];
  }
  
  public int size()
  {
    return size;
  }
  
  public boolean isEmpty()
  {
    return size==0;
  }
  
  public boolean isFull()
  {
    return size==array.length;
  }
  
  public void clear()
  {
    size=head=tail=0;
    assert !isFull();
  }
  
  public int nextPosition(int p)
  {
    return (p+1)%array.length;
  }
  
  public T peek()
  {
    assert !isEmpty();
    return array[head];
  }
  
  public void out()
  {
    assert !isEmpty();
    size--;
    head = nextPosition(head);
    assert !isFull();
  }
  
  public void in(T e)
  {
    T [] arr;
    
    if(isFull())
    {
      arr = (T[]) new Object[2*array.length];
      System.arraycopy(array,0,arr,0,array.length);
      array=arr;
    }
    
    array[tail]=e;
    tail=nextPosition(tail);
    assert !isEmpty();
  }
  
  
  private int head, size, tail;
  private T[] array;
}