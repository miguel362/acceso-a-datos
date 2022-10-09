package ejercicio5Unidad1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//versión
	private String nombre;
	private String apellido;
	private int edad;
	private transient String dni;//le indico que al serializar no guarde el dato de este atributo con transient.
	
	//Constructor
	public Persona(String nombre,String apellido,int edad,String dni) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.edad=edad;
		this.dni=dni;
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	//toString
	@Override
	public String toString() {
		return "Nombre: " + getNombre() + "\nApellido: " + getApellido() + "\nEdad: " + getEdad() + "\nDni: " + getDni() + "\nVersión: " + getSerialversionuid();
	}

	public static void main(String[] args) {
		Persona p1 = new Persona("Josep","Navarro",6,"Desconocido");//Creo una persona
		Persona p2 = new Persona("Helena","Navarro",11,"44518546Z");//Creo otra
		Persona[] grupo = new Persona[2];//creo un array para guardar a las personas
		//guardo a las personas en el array
		grupo[0]=p1;
		grupo[1]=p2;
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("ejercicio4.dat")));//abro flujo de salida
			oos.writeObject(grupo);//guardo en el fichero indicado anteriormente
			oos.close();//Cierro el flujo
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("ejercicio4.dat")));//abro flujo de entrada
			Persona[] grupo_de_vuelta = (Persona[]) ois.readObject();//guardo en otro array el objeto leído
			ois.close();//Cierro el flujo
			for(Persona p: grupo_de_vuelta) {//por cada persona que haya en el array...
				System.out.println(p.toString() + "\n");//imprimo sus datos
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}