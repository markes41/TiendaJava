package programa;
import java.io.Serializable;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

public class AddArticulos implements Serializable {

	private static final long serialVersionUID = -2737834430344017259L;
	private HashMap<String, Articulo> diccionarioArticulos = new HashMap<String, Articulo>();
	Articulo res;

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
	
	public void mostrarArticulosInterfaz() {
		  int numero_iteraciones_bucle_for=0;
		  String [] registros =  new String[numero_iteraciones_bucle_for];
		  String [] titulos ={"Nombre","Cantidad","Codigo","Precio"};
		  DefaultTableModel modelo;
		  modelo= new DefaultTableModel(null,titulos);
		 // registros [0]=art.getString("Nombre");
		  int iteracion=1;
		             for(String clave:this.diccionarioArticulos.keySet()){
		            	 System.out.println(clave);
		               registros [iteracion]=this.toString();
		                iteracion++;
		                modelo.addRow(registros);
		                
		              }                

	}

}
