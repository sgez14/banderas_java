import java.util.*
import java.util.Arrays;

public class Juego{
	public static int[] desordenarArreglo(int[] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	public static void imprimirGraficoBandera(String[] banderas, int indice)
	{
		for (int i=indice;i<indice+20;i++ ) {
			imprimirFila(banderas[i].split(";"));
		}
			
	}
	public static int subMenuSeleccionBandera(int[] indices)
	{
		int opc = 0;

		do{
			System.out.println("Ingrese un valor entre 1 y "+indices.length);
			opc = ConsoleInput.getInt();
		}while(opc<0 || opc==0 || opc>indices.length);

		return opc-1;
	}
	public static int[] crearIndices(int total)
	{
		int indices[] = new int[total];
		int contador = 0;
		for (int i=0;i<indices.length;i++) {
			indices[i] = contador;
			contador+=20;		
		}
		return indices;
	}
	public static void juego()
	{
		int puntaje = 0, opcion_bandera = 0, centinela=0;
		String banderas[] = ConsoleFile.read("recursos/info_banderas.csv");
		int indices[] = crearIndices(banderas.length/20);
		indices = desordenarArreglo(indices);
		do
		{
			System.out.println();
			System.out.println("Ingrese una opcion: ");
			System.out.println("1. Jugar");
			System.out.println("2. Ver creditos");
			System.out.println("3. Salir");
			centinela = ConsoleInput.getInt();
			switch(centinela)
			{
				
			}		

		}while(centinela!=3);

	}
}