package app.curso.banco.main;

import java.util.ArrayList;

public class TestColecciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> lista = new ArrayList<>();
		int longitud = lista.size();
		
		for(int i = 0; i <= 20; i++) {
			lista.add(i);
			System.out.println(lista.get(i));
		}
		System.out.println(lista);
		
		
		for(int i = 0; i < longitud; i++) {
			lista.remove(0);
		}
		System.out.println(lista);
	}

}
