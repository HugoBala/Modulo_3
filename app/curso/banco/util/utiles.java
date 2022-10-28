package app.curso.banco.util;

import java.util.HashMap;
import java.util.Scanner;

import app.curso.banco.entidad.Gestor;

public class utiles{
	
	
	
	public static final String [] NOMBRES = {"Hugo", "Sergio", "Juan", "Pedro", "Marcos", "María", "Amparo", "Carla", "Silvia", "Rodolfo"};
	public static final String [] APELLIDOS = {"García", "Sanchez", "Cózar", "Balaguer", "Catalá", "Cobacho", "Cuenca", "Rodríguez", "Velasco", "Hervás"};
	
	
	public static final String [] MENU = {
			"---------------------------------------------------------",
			"1. Inserción de un gestor.",
			"2. Inserción masiva de gestores con datos aleatorios.",
			"3. Obtención de un gestor.",
			"4. Obtención de todos los gestores.",
			"5. Actualización de un gestor.",
			"6. Eliminación de un gestor.",
			"7. Inserción de un cliente.",
			"8. Obtención de un cliente.",
			"9. Obtención de todos los clientes.",
			"10. Actualización de un cliente.",
			"11. Eliminación de un cliente.",
			"12. Obtención de un mensaje.",
			"13. Obtención de todos los mensajes.",
			"14. Envío de un mensaje.",
			"15. Obtención de una transferencia.",
			"16. Obtención de todas las trasferencias",
			"17. Envío de una transferencia.",
			"18. Login y registro."
	};
	


	
	public static Gestor buscarGestor(int idBuscado, HashMap<Integer, Gestor> gestores) {
		
		Gestor GestorBuscado = gestores.get(idBuscado);
		
		
		return GestorBuscado;

	}




}
