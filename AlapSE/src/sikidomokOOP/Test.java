package sikidomokOOP;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Haromszog hrm=new Haromszog(1, 2, 3);
		System.out.println(hrm.getKerulet());
		Teglalap tgl = new Teglalap(1, 2);
		System.out.println(tgl.getKerulet());
		Sikidom idom = new Kor(5);
		((Kor)idom).testKor();// polimorf osztaly a sikidom
		idom.getTerulet();
		//((Teglalap)idom).getTerulet();//RunTimeError; armit lehet castolni a gyereke felé.
		//Haromszog hrmm= new Sikidom(); eltérõ attributumok 
			
	}
	
}
