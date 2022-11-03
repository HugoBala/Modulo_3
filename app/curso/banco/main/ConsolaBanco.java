package app.curso.banco.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

import app.curso.banco.entidad.*;

import app.curso.banco.util.utiles;

public class ConsolaBanco {
	
	
	static HashMap<Integer, Gestor> gestores = new HashMap<>();
	static HashMap<Integer, Cliente> clientes = new HashMap<>();
	static HashMap<Integer, Mensaje> mensajes = new HashMap<>();
	static HashMap<Integer, Transferencia> transferencias = new HashMap<>();

	public static void main(String[] args) {
		
		
		String[] nombres = utiles.NOMBRES;
		String[] apellidos = utiles.APELLIDOS;
		
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		int opcion = 0;
		
		do {
			
			for(int i = 0; i<20; i++) {	
				System.out.println(utiles.MENU[i]);
			}
			
						
			opcion = keyboard.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("Inserción de un Gestor.\n");
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
				
				if(gestores.isEmpty()) {
					System.out.println("No hay ningún gestor todavía");
					break;
				}
				gestores.forEach((idx, Gestor) -> {
					System.out.println("\nGestor: \n");
					Gestor.mostrarInfo();
				});
			break;
			
			case 5:
				System.out.println("Indique el id del gestor que quiera actualizar: ");
				int idActualizar = keyboard.nextInt();
				Gestor gestorBuscado4 = utiles.buscarGestor(idActualizar, gestores);
				
				while (gestorBuscado4 == null) {
					System.out.println("Este gestor no existe, por favor indique otro.");
					idActualizar = keyboard.nextInt();
					
					gestorBuscado4 = utiles.buscarGestor(idActualizar, gestores);
				}
				
				

				System.out.println("Escriba el nuevo ID de Oficina o pulse 001 para continuar :");
							
				int newIdOficina = keyboard.nextInt();
				
				if(newIdOficina == 001) {
					newIdOficina = gestorBuscado4.getIdOficina();
				}
				
				System.out.println("Escriba el nuevo nombre (Sin el Apellido) del gestor o pulse X para continuar :");
				String newNombre = keyboard.next();
				
				if(newNombre.equals("X")) {
					newNombre = gestorBuscado4.getName();
				}else {
					
					System.out.println("Escriba el nuevo apellido (Sin el Nombre) del gestor: ");
					String newApellido = keyboard.next();
					
					newNombre = newNombre+' '+newApellido;
				}
				
				
				
				System.out.println("Estableza el nuevo telefono del Gestor o pulse X para continuar :");
				String newTelefono = keyboard.next();
				
				if(newTelefono.equals("X")) {
					newTelefono = gestorBuscado4.getPhone();
				}
				
				gestorBuscado4 = new Gestor(gestorBuscado4.getId(), newNombre, newTelefono, newIdOficina);
				
				gestores.replace(idActualizar, gestorBuscado4);
				
				System.out.println("Has actualizado el Gestor con éxito");
		
			break;
				
			case 6:
				System.out.println("Indique el id del gestor que quiera eliminar: ");
				int idEliminar = keyboard.nextInt();
				
				Gestor gestorBuscado5 = utiles.buscarGestor(idEliminar, gestores);
					

				while (gestorBuscado5 == null) {
					System.out.println("Este gestor no existe, por favor indique otro.");
					idEliminar = keyboard.nextInt();
					
					gestorBuscado5 = utiles.buscarGestor(idEliminar, gestores);
				}
				
				gestores.remove(idEliminar);
				System.out.println("Gestor eliminado correctamente");

			break;
			
			case 7:
				System.out.println("Inserción de un Cliente.\n");
				System.out.println("Genere una ID aceptable :");
				
				
				int idCliente = keyboard.nextInt();
				
				Cliente clienteExiste = utiles.buscarCliente(idCliente, clientes);
				
				while(clienteExiste!= null) {
					System.out.println("El Id ya existe, ingrese otro por favor");
					idCliente = keyboard.nextInt();
					clienteExiste = utiles.buscarCliente(idCliente, clientes);
				}

				System.out.println("Estableza el nombre del Cliente: ");
				String nombreCliente = keyboard.next();
				System.out.println("Estableza el telefono del Cliente: ");
				String telefonoCliente = keyboard.next();
				System.out.println("Estableza la cantidad del dinero total:");
				int dineroTotal = keyboard.nextInt();
				
				
				Cliente c1 = new Cliente(idCliente, nombreCliente, telefonoCliente, dineroTotal);
				clientes.put(idCliente, c1);
				System.out.println("Cliente ingresado correctamente.");
				
				
			break;
			
			case 8:
				
				System.out.println("Indique el id del cliente: ");
				int idClienteBuscado = keyboard.nextInt();
				
				
				Cliente clienteBuscado = utiles.buscarCliente(idClienteBuscado, clientes);
					

				while (clienteBuscado == null) {
					System.out.println("Este cliente no existe, por favor indique otro.");
					idClienteBuscado = keyboard.nextInt();
					
					clienteBuscado = utiles.buscarCliente(idClienteBuscado, clientes);
				}
				
				System.out.println("Información del cliente buscado: \n");
				clienteBuscado.mostrarInfo();
				
				
			break;
			
			case 9:
				
				if(clientes.isEmpty()) {
					System.out.println("No hay ningún cliente todavía");
					break;
				}
				
				clientes.forEach((idx, Cliente) -> {
					System.out.println("\nCliente: \n");
					Cliente.mostrarInfo();
				});
				
			break;
			
			case 10:
				
				System.out.println("Indique el id del cliente que quiera actualizar: ");
				int idClienteActualizar = keyboard.nextInt();
				Cliente clienteBuscado2 = utiles.buscarCliente(idClienteActualizar, clientes);
				
				while (clienteBuscado2 == null) {
					System.out.println("Este cliente no existe, por favor indique otro.");
					idClienteActualizar = keyboard.nextInt();
					
					clienteBuscado2 = utiles.buscarCliente(idClienteActualizar, clientes);
				}
				
				
				System.out.println("Escriba el nuevo nombre (Sin el Apellido) del cliente o pulse X para continuar :");
				String newNombreCliente = keyboard.next();
				
				if(newNombreCliente.equals("X") ) {
					System.out.println("entra");
					newNombreCliente = clienteBuscado2.getName();
				}
								
				System.out.println("Estableza el nuevo telefono del cliente o pulse X para continuar :");
				String newTelefonoCliente = keyboard.next();
				
				if(newTelefonoCliente.equals("X")) {
					newTelefonoCliente = clienteBuscado2.getPhone();
				}
				
				System.out.println("Establezcla la cantidad total de dinero del cliente o pulse 001 para continuar: \n");
				float newCantidadDineroTotal = keyboard.nextInt();
				
				if(newCantidadDineroTotal == 001) {
					newCantidadDineroTotal = clienteBuscado2.getTotalDinero();
				}
				
				clienteBuscado2 = new Cliente(clienteBuscado2.getId(), newNombreCliente, newTelefonoCliente, newCantidadDineroTotal);
				
				clientes.replace(idClienteActualizar, clienteBuscado2);
				
				System.out.println("Has actualizado el cliente con éxito \n");
				
			break;
			
			case 11:
				
				System.out.println("Indique el id del cliente que quiera eliminar: ");
				int idClienteEliminar = keyboard.nextInt();
				
				Cliente clienteBuscado3 = utiles.buscarCliente(idClienteEliminar, clientes);
					

				while (clienteBuscado3 == null) {
					System.out.println("Este cliente no existe, por favor indique otro.");
					idClienteEliminar = keyboard.nextInt();
					
					clienteBuscado3 = utiles.buscarCliente(idClienteEliminar, clientes);
				}
				
				clientes.remove(idClienteEliminar);
				System.out.println("Cliente eliminado correctamente\n");
				
			break;
			
			case 12:	
				
				System.out.println("Indique el id del mensaje a buscar: ");
				int idMensajeBuscado = keyboard.nextInt();
				
				
				Mensaje mensajeBuscado12 = utiles.buscarMensaje(idMensajeBuscado, mensajes);
					

				while (mensajeBuscado12 == null) {
					System.out.println("Este mensaje no existe, por favor indique otro.");
					idMensajeBuscado = keyboard.nextInt();
					
					mensajeBuscado12 = utiles.buscarMensaje(idMensajeBuscado, mensajes);
				}
				
				System.out.println(mensajeBuscado12.toString());
			break;
			
			case 13:
				
				if(mensajes.isEmpty()) {
					System.out.println("No hay ningún mensaje todavía");
					break;
				}
				
				mensajes.forEach((idx, Mensaje) -> {
					System.out.println("\nMensaje: \n");
					System.out.println(Mensaje.toString());
				});
				
			break;
				
			case 14:
				
				System.out.println("Envío de un mensaje.\n\n");
				
				System.out.println("Establezca el id de mensaje: ");
				int idMensaje = keyboard.nextInt();
				
				Mensaje mensajeExiste= utiles.buscarMensaje(idMensaje, mensajes);
				
				while(mensajeExiste!= null) {
					System.out.println("El Id ya existe, ingrese otro por favor");
					idMensaje = keyboard.nextInt();
					mensajeExiste= utiles.buscarMensaje(idMensaje, mensajes);
				}
				
				
				HashMap<String, Object> propiedades = crearMsg();
				
				char tipoEmisor = ((String) propiedades.get("tipoEmisor")).charAt(0);
				int idEmisor = (int)propiedades.get("idEmisor");
				char tipoReceptor = ((String)propiedades.get("tipoReceptor")).charAt(0);
				int idReceptor = (int)propiedades.get("idReceptor");
				String textoMensaje = propiedades.get("textoMensaje").toString();
				
				Mensaje m1 = new Mensaje(idMensaje, tipoEmisor, idEmisor, tipoReceptor, idReceptor, textoMensaje);
				mensajes.put(idMensaje, m1);
				
				System.out.println("Mensaje creado correctamente\n");
				
			break;
				
			case 15:
				
				System.out.println("Indique el id de la transferencia a buscar: ");
				int idTransferenciaBuscada = keyboard.nextInt();
				
				
				Transferencia transferenciaBuscada = utiles.buscarTransferencia(idTransferenciaBuscada, transferencias);
					

				while (transferenciaBuscada == null) {
					System.out.println("No existe una transferencia con ese id, pruebe con otra.");
					idTransferenciaBuscada = keyboard.nextInt();
					
					transferenciaBuscada = utiles.buscarTransferencia(idTransferenciaBuscada, transferencias);
				}
				
				System.out.println(transferenciaBuscada.toString());
			break;
				
			case 16:
				
				if(transferencias.isEmpty()) {
					System.out.println("No hay ningúna transferencia todavía");
					break;
				}
				
				transferencias.forEach((idx, Transferencia) -> {
					System.out.println("\nTransferencia: \n");
					System.out.println(Transferencia.toString());
				});
				
			break;
				
			case 17:
				

				System.out.println("Establezca el id de la transferencia: ");
				int idMensajeTransfer = keyboard.nextInt();
				
				Transferencia transferExiste = utiles.buscarTransferencia(idMensajeTransfer, transferencias);
				
				while(transferExiste!= null) {
					System.out.println("El Id ya existe, ingrese otro por favor");
					idMensajeTransfer = keyboard.nextInt();
					transferExiste= utiles.buscarTransferencia(idMensajeTransfer, transferencias);
				}
				
				HashMap<String, Object> propiedadesTransfer = crearMsg();
				
				System.out.println("Ingrese la cantidad de dinero a transferir");
				int dinero = keyboard.nextInt();
				
				Object tipoEmisor2 = propiedadesTransfer.get("tipoEmisor");
				int idEmisor2 = (int)propiedadesTransfer.get("idEmisor");
				Object tipoReceptor2 = propiedadesTransfer.get("tipoReceptor");
				int idReceptor2 = (int)propiedadesTransfer.get("idReceptor");
				String textoMensaje2 = propiedadesTransfer.get("textoMensaje").toString();
				
				Transferencia t1 = new Transferencia(idMensajeTransfer, ((String)tipoEmisor2).charAt(0), idEmisor2, ((String)tipoReceptor2).charAt(0), idReceptor2, textoMensaje2, dinero);
				if(tipoReceptor2.equals("c")) {
					Cliente clienteTransferencia = utiles.buscarCliente((int)idReceptor2, clientes);
					clienteTransferencia.ingresarDinero(dinero);
				}
				if(tipoEmisor2.equals("c")) {
					Cliente clienteTransferencia = utiles.buscarCliente((int)idEmisor2, clientes);
					clienteTransferencia.retirarDinero(dinero);
				}
				transferencias.put(idMensajeTransfer, t1);
				
				System.out.println("Transferencia realizada correctamente\n");
				
			break;
				
			case 18:
				
				System.out.println("Registro de Cliente");
				
				System.out.println("Ingrese el id del cliente existente para crear una cuenta");
				
				int idClienteRegistro = keyboard.nextInt();
				
				Cliente clienteBuscadoRegistro = utiles.buscarCliente(idClienteRegistro, clientes);
				
				while(clienteBuscadoRegistro == null) {
					System.out.println("El cliente con id " + idClienteRegistro + " no existe, pruebe de nuevo");
					 idClienteRegistro = keyboard.nextInt();
					 clienteBuscadoRegistro = utiles.buscarCliente(idClienteRegistro, clientes);
				}
				
				System.out.println("Cree una Contraseña: ");
				String pass = keyboard.next();
				
				clienteBuscadoRegistro.setPassword(pass);
				
				clientes.put(idClienteRegistro, clienteBuscadoRegistro);
				System.out.println("Usuario creado correctamente.\n");
				
				break;
				
			case 19:
				
				
				System.out.println("Ingrese el id del cliente para LOGIN");
				
				int idClienteLogin = keyboard.nextInt();
				
				Cliente clienteBuscadoLogin = utiles.buscarCliente(idClienteLogin, clientes);
				
				
				System.out.println("Ingrese la Contraseña: ");
				String pass2 = keyboard.next();
				
				if(clienteBuscadoLogin == null) {
					System.out.println("No existe ningún usuario con ese id");
					break;
				}
				
				boolean tienePass = clienteBuscadoLogin.getPassword() != null;
				
				if(tienePass == false) {
					System.out.println("El usuario con id " + clienteBuscadoLogin.getId() + " no está registrado");
					break;
				}
				
				boolean loginCorrecto = clienteBuscadoLogin.getPassword().equals(pass2);
								
				if(loginCorrecto) {
					System.out.println("Login correcto");
				}else {					
					System.out.println("Login incorrecto");
				}
				
			break;
			case 20:
				keyboard.close();
			default:
			System.out.println("ERROR: Debes pulsar un número entre el 1 y el 19.");
				}	
			}while (opcion != 0);		 
	}
	
	
	
	private static HashMap<String, Object> crearMsg() {
		
		Scanner keyboard = new Scanner(System.in);
		
		HashMap<String, Object> propiedades = new HashMap<>();
		
		System.out.println("Escriba el mensaje asociado a la transferencia: ");
		String textoMensaje = keyboard.nextLine();
		propiedades.put("textoMensaje", textoMensaje);	
		
		
			
						
		System.out.println("Establezca el tipo de emisor (\"c\" para cliente o \"g\" para gestor): ");
		String tipoEmisor = keyboard.next();
		
		
		
		boolean tipoEmisorCorrect = false;
		
		if (tipoEmisor.equals("g")) {
			tipoEmisorCorrect = true;
		}
		if (tipoEmisor.equals("c")) {
			tipoEmisorCorrect = true;
		}				
		
		while(tipoEmisorCorrect == false) {
			
			System.out.println("El tipo de emisor tiene que ser \"c\" para cliente o \"g\" para gestor, ingreselo de nuevo");
			tipoEmisor = keyboard.next();
			
			if (tipoEmisor.equals("g")) {
				tipoEmisorCorrect = true;
			}
			if (tipoEmisor.equals("c")) {
				tipoEmisorCorrect = true;
			}
		}
		propiedades.put("tipoEmisor", tipoEmisor);	
		
		System.out.println("Establezca el id del emisor: ");
		int idEmisor = keyboard.nextInt();
		
		if(tipoEmisor.equals("g")) {
			
			Gestor gestorBuscado6 = utiles.buscarGestor(idEmisor, gestores);
			
			
			while (gestorBuscado6 == null) {
				System.out.println("Este gestor no existe, por favor indique otro.");
				idEmisor = keyboard.nextInt();
				
				gestorBuscado6 = utiles.buscarGestor(idEmisor, gestores);
			}
		}else {
			
			Cliente clienteBuscado4 = utiles.buscarCliente(idEmisor, clientes);
			
			
			while (clienteBuscado4 == null) {
				System.out.println("Este cliente no existe, por favor indique otro.");
				idEmisor = keyboard.nextInt();
				
				clienteBuscado4 = utiles.buscarCliente(idEmisor, clientes);
			}
			
		}
		
		propiedades.put("idEmisor", idEmisor);	
		

		System.out.println("Establezca el tipo de receptor (\"c\" para cliente y \"g\" para gestor): ");
		String tipoReceptor = keyboard.next();
		
		boolean tipoReceptorCorrect = false;
		
		if (tipoReceptor.equals("g")) {
			tipoReceptorCorrect = true;
		}
		if (tipoReceptor.equals("c")) {
			tipoReceptorCorrect = true;
		}
		
		
		while(tipoReceptorCorrect == false) {
			
			System.out.println("El tipo de receptor tiene que ser \"c\" para cliente o \"g\" para gestor, ingreselo de nuevo");
			tipoReceptor = keyboard.next();
			
			if (tipoReceptor.equals("g")) {
				tipoReceptorCorrect = true;
			}
			if (tipoReceptor.equals("c")) {
				tipoReceptorCorrect = true;
			}
		}
		
		propiedades.put("tipoReceptor", tipoReceptor);	
		
		System.out.println("Establezca el id del receptor: ");
		int idReceptor = keyboard.nextInt();
		
		if(tipoReceptor.equals("g")) {
			
			Gestor gestorBuscado7 = utiles.buscarGestor(idReceptor, gestores);
			
			
			while (gestorBuscado7 == null) {
				System.out.println("Este gestor no existe, por favor indique otro.");
				idReceptor = keyboard.nextInt();
				
				gestorBuscado7 = utiles.buscarGestor(idReceptor, gestores);
			}
		}else {
			
			Cliente clienteBuscado5 = utiles.buscarCliente(idReceptor, clientes);
			
			
			while (clienteBuscado5 == null) {
				System.out.println("Este cliente no existe, por favor indique otro.");
				idReceptor = keyboard.nextInt();
				
				clienteBuscado5 = utiles.buscarCliente(idReceptor, clientes);
			}
		}
		
		propiedades.put("idReceptor", idReceptor);	
		
		
		
		
		
		return propiedades;
		
		
	}
	
}
