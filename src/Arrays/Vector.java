package Arrays;

public class Vector {

	private int v[];

	public Vector (int n){
		v =new int [n];
	}

	public Vector (int n, int m){
		v=new int [n];
		for (int i=0; i<n;i++)
			v[i]=m;

	}
	public Vector (int n, int desde, int hasta){
		v=new int [n];
		for (int i=0; i<n;i++)
			v[i]= (int)(Math.random()*(hasta-desde+1)+desde);

	}


	public float media() {
		float media=0;
		for( int i=0; i<v.length; i++ ) 
			media += v[i]; 
		media = media / v.length;

		return media;

	}

	public void numerosmedia() {

		float media;
		int mediamayor, mediamenor , mediaigual;
		boolean llave =false;
		media=media();

		System.out.print("Los números mayor a la media: " );
		for (int i=0; i<v.length; i++){
			if (v[i] > media){

				mediamayor= v[i];
				System.out.print(" " + mediamayor);	

			}
		}

		System.out.print("\nLos números menor a la media: ");
		for (int i=0; i<v.length; i++){
			if (v[i] <media){
				mediamenor= v[i];
				System.out.print(" " + mediamenor);
			}
		}

		for (int i=0; i<v.length; i++){
			if ((float)v[i] == media){
				llave=true;
			}
		}
		if (llave){
			System.out.print("\nLos números igual a la media: ");
			for (int i=0; i<v.length; i++){
				if ((float)v[i] == media){
					mediaigual= v[i];
					System.out.print(" " + mediaigual);
				}

			}
		}	
		else
			System.out.print("\nNo hay números iguales a la media ");

	}


}






