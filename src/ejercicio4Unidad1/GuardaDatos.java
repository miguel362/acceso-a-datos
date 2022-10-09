package ejercicio4Unidad1;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class GuardaDatos {

	public static void main(String[] args) throws IOException {
		//Creo los flujos
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("ejercicio.txt"));
		DataInputStream dis = new DataInputStream(new FileInputStream("ejercicio.txt"));
		
		//Creo variables de distintos tipos de datos
		Boolean verdad = true;
		int numero = 1;
		float bajito = 0.9f;
		double decimal = 15.89;
		char letra = 'a';
		String nombre = "Nuria";
		Byte bit = 01;
		
		//Introduzco los datos en el fichero
		dos.writeBoolean(verdad);//Booleano
		dos.write(numero);//entero
		dos.writeFloat(bajito);//float
		dos.writeDouble(decimal);//double
		dos.writeChar(letra);//char
		dos.writeUTF(nombre);//String
		dos.writeByte(bit);//byte
		
		dos.close();//Cierro el flujo
		
		//Los leo y los imprimo por pantalla
		System.out.println(dis.readBoolean());
		System.out.println(dis.read());
		System.out.println(dis.readFloat());
		System.out.println(dis.readDouble());
		System.out.println(dis.readChar());
		System.out.println(dis.readUTF());
		System.out.println(dis.readByte());
		
		dis.close();//Cierro el flujo
	}
}