package Práctica2;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner teclado =new Scanner(System.in);	
		
		int anio0, anio1, mes0, mes1, dia0, dia1, diferencia;
		Fecha fecha1, fecha2;
		
		
		do{
			System.out.print("Escribe un año");
			anio1=teclado.nextInt();
			System.out.print("Escribe un mes");
			mes1=teclado.nextInt();
			System.out.print("Escribe un dia");
			dia1=teclado.nextInt();
			System.out.print("Escribe un año");
			anio0=teclado.nextInt();
			System.out.print("Escribe un mes");
			mes0=teclado.nextInt();
			System.out.print("Escribe un dia");
			dia0=teclado.nextInt();
			fecha1 =new Fecha(anio0, mes0, dia0);
			fecha2 =new Fecha(anio1, mes1, dia1);
		}while (fecha1.getAnio()==0 && fecha1.getMes()==0 && fecha1.getDia()==0);
		diferencia =fecha1.diferencia(fecha2);
	
		
		System.out.println("dias de diferencia= " + diferencia);
		
		
		


	}

}
// 