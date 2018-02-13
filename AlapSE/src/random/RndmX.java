package random;

import java.util.Random;

public class RndmX extends Random {

	@Override
	public int nextInt(int arg0) {
		// TODO Auto-generated method stub
		return super.nextInt(arg0)+1;
	}
	public int nextIntervall(int from, int to) {
		return super.nextInt(to-from+1)+from;
	}
	
}
