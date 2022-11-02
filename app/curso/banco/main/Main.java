package app.curso.banco.main;

import app.curso.banco.entidad.*;

public class Main {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(1, "Paco", "(+34) 777 666 222", 0);
		
		c1.abrirCuenta("ES123", 500f);
		
		
		
		c1.ingresarDinero("ES123", 500f);
		

		
		c1.retirarDinero("ES123", 500f);

		
		c1.retirarDinero("ES123", 500f);
				
		Cliente c2 = new Cliente();
		
		c2.setId(3);
		
		c2.abrirCuenta("ES124", 500f);

		Gestor g1 = new Gestor(3, "Manuel", "34334134", 14);
		
		Mensaje m1 = new Mensaje();
		Mensaje m2 = new Mensaje(1, Mensaje.TIPO_CLIENTE, c1.getId(), Mensaje.TIPO_GESTOR, g1.getId(), "Mensaje de prueba");
		

		System.out.println("Mensaje como texto: " + m2.toString());
		
		
	}

}
