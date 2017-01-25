package Arrays;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner teclado =new Scanner(System.in);

		float media,numerosmedia;
		int n, desde, hasta;		
		media=0;

		System.out.print("Escribe un valor");
		n=teclado.nextInt();
		System.out.print("Escribe un valor");
		desde=teclado.nextInt();
		System.out.print("Escribe un valor");
		hasta=teclado.nextInt();

		Vector v;
		v=new Vector(n, desde, hasta);


		media=v.media();
		System.out.println("La media es:  " + media);

		v.numerosmedia();


	}

}
