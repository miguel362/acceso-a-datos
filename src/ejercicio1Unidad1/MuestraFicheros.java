package ejercicio1Unidad1;

import java.io.File;
import java.util.Scanner;

public class MuestraFicheros {

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		//Para imprimir los ficheros y/o directorios que hay en el directorio actual 
//		String sCarpAct = System.getProperty("user.dir");
//		File carpeta = new File(sCarpAct);
		File c = new File("C:");
		String[] listaDeC = c.list();

		if(listaDeC != null) {
			for(String s:listaDeC) {
				System.out.println(s);
			}
		}else {
			System.out.println("Sin datos en el listado");
		}

		System.out.print("\nDime un directorio del listado anterior: ");//pregunto por un directorio de los que hay en el directorio actual
		String directorio = s.nextLine();
		File direc = new File (directorio);//creo un objeto de tipo File con los datos introducidos por pantalla 
		if(!direc.exists()) {//si no existe
			System.out.println("\nEl directorio que me has pasado no existe.");
		}else {//si existe...
			String[] lista = direc.list();//meto lo que hay en el interior del directorio en un array
			if(lista != null) {
				System.out.println("\nListado de ficheros y directorios que hay en " + directorio + "\n");
				for(String n:lista) {//recorro el array y lo imprimo por pantalla
					System.out.println(n);
				}
				
				//Lo mismo que antes pero en vez de guardarlo en un array de Strings lo guardo en un array de Files.
				File[] fichYDir = direc.listFiles();
				System.out.println("\nListado de ficheros y directorios que hay en " + directorio + "\n");
				for(File f:fichYDir) {
					System.out.println(f);
				}
			}else {
				System.out.println("\nDirectorio vacío");
			}
		}
	}
}