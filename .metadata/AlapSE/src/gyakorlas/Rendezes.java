package gyakorlas;

import java.util.Random;

public class Rendezes {

	public static void main(String[] args) {
		int [] array=arrayGenerator(100,10,20);
		printArray(array);
		array=sort(array);
		printArray(array);
		
	}

	private static int[] sort(int[] array) {
		
		for (int i=0;i<array.length; i++) {
			for (int j=0;j<array.length-1; j++) {
				if(array[j]>array[j+1]) {
					int csere=array[j];
					array[j]=array[j+1];
					array[j+1]=csere;
				}
			}
		}
		return array;
	}

	private static void printArray(int[] array) {
		//elj�r�s
		for (int i: array) {
			System.out.println(i+", ");
		}
		System.out.println();
	}

	private static int[] arrayGenerator(int limit, int from, int to) {
		Random rnd=new Random();
		int size=rnd.nextInt(to-from+1)+from;
		int[] array=new int [size];
		for (int i=0;i<array.length; i++) {
			array[i]=rnd.nextInt(limit)+1;
		}
		return array;
	}

}