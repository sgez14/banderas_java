import java.util.*;
import java.util.Arrays;
import java.util.Random;

public class Juego{
	public static void imprimirFila(String fila[])
	{
		for (int i=0;i<fila.length;i++) {
			
	 		if(fila[i].equals("1"))
	 		{
	 			System.out.print(ConsoleColors.RED_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("2"))
	 		{
	 			System.out.print(ConsoleColors.BLUE_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("3"))
	 		{
	 			System.out.print(ConsoleColors.WHITE_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("4"))
	 		{
	 			System.out.print(ConsoleColors.YELLOW_BACKGROUND+"  ");
	 		}		 		
		}
		System.out.println(ConsoleColors.RESET);
	}

	public static void imprimirGraficoBandera(String[] banderas, int indice)
	{
		for (int i=indice;i<indice+20;i++ ) {
			imprimirFila(banderas[i].split(";"));
		}
			
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
		Random indiceAleatorio = new Random();
		int indice_bandera;

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
				case 1: System.out.println();
						indice_bandera = indiceAleatorio.nextInt(indices.length);
						opcion_bandera = indice_bandera; 		   					
						imprimirGraficoBandera(banderas,indices[opcion_bandera]);																
			}		

		}while(centinela!=3);

	}
	public static void main(String args[]){
		juego();
	}
}