package kivetelkezeles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class BillentyuzetOlvasas {

	public static void main(String[] args)/* throws IOException */{
		InputStreamReader isr= new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(isr);
		try {
			System.out.println("Kerem az eletkorod: ");
			String szoveg = br.readLine();
			System.out.println(szoveg);
			int szam = Integer.parseInt(szoveg);
			eletKorEllenoriz(szam);
			System.out.println(Calendar.getInstance().get(Calendar.YEAR)-szam + " �vben sz�letett.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("�letkor hiba");
			System.err.println(e.getMessage());
		}
	}

	private static void eletKorEllenoriz(int szam) throws Exception {
		if (szam<0 || szam>150) {
			throw new Exception("�letkor t�l alacsony vagy magas");
		}
		
	}

}
