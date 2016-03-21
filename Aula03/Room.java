public class Room {
	private String roomType;
	private Point bottomLeft, topRight, geomCenter;
	private double area;
	public Room(Point bottomLeft, Point topRight, String roomType) {
		this.roomType=roomType;
		this.bottomLeft=bottomLeft;
		this.topRight=topRight;
	}
	public Point bottomLeft() {
		return bottomLeft;
	}
	public Point topRight() {
		return topRight;
	}
	public String roomType() {
		return roomType;
	}
	public Point geomCenter() {
		geomCenter=bottomLeft.halfWayTo(topRight);
		return geomCenter;
	}
	public double area() {
		double largura = Math.abs(bottomLeft.x()-topRight.x());
		double comprimento = Math.abs(bottomLeft.y()-topRight.y());
		return largura*comprimento;
	}
}