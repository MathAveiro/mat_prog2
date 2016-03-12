

public class Door {
	public int room1, room2;
	public double width, heigth, area;
   public Door(int r1, int r2, double w, double h) {
   	room1=r1;
   	room2=r2;
   	width=w;
   	heigth=h;
   }
   public void area() {
   	area=width*heigth;
   }

}

