package app.curso.banco.main;

import app.curso.banco.entidad.Cliente;
import app.curso.banco.entidad.Gestor;

public class Main {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(1, "Paco", "(+34) 777 666 222", 0);
		
		c1.mostrarInfo();
		
		c1.ingresarDinero(10);
		c1.mostrarInfo();
		
		c1.retirarDinero(6);
		c1.mostrarInfo();
		
		
		Gestor g1 = new Gestor(2, "Ana", "(+34) 777 666 111", 3);
		g1.mostrarInfo();

	}

}
