import java.util.*;
import java.io.*;
import static java.lang.System.*;
import static java.lang.Integer.*;

public class House37 {

	private String typeHouse;

	private int nDivisoes;

	private int nDivisoesAdd;

	private Room37 divisao [];

	private int n = 0;

	public House37 (String estilo) {

		this.typeHouse = estilo;

		this.nDivisoesAdd = 4;

		this.divisao = new Room37 [nDivisoes];

	}

	public House37 (String estilo, int nDivisoes, int reservarMemoria) {

		this.typeHouse = estilo;

		this.nDivisoes = nDivisoes;

		this.nDivisoesAdd = reservarMemoria;

		this.divisao = new Room37 [nDivisoes];

	}

	public void addRoom (Room37 room) {

		if (n == divisao.length) {

			Room37 [] divisaoTemp = new Room37 [divisao.length+nDivisoesAdd];

			for (int temp = 0; temp < divisao.length ; temp++) {
				
				divisaoTemp [temp] = divisao [temp];

			}

			divisao = divisaoTemp;

		}

		divisao [n] = new Room37 (room.bottomLeft(), room.topRight(), room.roomType());

		n++;

	}

	public int size () {

		int cont = 0;

		for (int i = 0 ; i < this.n ; i++) {
			
			cont++;

		}

		return cont;	

	}

	public int maxSize () {

		return this.divisao.length;

	}

	public Room37 room (int a) {

		if (a < 0 || a > size()) System.exit(0);

		return divisao [a];

	}

	public double area () {

		double area = 0;

		for (int i = 0 ; i < this.n ; i++) {

			area = area + divisao [i].area();

		}		

		return area;

	}

	public RoomTypeCount [] getRoomTypeCounts() {

		int temp = 0;

		for (int  temp2 = 0 ; temp2 < this.n ; temp2++) {

				int temp3 = 0;
				
				for (int temp4 = temp2+1; temp4 < this.n; temp4++) {
			
					if (divisao[temp2].roomType().compareTo(divisao[temp4].roomType())==0) temp3++;

				}

				if (temp3==0) temp++;

		}

		RoomTypeCount [] tipoDivisao = new RoomTypeCount [temp+1];

		int temp5 = 0;

		for (int temp6 = 0;temp6 < this.n ; temp6++) {
			
			tipoDivisao[temp5] = new RoomTypeCount();

			tipoDivisao[temp5].roomType = divisao[temp6].roomType();
			
			tipoDivisao[temp5].count=1;

			for (int temp7 = 0; temp7 < temp5; temp7++) {
				
				if (tipoDivisao[temp7].roomType.compareTo(tipoDivisao[temp5].roomType)==0) {
				
					tipoDivisao[temp7].count++;
			
					temp5--;

				}

			}

			temp5++;

		}

		RoomTypeCount [] ntipoDivisao = new RoomTypeCount [temp];

		for (int temp8 = 0 ;temp8 < temp; temp8++) {
			
			ntipoDivisao[temp8] = tipoDivisao [temp8];

		}

		tipoDivisao = ntipoDivisao;

		return	tipoDivisao;

	}

	public double averageRoomDistance () {

		double distancia=0;

		int count = 0;

		for (int i = 0; i < this.n; i++) {

			int j = i;

			do {

				distancia = distancia + divisao[i].geomCenter().distTo(divisao[j].geomCenter());

				j++;

				count++;			

			} while (j < this.n);

		}	

		return distancia/count;

	}

}