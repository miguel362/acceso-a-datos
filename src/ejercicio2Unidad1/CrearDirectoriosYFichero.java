package ejercicio2Unidad1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CrearDirectoriosYFichero {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("\nDime el nombre para el directorio principal donde ir guardando los 3 directorios: ");
		String directorio = s.nextLine();
		String ruta = directorio + "\\PrimerDirectorio\\SegundoDirectorio\\TercerDirectorio";//añado los directorios internos que quiero crear.
		File direc = new File (ruta);//creo un objeto de tipo File con la ruta
		if(!direc.exists()) {//si no existe
			if(direc.mkdirs()) {
				String rutaFichero = ruta + "\\MiFichero.txt";
				File archivo = new File(rutaFichero);
				try {
					if(archivo.createNewFile()) {
						System.out.println("\nDirectorios y archivo creados.");
						System.out.println("\nRuta absoluta del archivo MiFichero.txt: " + archivo.getAbsolutePath());
						System.out.println("\nRuta relativa del mismo archivo: " + archivo.getPath());
					}
				} catch (IOException e) {
					System.out.println("\nDirectorios creados, no se ha podido crear el archivo.");
				}
			}else {
				System.out.println("\nError al crear los directorios.");
			}
		}else {
			System.out.println("\nDirectorios ya existentes.");
		}
	}
}