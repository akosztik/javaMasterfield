package kivetelkezeles;

public class AlapEset {

	public static void main(String[] args) {
		int szam=0;
		try {
			int[] tomb = {1,2};
			System.out.println(tomb[2]);
			System.out.println(5/szam);
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("tomb tulindexeles");
		}catch(ArithmeticException e) {
			System.out.println("null�val oszt�s");
		}catch(Exception e){
		
			//�ltalanos �g
			System.out.println("hibat�rt�nt");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();// p�rhuzamosan fut stacktrace, a program fut tov�bb ez�rt nem pontosan tt jelenik meg a consolon ahol el�fordult
		}

		System.out.println("program vege");
	}

}