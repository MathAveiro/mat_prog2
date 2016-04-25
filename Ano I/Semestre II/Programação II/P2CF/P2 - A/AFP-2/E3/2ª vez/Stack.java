@SuppressWarnings("unchecked")
public class Stack<T>
{
  public Stack()
  {
    int maxSize=1024;
    size=0;
    array = (T[]) new Object [maxSize];
  }
  
  public int size()
  {
    return size;
  }
  
  public boolean isEmpty()
  {
    return size==0;
  }
  
  public void clear()
  {
    size=0;
  }
  
  public boolean isFull()
  {
    return size==array.length;
  }
  
  public T top()
  {
    assert !isEmpty();
    return array[size-1];
  }
  
  public void pop()
  {
    assert !isEmpty();
    size--;
    assert !isFull();
  }
  
  public void push(T e)
  {
    T[] arr;
   
    if(isFull())
    {
      arr = (T[]) new Object[2*array.length];
      System.arraycopy(array,0,arr,0,array.length);
      array=arr;
    }
    
    array[size]=e;
    size++;
    assert !isEmpty();
  }
  
  private int size;
  private T[] array;
}