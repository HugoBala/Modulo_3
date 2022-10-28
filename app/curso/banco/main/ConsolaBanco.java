package app.curso.banco.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

import app.curso.banco.entidad.Cliente;
import app.curso.banco.entidad.Gestor;

public class ConsolaBanco {

	public static void main(String[] args) {
		
		
		HashMap<Integer, Gestor> gestores = new HashMap<>();
		HashMap<Integer, Cliente> clientes = new HashMap<>();
		
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		int opcion = 0;
		
		do {
			System.out.println("---" + "\n1. Ingresar un Gestor.");
			opcion = keyboard.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Genere una ID aceptable :");
				
				
				int id = keyboard.nextInt();
				
				Gestor GestorBuscado = gestores.get(id);
				
				
				while(GestorBuscado != null) {
					System.out.println("El Id ya existe, ingrese otro por favor");
					id = keyboard.nextInt();
					GestorBuscado = gestores.get(id);
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
								
				String [] nombres = {"Hugo", "Sergio", "Juan", "Pedro", "Marcos", "María", "Amparo", "Carla", "Silvia", "Rodolfo"};
				String [] apellidos = {"García", "Sanchez", "Cózar", "Balaguer", "Catalá", "Cobacho", "Cuenca", "Rodríguez", "Velasco", "Hervás"};
				
				System.out.println("Ingrese el numero de gestores que desee añadir: ");
				int numGestores = keyboard.nextInt();
				
				for(int i = 0; i < numGestores; i++) {
					int index = random.nextInt(nombres.length);
					int idS = random.nextInt(1000);
					int idOfice = random.nextInt(100);
					String nombreAleatorio = nombres[index];
					String apellidoAleatorio = apellidos[index];
					
					Gestor GestorBuscado2 = gestores.get(idS);
					
					if(GestorBuscado2 != null) {
						
						while(GestorBuscado2 != null) {
							
							idS = random.nextInt(1000);
							Gestor g = new Gestor(idS,nombreAleatorio+' '+apellidoAleatorio, null, idOfice);
							
							gestores.put(idS, g);
							GestorBuscado2 = gestores.get(idS);
						}
					}else {
						
						Gestor g = new Gestor(idS,nombreAleatorio+' '+apellidoAleatorio, null, idOfice);
						
						gestores.put(idS, g);
						
					}
							
				}
				System.out.println("Se han generado aleatoriamente " + numGestores + " gestores correctamente");
				

			break;
			
			case 3:
				System.out.println("Indique el id del gestor: ");
				
				gestores.forEach((idx, Gestor) -> {
					
					int idBuscado = keyboard.nextInt();

					if (idBuscado == idx) {
						Gestor.mostrarInfo();
					}else {
						System.out.println("Este gestor no existe");
					}	
				});
				
				
			break;
			
			case 4:
				gestores.forEach((idx, Gestor) -> {
					System.out.println("\nGestor: \n");
					Gestor.mostrarInfo();
				});
			break;
				}	
			}while (opcion != 0);
		
		 
	}
	
	
}
