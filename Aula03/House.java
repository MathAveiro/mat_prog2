public class House {
	static int count=0;
	static String houseType;
	static int nDiv, addDiv;
	static Room[] rooms;
	public House(String houseType) {
		this.houseType=houseType;
		nDiv=8;
		addDiv=4;
		rooms = new Room[nDiv];	
	}
	public House(String houseType, int nDiv, int addDiv) {
		this.houseType=houseType;
		this.nDiv=nDiv;
		this.addDiv=addDiv;
		rooms = new Room[nDiv];
	}
	public void addRoom(Room a) {
		if(count==rooms.length) {
			Room[] nrooms = new Room[rooms.length+addDiv];
			for (int i=0; i<rooms.length; i++){
				nrooms[i]=rooms[i];
			}
			rooms=nrooms;
		}
		rooms[count] = new Room(a.bottomLeft(), a.topRight(), a.roomType());
		count++;
	}
	public int size() {
		return count;
	}
	public int maxSize() {
		return rooms.length;
	}
	public Room room(int x) {
		return rooms[x];
	}
	public double area() {
		double area=0;
		for (int i=0; i<count; i++) {
			area=area+rooms[i].area();
		}
		return area;
	}
	public RoomTypeCount[] getRoomTypeCounts() {
		int t=0;
		for (int i=0; i<count; i++) {
			int h1=0;
			for(int j=i+1; j<count; j++) {
				if(rooms[i].roomType().compareTo(rooms[j].roomType())==0) h1++;
			}
			if(h1==0)  t++;
		}
		RoomTypeCount[] roomType = new RoomTypeCount[t+1];
		int y=0;
		for (int i=0; i<count; i++) {
			roomType[y] = new RoomTypeCount();
			roomType[y].roomType = rooms[i].roomType();
			roomType[y].count=1;
			for(int j=0; j<y; j++) {
				if (roomType[j].roomType.compareTo(roomType[y].roomType)==0) {
					roomType[j].count++;
					y--;
				}
			}
			y++;
		}
		RoomTypeCount []nroomType = new RoomTypeCount[t];
		for(int g=0; g<t; g++) {
			nroomType[g]=roomType[g];
		}
		roomType = nroomType;
		return roomType;
	}
	public double averageRoomDistance() {
		double mdist=0.0;
		for (int i=0; i<count; i++) {
			int j=0;
			do {
				mdist=mdist+rooms[i].geomCenter().distTo(rooms[j].geomCenter());
				j++;
			}while(j<count);
		}
		return mdist/count;
	}
}