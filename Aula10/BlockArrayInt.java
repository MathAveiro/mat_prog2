import p2utils.*;
public class BlockArrayInt
{
   private int bS, nB;
   LinkedList<int[]> list = new LinkedList<int[]>();
   public BlockArrayInt(int blockSize,int numBlocks)
   {
      assert blockSize > 0;
      assert numBlocks > 0;
      bS=blockSize;
      nB=numBlocks;
      a = new int[blockSize*numBlocks];
      list.addLast(a);
   }

   public int get(int index)
   {
      assert validIndex(index);
      //System.out.println(list.size());
      int block = (int)( index / bS );
      int i = index - (block * bS);
      a = list.get(block);
      return a[i];
   }

   public void put(int elem,int index)
   {
      assert validIndex(index);
      int block = (int)( index / bS );
      //System.out.println(block);
      int i = index - (block * bS);
      a[i] = elem;
   }

   public void incrementNumberOfBlocks()
   {  
      nB++;
      a = new int[bS];
      list.addLast(a);
   }

   public int size()
   {
      return nB*bS;
   }

   public int numberOfBlocks()
   {
      return nB;
   }

   public int blockSize()
   {
      return a.length;
   }

   public boolean validIndex(int index)
   {
      return index >= 0 && index < bS*(nB+1);
   }

   private int[] a;
}

