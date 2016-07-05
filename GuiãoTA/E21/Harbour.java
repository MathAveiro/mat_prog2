
import static java.lang.System.*;
import p2utils.*;

public class Harbour {

   private final Dock[] docks;
   private final int maxStack;
   KeyValueList<Integer> city = new KeyValueList<>();

   public Harbour(int nOfDocks,int maxStack) {
        
      docks = new Dock[nOfDocks];
      for (int dockId=0; dockId<nOfDocks; dockId++) {
          docks[dockId] = new Dock(maxStack);
      }
      this.maxStack = maxStack;
   }        

   public boolean stackEmpty(int dockId) {
      return docks[dockId].stackEmpty();
   }

   public boolean stackFull(int dockId) {
      return docks[dockId].stackFull();
   }

   public boolean accessExtensionEmpty(int dockId) {
      return docks[dockId].accessExtensionEmpty();
   }

   public void displayDocks() {
      for (int dockId=0; dockId<docks.length; dockId++) {
         out.println(dockId+": "+docks[dockId]);
      }
   }

   public void enterContainer(int dockId,Container c) {
      docks[dockId].enterContainer(c); // implement in the Dock class
      int num = 1;
      if (city.contains(c.destination)) {
         num = city.get(c.destination);
         num += 1;
      }
      city.set(c.destination, num);

   }

   public void moveFromAccessToStack(int dockId) {
      docks[dockId].moveFromAccessToStack(); // implement in the Dock class
   }

   // the container on top of the stack in the given dock
   // is removed because it will be shipped
   public Container shipContainer(int dockId) {
      Container c = docks[dockId].shipContainer(); //implement in the Dock class
      int num = city.get(c.destination);
      num -=1;
      city.set(c.destination, num);
      if (city.get(c.destination) == 0) city.remove(c.destination);
      return c;
   }
 
   // total number of containers
   public int count() {
      int total = 0;
      for (int i = 0; i < docks.length; i++) {
         total += docks[i].count();
      }
      return total;
   }

   // number of containers for a given destination
   public int countToDestination(String destin) {
      if (city.contains(destin)) return city.get(destin);
      else return 0;
   }

   // array containing destinations of existing containers
   public String[] currentDestinations() {
      return city.keys();
      
   }

   // given a dock, picks the first container
   // in the queue and inserts in the stack of the same dock
   public void insertFirstInStack(int dockId) {
      docks[dockId].insertFirstInStack(); // implement in the Dock class
   }
}
