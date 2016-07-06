
import p2utils.*;

public class Dock {

   private final Stack<Container> containerStack;
   private final Queue<Container> accessExtension;
   private final int maxStack; // maximum number of containers in a stack

   public Dock(int maxStack) {
      accessExtension = new Queue<>();
      containerStack = new Stack<>();
      this.maxStack = maxStack; // controla-se o size fora da pilha
   }

   public boolean stackEmpty() {
      return containerStack.isEmpty();
   }

   public boolean stackFull() {
      return containerStack.size()==maxStack;
   }

   public boolean accessExtensionEmpty() {
      return accessExtension.isEmpty();
   }

   public int count() {
      return containerStack.size()+accessExtension.size();
   }

   public String toString() {
      return "In stack:" + containerStack.toString() + 
          " / In access: " + accessExtension.toString();
   }

   // a new container arrives and must be added to the queue
   public void enterContainer(Container c) {
      accessExtension.in(c);
   }
    
   // top container in stack is removed (it will be shipped)
   public Container shipContainer() {
     Container temp = containerStack.top();
	  containerStack.pop();
	  return temp;
   }

   // Moves containers from the accessExtension to the dock stack
   public void moveFromAccessToStack() {
      assert !stackFull();
      do {
         containerStack.push(accessExtension.peek());
         accessExtension.out();
      } while(!accessExtension.isEmpty() || !stackFull());

   }


   // pick the first container from the queue
   // and insert it in the stack in such way the stack
   // is sorted by distance to destination
   // (largest distance at the top)
   public void insertFirstInStack() {
      assert !stackFull() && !accessExtensionEmpty();
      Stack<Container> containerStackTemp = new Stack<>();
      if (stackFull()) return;
      if(accessExtension.peek().distance >= containerStack.top().distance) {
         containerStack.push(accessExtension.peek());
         accessExtension.out();
      } else {
         do {
            containerStackTemp.push(containerStack.top());
            containerStack.pop(); 
         } while (accessExtension.peek().distance < containerStack.top().distance);
         containerStack.push(accessExtension.peek());
         do {
            containerStack.push(containerStackTemp.top());
            containerStackTemp.pop();
         }while(!containerStackTemp.isEmpty());
      }
   }
}

