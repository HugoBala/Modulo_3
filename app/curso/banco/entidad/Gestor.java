package app.curso.banco.entidad;

public class Gestor extends Persona{
	

	private int idOficina;
	
	public Gestor() {
		
	}
	
	public Gestor(int i, String nombre, String telefono, int idOficina) {
		super(i, nombre, telefono);
		
		this.idOficina = idOficina;
	}
	
	public void mostrarInfo () {
		super.mostrarInfo();
		System.out.println("Id oficina: " + this.idOficina + "\n");
	}

	public int getIdOficina() {
		return idOficina;
	}
	
	public void setIdOficina(int idOficina) {
		this.idOficina = idOficina;
	}
}
