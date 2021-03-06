package gyakorlas;

import java.util.Calendar;

public class Primek {
	
	
	public static void main(String[] args) {
		long start=Calendar.getInstance().getTimeInMillis();
		for (int i = 3; i < 50000; i+=2) {
			if(prim(i)) {
				System.out.print(i+", ");
			}
		}
		long stop=Calendar.getInstance().getTimeInMillis();
		System.out.println("\n Futasi ido: "+(stop-start)+ " millis");
	}
	
	private static boolean prim(int szam) {
		boolean prim=true;
		int counter=3;
		double gyok=Math.sqrt(szam);
		while(prim && counter<=gyok) {
			if (szam%counter==0) {
				prim=false;
			}
			counter+=2;
		}
		return prim;
	}

}
