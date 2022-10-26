package app.curso.banco.entidad;

public class Cliente extends Persona{
	
	private float totalDinero;

	public Cliente() {
		
	}
	
	public Cliente(int i, String nombre, String telefono, float totalDinero) {
		super(i, nombre, telefono);
		
		this.totalDinero = totalDinero;
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
	}
	
	public float ingresarDinero(float dinero) {
		this.totalDinero += dinero;
		return this.totalDinero;
	}
	
	public float retirarDinero(float dinero) {
		this.totalDinero -= dinero;
		return this.totalDinero;
	}
}
