package app.curso.banco.entidad;

public class Transferencia extends Mensaje{
	
	private int dinero;

	public Transferencia() {

	}
	
	public Transferencia(int id, char tipoEmisor, int idEmisor, char tipoReceptor, int idReceptor, String textoMensaje, int dinero) {
		
		super(id, tipoEmisor, idEmisor, tipoReceptor, idReceptor, textoMensaje);
		
		this.dinero = dinero;
	}

}
