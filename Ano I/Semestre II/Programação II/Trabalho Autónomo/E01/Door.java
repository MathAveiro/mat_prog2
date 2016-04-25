public class Door {

	private int roomId1, roomId2;
	private double width, height;
	private double area;

	public Door(int r1, int r2, double w, double h) {

		this.roomId1 = r1;
		this.roomId2 = r2;
		this.width = w;
		this.height = h;

   }

   public double metodoArea () {

   		return this.area = width * height;

   }

   public int roomId1 () {

   		return this.roomId1;

   }

   public int roomId2 () {

   		return this.roomId2;

   }

}

