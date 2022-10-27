package app.curso.banco.entidad;

import java.util.HashMap;

public class Cliente extends Persona{
	
	private float totalDinero;
	
	private HashMap <String, Float> cuentas;
	
	public HashMap<String, Float> getCuentas() {
		return cuentas;
	}

	public void setCuentas(HashMap<String, Float> cuentas) {
		this.cuentas = cuentas;
	}

	public Cliente() {
		
	}
	
	public Cliente(int i, String nombre, String telefono, float totalDinero) {
		super(i, nombre, telefono);
		this.totalDinero = totalDinero;
		this.cuentas = new HashMap<>();
	}
	
	public float getTotalDinero() {
		return this.totalDinero;
	}
	
	public void setTotalDinero(float totalDinero) {
		this.totalDinero = totalDinero;
	}
	
	public void mostrarInfo () {
		super.mostrarInfo();
		System.out.println("Total dinero: " + this.totalDinero + "€");
		System.out.println("Cuentas del Cliente :");
		mostrarCuentas();
	}
	
	public float ingresarDinero(float dinero) {
		this.totalDinero += dinero;
		return this.totalDinero;
	}
	
	public float retirarDinero(float dinero) {
		this.totalDinero -= dinero;
		return this.totalDinero;
	}
	
	public void abrirCuenta(String idCuenta, Float dinero) {
		this.cuentas.put(idCuenta, dinero);
		ingresarDinero(dinero);
	}
	
	public float ingresarDinero(String idCuenta, Float dinero) {
		Float dineroEnCuenta = this.cuentas.get(idCuenta);
		if(dineroEnCuenta != null) {
			this.cuentas.put(idCuenta, dineroEnCuenta + dinero);
			this.ingresarDinero(dinero);
		}else {
			System.out.println("La cuenta no existe");
		}
		return this.totalDinero;
	}
	
	public float retirarDinero(String idCuenta, Float dinero) {
		Float dineroEnCuenta = this.cuentas.get(idCuenta);
		if(dineroEnCuenta != null) {
			if(dineroEnCuenta > dinero) {
				this.cuentas.put(idCuenta, dineroEnCuenta - dinero);
				this.retirarDinero(dinero);			
			}else {
				System.out.println("ERROR: La cuenta no posee suficientes fondos.");
			}
		}else {
			System.out.println("La cuenta no existe");
		}
		return this.totalDinero;
	}
	
	public void cerrarCuenta(String idCuenta) {
		Float dineroEnCuenta = this.cuentas.get(idCuenta);
		retirarDinero(idCuenta, dineroEnCuenta);
		this.cuentas.remove(idCuenta);
	}
	
	public void mostrarCuentas() {
		this.cuentas.forEach((idCuenta, dinero) ->{
			System.out.println("Cuenta: " + idCuenta + "\nFondos :" + dinero);
		});
	}
}
