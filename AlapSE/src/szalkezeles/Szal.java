package szalkezeles;

import random.RndmX;

public class Szal extends Thread{
	private String szoveg;

	public Szal(String szoveg) {
		this.szoveg = szoveg;
		start();
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 20; i++) {
			System.out.println(szoveg);
			try {
				this.sleep(new RndmX().nextInt(2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
