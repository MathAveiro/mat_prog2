import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class Room37 {

	private Point bottomLeft, topRight, geomCenter;
	private double area;
	private String roomType;

	public Room37 (Point bottomLeft, Point topRight, String roomType) {

		this.roomType = roomType;
		this.bottomLeft = bottomLeft;
		this.topRight = topRight;

	}

	public String roomType () {

		return roomType;

	}

	public Point bottomLeft () {

		return bottomLeft;
		
	}

	public Point topRight () {

		return topRight;
		
	}

	public Point geomCenter () {

		geomCenter = bottomLeft().halfWayTo(topRight());

		return geomCenter;

	}

	public double area () {

		double largura = Math.abs(bottomLeft.x() - topRight.x());
		double altura = Math.abs(bottomLeft.y() - topRight.y());

		return area = largura * altura;

	}

}