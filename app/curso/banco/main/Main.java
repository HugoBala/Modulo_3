package app.curso.banco.main;

import app.curso.banco.entidad.Cliente;

public class Main {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(1, "Paco", "(+34) 777 666 222", 0);
		
		c1.abrirCuenta("ES123", 500f);
		
		c1.mostrarInfo();
		
		c1.ingresarDinero("ES123", 500f);
		
		c1.mostrarInfo();
		
		c1.retirarDinero("ES123", 500f);
		
		c1.mostrarInfo();
		
		c1.retirarDinero("ES123", 500f);
		
		c1.mostrarInfo();
		
		Cliente c2 = new Cliente();
		
		c2.setId(3);
		
		c2.abrirCuenta("ES124", 500f);
		c2.mostrarInfo();
	}

}
