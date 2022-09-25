package ejercicio_voluntario_unidad_0;
import java.util.Scanner;
public class Alumnos {
	static Scanner s= new Scanner(System.in);
	public static void main(String[] args) {
		String[] nombres = new String[5];
		int[] edades = new int[5];
		System.out.println("---------------Datos de 5 alumnos------------");
		System.out.println("\nPresiona Enter para comenzar");
		for(int i=0;i<5;i++) {
			s.nextLine();
			System.out.print("\n¿Nombre del alumno " + (i+1) + "? ");
			nombres[i] = s.nextLine();
			System.out.print("\n¿Edad del alumno " + (i+1) + "? ");
			edades [i] = s.nextInt();
		}
		int edadMayor=edades[0];
		int edadMenor = edades[0];
		String nombreMayor=nombres[0];
		String nombreMenor=nombres[0];
		for(int j=0;j<edades.length;j++) {
			if(edades[j]>edadMayor) {
				edadMayor=edades[j];
				nombreMayor=nombres[j];
			}
			if(edades[j]<edadMenor) {
				edadMenor=edades[j];
				nombreMenor=nombres[j];
			}
		}
		System.out.println("\nEl alumno con más edad es " + nombreMayor + ", tiene " + edadMayor + " años.");
		System.out.println("\nEl alumno más joven es " + nombreMenor + ", tiene " + edadMenor + " años.");
		System.out.println(mediaEdad(edades));
	}
	public static String mediaEdad(int[] edades) {
		int suma=0;
		for(int i=0;i<edades.length;i++) {
			suma += edades[i];
		}
		if(suma%5 == 0) {
			return "\nLa media de edad de los alumnos indicados es de " + (suma/edades.length) + " años.";
		}else {
			double media = (double)suma/edades.length;
			return "\nLa media de edad de los alumnos indicados es de " + media + " años.";
		}
	}
}