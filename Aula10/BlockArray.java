public class BlockArray<T>
{
   @SuppressWarnings(value = "unchecked")
   public BlockArray(int blockSize,int numBlocks,T defaultValue)
   {
      assert blockSize > 0;
      assert numBlocks > 0;

      a = (T[]) new Object[blockSize*numBlocks];
      this.defaultValue = defaultValue;
   }

   public T get(int index)
   {
      assert validIndex(index);

      if (a[index] == null)
         a[index] = defaultValue;
      return a[index];
   }

   public void put(T elem,int index)
   {
      assert validIndex(index);

      a[index] = elem;
   }

   public void incrementNumberOfBlocks()
   {
      assert false: "Not yet implemented!";
   }

   public int size()
   {
      return a.length;
   }

   public int numberOfBlocks()
   {
      return 1;
   }

   public int blockSize()
   {
      return a.length;
   }

   public boolean validIndex(int index)
   {
      return index >= 0 && index < size();
   }

   private T[] a;
   private T defaultValue;
}

