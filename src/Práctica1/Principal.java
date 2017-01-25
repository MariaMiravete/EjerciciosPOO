package Práctica1;
import java.util.Scanner;
public class Principal {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner teclado =new Scanner(System.in);
			
		String dni, nombre, direccion;
		Persona persona1 =new Persona();
		persona1.escribe();
		
		System.out.print("Dame tu dni");
		dni=teclado.next();
		System.out.print("Dame tu nombre");
		nombre=teclado.next();
		System.out.print("Dame tu direccion");
		direccion=teclado.next();
		
		persona1.setDni(dni);
		persona1.setNombre(nombre);
		persona1.setDireccion(direccion);

		persona1.escribe();
	}

}
