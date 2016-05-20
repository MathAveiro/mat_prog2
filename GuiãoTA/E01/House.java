
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
      return size-1;
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
   		if(numDoors==doors.length) extendSize();
      doors[numDoors] = d;
      numDoors++;
   }
   public void extendSize() {
   	Door[] newDoors = new Door[doors.length+extensionSize];
   	arraycopy(doors, 0, newDoors, 0, doors.length);
   	doors=newDoors;
   }

   public int numDoors() {
      return numDoors;
   }

   public int maxNumDoors() {
      return doors.length;
   }
   public int roomClosestToRoomType(String roomType) {
   	int r1=0;
   	for (int i=0; i<=size-1; i++) {
   		if (rooms[i].roomType()==roomType) {
   			r1=i;
   			break;
   		}
   	}
   	double temp=dist(r1, 0);
   	int ind=0;
   	for (int i=0;i<=size-1; i++) {
   		if (r1==i) i++;
   		if(dist(r1, i)<temp) {
   			temp = dist(r1, i);
   			ind=i;
   		}
   	}
   	return ind;
   }
   public double dist(int r1, int r2) {
   	double dist = rooms[r1].geomCenter().distTo(rooms[r2].geomCenter());
   	return dist;
   }
   public int maxDoorsInAnyRoom() {
   		String temp;
   		int count, temp1=0;
   		for (int i=0; i<size; i++) {
   			count=0;
   			temp=rooms[i].roomType();
   			for (int j=0; j<numDoors; j++) {
   				if(rooms[doors[j].room1].roomType() == temp || rooms[doors[j].room2].roomType() == temp) {
   					count++;
   				}
   			}
   			if(count>temp1) temp1=count;
   		}
   		return temp1;
   }

}

