package app.curso.banco.main;

import java.util.HashMap;
import java.util.Scanner;

import app.curso.banco.entidad.Cliente;
import app.curso.banco.entidad.Gestor;

public class ConsolaBanco {

	public static void main(String[] args) {
		
		HashMap<Integer, Gestor> gestores = new HashMap<>();
		HashMap<Integer, Cliente> clientes = new HashMap<>();
		
		Scanner keyboard = new Scanner(System.in);
		int opcion = keyboard.nextInt();
		
		do {
			System.out.println("---" + "\n1. Ingresar un Gestor.");
			opcion = keyboard.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Genere una ID aceptable :");
				int id = keyboard.nextInt();
				System.out.println("Genere una ID de oficina aceptable :");
				int idOficina = keyboard.nextInt();
				System.out.println("Estableza el nombre del Gestor :");
				String nombre = keyboard.next();
				System.out.println("Estableza el telefono del Gestor :");
				String telefono = keyboard.next();
				Gestor g1 = new Gestor(id, nombre, telefono, idOficina);
				System.out.println("Gestor ingresado correctamente.");
				break;
				}	
			}while (opcion != 0);
	}
}
