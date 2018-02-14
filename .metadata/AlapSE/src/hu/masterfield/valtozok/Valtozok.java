package hu.masterfield.valtozok;

public class Valtozok {

	public static void main(String[] args) {
		int num1=34;
		System.out.println(num1);
		num1=5/7;
		System.out.println(num1);
		System.out.println(Integer.MAX_VALUE);
		num1=2000000000+2000000000;
		System.out.println(num1);
		
		long bigNum1=1234567891011L;
		System.out.println(bigNum1);
		bigNum1=(long)2000000000+2000000000; //cast
		System.out.println(bigNum1);
		
		float decNum=6.5f;
		System.out.println(decNum);
		decNum=3/7F;
		System.out.println(decNum);
		double decNumLong=5/6.;
		System.out.println(decNumLong);
		
		char character='\'';
		System.out.println(character);
		
		boolean bool=true; //0 ill 1 nem lehet
				
	}

}
