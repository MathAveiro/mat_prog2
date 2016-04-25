import static java.lang.System.*;

public class House {

   public House(String houseType,int maxSize,int extensionSize) {
      this.houseType = houseType;
      this.extensionSize = extensionSize;
      rooms = new Room[maxSize];
      size = 0;
      doors = new Door[maxSize];
      numDoors = 0;
   }

   public House(String houseType) {
      this(houseType,8,4);
   } 

   public int size() {
      return size;
   }

   public int maxSize() {
      return rooms.length;
   }

   public Room room(int i) {
      return rooms[i];
   }

   public int addRoom(Room r) {
      if (size == rooms.length) extendHouse();
      rooms[size] = r;
      size++;
      return size;
   }

   private void extendHouse() {
      Room [] newRooms = new Room[rooms.length+extensionSize];
      arraycopy(rooms, 0, newRooms, 0, rooms.length);
      rooms = newRooms;
   } 

   private String houseType;
   private int extensionSize;
   private Room [] rooms;
   private int size;
   private Door [] doors;
   private int numDoors;

   public void addDoor(Door d) {

      if (numDoors() == doors.length) {

         Door [] temp = new Door [doors.length + extensionSize];

         for (int i = 0;i<doors.length;i++) {
            
            temp[i] = doors[i];

         }

         doors = temp;

      }

      doors[numDoors] = d;
      
      numDoors++;
   
   }

   public int numDoors() {
      return numDoors;
   }

   public int maxNumDoors() {
      return doors.length;
   }

   public int roomClosestToRoomType(String roomType) {

      int k, identificador=0;
      double maisProxima=0;

      for (int i = 0;i < size(); i++) {
         
         if (rooms[i].roomType()==roomType) {

            identificador = i;

            if (identificador == 0) maisProxima = rooms[identificador].geomCenter().distTo(rooms[1].geomCenter()); 

            else maisProxima = rooms[identificador].geomCenter().distTo(rooms[0].geomCenter());

            break;

         }
      
      }

      int identificador1=0;

      for (k = 0;k < size(); k++) {
         
         if (k != identificador && rooms[k].geomCenter().distTo(rooms[identificador].geomCenter()) < maisProxima) {

            maisProxima = rooms[identificador].geomCenter().distTo(rooms[k].geomCenter());

            identificador1 = k;

         }

      }

      return identificador1;

   }

   public int maxDoorsInAnyRoom() {
         String temp;
         int count, temp1=0;
         for (int i=0; i<size; i++) {
            count=0;
            temp=rooms[i].roomType();
            for (int j=0; j<numDoors; j++) {
               if(rooms[doors[j].roomId1()].roomType() == temp || rooms[doors[j].roomId2()].roomType() == temp) {
                  count++;
               }
            }
            if(count>temp1) temp1=count;
         }
         return temp1;
   }

}

