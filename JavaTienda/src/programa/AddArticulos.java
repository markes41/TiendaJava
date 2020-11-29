package programa;
import java.io.Serializable;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

public class AddArticulos implements Serializable {

	private static final long serialVersionUID = -2737834430344017259L;
	private HashMap<String, Articulo> diccionarioArticulos = new HashMap<String, Articulo>();
	Articulo res;

	public boolean addArticulos(int codigo, String nombre, double precio, int cantidad) {
		
		if(existeArticulo(nombre)){
			return false;
		}
		
		
		Articulo art = new Articulo(codigo, nombre, precio, cantidad);

		this.diccionarioArticulos.put(nombre.toLowerCase(), art);
		
		return true;
	}
	
	public boolean existeArticulo(String nombre) {
		return this.diccionarioArticulos.containsKey(nombre.toLowerCase());
	}
	
	public Articulo getArticulo(String nombre) {
		return this.diccionarioArticulos.get(nombre.toLowerCase());
	}
	
	public void mostrarArticulos() {
		
		for( String clave : this.diccionarioArticulos.keySet()   ) {
			System.out.println(clave);
			System.out.println(this.getArticulo(clave));
		}
		
	}
	

	
	

}
