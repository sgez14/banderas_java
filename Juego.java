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
	 		if(fila[i].equals("5"))
	 		{
	 			System.out.print(ConsoleColors.GREEN_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("6"))
	 		{
	 			System.out.print(ConsoleColors.PURPLE_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("7"))
	 		{
	 			System.out.print(ConsoleColors.CYAN_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("8"))
	 		{
	 			System.out.print(ConsoleColors.BLACK_BACKGROUND+"  ");
	 		}
	 		if(fila[i].equals("9"))
	 		{
	 			System.out.print(ConsoleColors.PURPLE_BACKGROUND+"  ");
	 		}	 		
		}
		System.out.println(ConsoleColors.RESET);
	}
	public static boolean juegoInformacionBandera(String[] banderas,int indice)
	{
		String fila[];
		String respuesta = ConsoleInput.getString();
		boolean prueba = false;
		for (int i=indice;i<indice+20;i++ ) {
			if(i == indice)
			{
				fila = banderas[i].split(";");
				fila[0].toString();
				
				respuesta.toLowerCase();
				if(respuesta.equalsIgnoreCase(fila[0]))
				{
					System.out.println(ConsoleColors.GREEN + "Muy bien");	
					prueba=true;				
					
				}else
				{
					System.out.println(ConsoleColors.RED + ":(");
					System.out.println("La respuesta correcta es: " + fila[0].toLowerCase());
					System.out.println(ConsoleColors.RESET);
				}	
			}
		}
		return prueba;				
	}
	public static void menuSaludos(int puntaje_juego)
	{
		if(puntaje_juego==1)
		{
			System.out.println(ConsoleColors.CYAN + "Primer punto");
		}
		else if(puntaje_juego==2)
		{
			System.out.println(ConsoleColors.CYAN + "Un punto mas!");
		}
		else if(puntaje_juego==3)
		{
			System.out.println(ConsoleColors.GREEN + "Eso es todo");
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
	public static void creditos()
	{
		System.out.println();
		System.out.println("  /$$$$$$                          /$$           ");
       	System.out.println(" /$$__  $$                        |__/           ");
       	System.out.println("| $$  \\__/  /$$$$$$  /$$$$$$/$$$$  /$$  /$$$$$$  ");
       	System.out.println("|  $$$$$$  |____  $$| $$_  $$_  $$| $$ /$$__  $$ ");
       	System.out.println(" \\____  $$  /$$$$$$$| $$ \\ $$ \\ $$| $$| $$  \\__/ ");
       	System.out.println(" /$$  \\ $$ /$$__  $$| $$ | $$ | $$| $$| $$       ");
       	System.out.println("|  $$$$$$/|  $$$$$$$| $$ | $$ | $$| $$| $$       ");
       	System.out.println(" \\______/  \\_______/|__/ |__/ |__/|__/|__/       ");
       	System.out.println("                                                 ");
	
	
       	System.out.println(" $$\\   $$\\                         $$\\                            ");
       	System.out.println(" $$ |  $$ |                        $$ |                           ");
       	System.out.println(" $$ |  $$ |$$\\   $$\\ $$$$$$\\$$$$\\  $$$$$$$\\   $$$$$$\\   $$$$$$\\   ");
       	System.out.println(" $$$$$$$$ |$$ |  $$ |$$  _$$  _$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\  ");
       	System.out.println(" $$  __$$ |$$ |  $$ |$$ / $$ / $$ |$$ |  $$ |$$$$$$$$ |$$ |  \\__| ");
       	System.out.println(" $$ |  $$ |$$ |  $$ |$$ | $$ | $$ |$$ |  $$ |$$   ____|$$ |       ");
       	System.out.println(" $$ |  $$ |\\$$$$$$  |$$ | $$ | $$ |$$$$$$$  |\\$$$$$$$\\ $$ |       ");
       	System.out.println(" \\__|  \\__| \\______/ \\__| \\__| \\__|\\_______/  \\_______|\\__|       ");
	}

	public static void juego()
	{
		boolean control;
		String respuesta;
		int puntaje_juego = 0, opcion_bandera = 0, centinela=0;
		boolean bandera = false;
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
						while(puntaje_juego!=3)
						{
							indice_bandera = indiceAleatorio.nextInt(indices.length);
							opcion_bandera = indice_bandera;
							for (int i=0;i<indices.length ;i++ )
							{
								if(i==indice_bandera)
								{
									System.out.println();
									System.out.println("Adivina la bandera :)");
									imprimirGraficoBandera(banderas,indices[opcion_bandera]);
									bandera=juegoInformacionBandera(banderas,indices[opcion_bandera]);
									if(bandera==true)
									{
										puntaje_juego++;
									}else
									{
										System.out.println("Adivina 3 banderas para ganar");
									}
									menuSaludos(puntaje_juego);																											
								}							
							}
							if(puntaje_juego==1)
							{
								System.out.println("Deseas seguir jugando hasta conseguir los 3 puntos?");
								System.out.println("1. Si");
								System.out.println("2. No");
								String pregunta_usuario = ConsoleInput.getString();
								if(pregunta_usuario.equalsIgnoreCase("No"))
								{
									break;
								}
								else
								{
									System.out.println();
								}
							}														
						}
						puntaje_juego=0;
						break;
						
				case 2: creditos();
       					break;
       			case 3: System.out.println("Adios :)");
       					break;
       			default: System.out.println("Opcion invalida");	  																										
			}			

		}while(centinela!=3);

	}
	public static void main(String args[]){
		juego();
	}
}