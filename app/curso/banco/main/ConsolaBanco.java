package app.curso.banco.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

import app.curso.banco.entidad.Cliente;
import app.curso.banco.entidad.Gestor;
import app.curso.banco.util.utiles;

public class ConsolaBanco {

	public static void main(String[] args) {
		
		
		HashMap<Integer, Gestor> gestores = new HashMap<>();
		HashMap<Integer, Cliente> clientes = new HashMap<>();
		
		String[] nombres = utiles.NOMBRES;
		String[] apellidos = utiles.APELLIDOS;
		
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		int opcion = 0;
		
		do {
			
			for(int i = 0; i<18; i++) {	
				System.out.println(utiles.MENU[i]);
			}
			
						
			opcion = keyboard.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Genere una ID aceptable :");
				
				
				int id = keyboard.nextInt();
				
				Gestor gestorExiste = utiles.buscarGestor(id, gestores);
				
				while(gestorExiste!= null) {
					System.out.println("El Id ya existe, ingrese otro por favor");
					id = keyboard.nextInt();
					gestorExiste = utiles.buscarGestor(id, gestores);
				}

			
				System.out.println("Genere una ID de oficina aceptable :");
				int idOficina = keyboard.nextInt();
				System.out.println("Estableza el nombre del Gestor :");
				String nombre = keyboard.next();
				System.out.println("Estableza el telefono del Gestor :");
				String telefono = keyboard.next();
				
				
				Gestor g1 = new Gestor(id, nombre, telefono, idOficina);
				gestores.put(id, g1);
				System.out.println("Gestor ingresado correctamente.");
				
			break;
			
			case 2:
								
				
				System.out.println("Ingrese el numero de gestores que desee añadir: ");
				int numGestores = keyboard.nextInt();
				
				for(int i = 0; i < numGestores; i++) {
					
					int index = random.nextInt(nombres.length);
					int idS = random.nextInt(1000);
					int idOfice = random.nextInt(100);
					String nombreAleatorio = nombres[index];
					String apellidoAleatorio = apellidos[index];
					
					Gestor gestorExiste2 = utiles.buscarGestor(idS, gestores);
					
					if(gestorExiste2 != null) {
						
						while(gestorExiste2 != null) {
							
							idS = random.nextInt(1000);
							Gestor g = new Gestor(idS,nombreAleatorio+' '+apellidoAleatorio, null, idOfice);						
							gestores.put(idS, g);
							gestorExiste2 = utiles.buscarGestor(idS, gestores);
						}
					}else {
		
						Gestor g = new Gestor(idS,nombreAleatorio+' '+apellidoAleatorio, null, idOfice);
						gestores.put(idS, g);
					}
							
				}
				System.out.println("Se han generado aleatoriamente " + numGestores + " gestores correctamente\n");
				

			break;
			
			case 3:
				System.out.println("Indique el id del gestor: ");
				int idBuscado = keyboard.nextInt();
				
				
				Gestor gestorBuscado3 = utiles.buscarGestor(idBuscado, gestores);
					

				while (gestorBuscado3 == null) {
					System.out.println("Este gestor no existe, por favor indique otro.");
					idBuscado = keyboard.nextInt();
					
					gestorBuscado3 = utiles.buscarGestor(idBuscado, gestores);
				}
				
				gestorBuscado3.mostrarInfo();
				
				
				
				
			break;
			
			case 4:
				gestores.forEach((idx, Gestor) -> {
					System.out.println("\nGestor: \n");
					Gestor.mostrarInfo();
				});
			break;
			
			case 5:
		
			break;
				
			case 6:
				System.out.println("Indique el id del gestor que quiera eliminar: ");
				int idEliminar = keyboard.nextInt();
				
				Gestor gestorBuscado4 = utiles.buscarGestor(idEliminar, gestores);
					

				while (gestorBuscado4 == null) {
					System.out.println("Este gestor no existe, por favor indique otro.");
					idEliminar = keyboard.nextInt();
					
					gestorBuscado4 = utiles.buscarGestor(idEliminar, gestores);
				}
				
				gestores.remove(idEliminar);
				System.out.println("Gestor eliminado correctamente");

			break;
				}	
			}while (opcion != 0);
		
		 
	}
	
	
}
