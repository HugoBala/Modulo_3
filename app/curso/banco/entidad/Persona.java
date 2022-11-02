package app.curso.banco.entidad;

public class Persona {
	
	protected int id;
	protected String name;
	protected String phone;
	protected String password;
	
	

	Persona(){
		
	}
	
	Persona(int id, String nombre, String telefono) {
		this.id = id;
		this.name = nombre;
		this.phone = telefono;
	}
	
	public void mostrarInfo () {
		System.out.println("Id: " + this.id);
		System.out.println("Nombre: " + this.name);
		System.out.println("Número de Teléfono: " + this.phone);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
