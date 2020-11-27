package programa;
import java.io.Serializable;
import java.util.HashMap;

public class AddArticulos implements Serializable {

	private static final long serialVersionUID = -2737834430344017259L;
	private HashMap<String, Articulo> diccionarioArticulos = new HashMap<String, Articulo>();
	

	public boolean addArticulos(String codigo, String nombre, String precio, String cantidad) {
		
		if(existeArticulo(codigo)){
			return false;
		}
		
		
		Articulo art = new Articulo(codigo, nombre, precio, cantidad);

		this.diccionarioArticulos.put(codigo.toLowerCase(), art);
		
		return true;
	}
	
	public boolean existeArticulo(String codigo) {
		return this.diccionarioArticulos.containsKey(codigo.toLowerCase());
	}
	
	public Articulo getArticulo(String codigo) {
		return this.diccionarioArticulos.get(codigo.toLowerCase());
	}
	
	public void mostrarArticulos() {
		
		for( String clave : this.diccionarioArticulos.keySet()   ) {
			System.out.println(clave);
			System.out.println(this.getArticulo(clave));
		}
		
	}
}
