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
	public static int subMenuSeleccionBandera(int[] indices)
	{
		int opc = 0;

		do{
			System.out.println("Ingrese un valor entre 1 y "+indices.length);
			opc = ConsoleInput.getInt();
		}while(opc<0 || opc==0 || opc>indices.length);

		return opc-1;
	}
	public static int randomBandera(int[] indices)
	{
		int aleatorio = (int)Math.random()*indices.length;

		return aleatorio;
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
						opcion_bandera = randomBandera(); 		   					//selecciona un indice
						imprimirGraficoBandera(banderas,indices[opcion_bandera]);	//Imprime el indice que está en opcion_bander																
			}		

		}while(centinela!=3);

	}
	public static void main(String args[]){
		juego();
	}
}