package mappa;

import java.io.*;

public class MappaListazo {

	public static void main(String[] args) {
		File file= new File(".");
		String[] mappaList=file.list();
		for (int i = 0; i < mappaList.length; i++) {
			System.out.print(mappaList[i]);
			File temp= new File(file, mappaList[i]);
			if (temp.isDirectory()) {
				System.out.println("  directory");
			}
			if (temp.isFile()) {
				System.out.println("  file");
			}
		}
		File tmp= new File(file,"NewDirectory");
		if (!tmp.isDirectory() && !tmp.isFile()) {
			tmp.mkdir();
		}
		//k�nyvt�r m�sol�s, kiiras, gombokra m�veletek stb.
		//szotar program meg�r�sa, consolos, free szotar angol-magyar magyar-angol, (szinkroniz�lt)hash table(linearis keres�sn�l  sok sz�mra jobb)
		//ftp-z�s
		

	}

}
