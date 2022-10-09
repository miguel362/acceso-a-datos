package ejercicio3Unidad1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;

public class LecturaYEscritura {

	public static void main(String[] args) {
		File ficheroOrigen; //fichero de donde voy a coger el texto
		File ficheroDestino; // fichero donde voy a copiar el texto anterior
		InputStream is;
		OutputStream os; 
		BufferedReader br;
		try {
			ficheroOrigen = new File("prueba.txt");
			ficheroDestino = new File("destino_de_prueba.txt");//Si no existe lo crea.
			is = new FileInputStream(ficheroOrigen);
			os = new FileOutputStream(ficheroDestino);
			int n=0;
			byte[] buffer = new byte[256];
			while(true) {//mientras haya texto...
				n = is.read(buffer);//guardo en n lo que leo
				if(n<0) {//si no hay nada el valor de n será -1, por lo que me salgo en ese caso
					break;
				}
					os.write(buffer,0,n);//escribo
					System.out.println("Proceso de escritura realizado correctamente.");
			}
			is.close();//cierro flujo
			System.out.println("\nFlujo de entrada cerrado correctamente.");
			os.close();//cierro otro
			System.out.println("\nFlujo de salida cerrado correctamente.");
			FileWriter escritura = new FileWriter(ficheroDestino.getAbsoluteFile(),true);//Me aseguro de que no se sobreescriba
			System.out.println("\nCreado fichero de escritura.\n");
			escritura.write("\nMiguel Navarro");//añado nombre y apellido
			System.out.println("Añadido Nombre y apellido.\n");
			escritura.close();//cierro
			System.out.println("Fichero cerrado correctamente.\n");
			System.out.println("Creo un buffer para imprimir por pantalla lo que hay en el fichero que le indico.\nA continuación se imprime lo que hay en el fichero.\n");
			br = new BufferedReader(new FileReader(ficheroDestino));//para ir leyendo el nuevo fichero
			String linea;//guardo aquí lo que lea
			while((linea = br.readLine())!=null) {//mientras haya una línea
				System.out.println(linea);//la imprimo
			}
			br.close();//cierro flujo
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Algún problema en uno de los pasos");
		}
	}
}