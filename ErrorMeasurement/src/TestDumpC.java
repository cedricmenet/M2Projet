import java.io.File;

import dump.DumpC;

public class TestDumpC {
	 
	public static void main(String[] args) {
    	// Créer un objet dump
		DumpC fileC = new DumpC("myProg.c",new File("programmeC"));
    	
		// Appel la fonction qui ecrit le fichier initialement
		fileC.DumpInitFileC();	
		
		// Ajoute de ligne dans le fichier
		fileC.addNextLine("Fred");
		fileC.addNextLine("Gaellic");
		fileC.addNextLine("Pour le fun");
    }
	 
}
