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
		//könyvtár másolás, kiiras, gombokra mûveletek stb.
		//szotar program megírása, consolos, free szotar angol-magyar magyar-angol, (szinkronizált)hash table(linearis keresésnél  sok számra jobb)
		//ftp-zés
		

	}

}
