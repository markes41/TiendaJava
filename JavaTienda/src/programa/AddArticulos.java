package programa;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

public class AddArticulos implements Serializable {

	private static final long serialVersionUID = -2737834430344017259L;
	private HashMap<Integer, Articulo> diccionarioArticulos = new HashMap<Integer, Articulo>();
	Articulo res;

	public boolean addArticulos(int codigo, String nombre, double precio, int cantidad) {
		
		if(existeArticulo(codigo)){
			return false;
		}
		
		
		Articulo art = new Articulo(codigo, nombre, precio, cantidad);

		this.diccionarioArticulos.put(codigo, art);
		
		return true;
	}
	
	public boolean existeArticulo(int codigo) {
		return this.diccionarioArticulos.containsKey(codigo);
	}
	
	public Articulo getArticulo(int codigo) {
		return this.diccionarioArticulos.get(codigo);
	}
	
	public void mostrarArticulos() {
		
		for( int clave : this.diccionarioArticulos.keySet()   ) {
			System.out.println("Clave del artículo: "+clave+"\n"+this.getArticulo(clave)+"\n");
		}
		
	}
	
	public boolean modificarArticulo() {
		Scanner sc = new Scanner(System.in);
		mostrarArticulos();
		System.out.println("Seleccione el artículo que quiere editar, escribiendo su codigo: ");
		int codeArticle = sc.nextInt();
		if(existeArticulo(codeArticle)) {
		
			System.out.println("Ingrese el nuevo nombre: ");
			String nuevoNombre = sc.next();
			
			System.out.println("Ingresa la nueva cantidad: ");
			int nuevaCantidad = sc.nextInt();
			
			System.out.println("Ingrese el nuevo precio: ");
			double nuevoPrecio = sc.nextDouble();
			
			Articulo changeArticle = new Articulo(codeArticle, nuevoNombre, nuevoPrecio, nuevaCantidad);
			diccionarioArticulos.replace(codeArticle, changeArticle);
			
			
			return true;
		}else {
			return false;
		}
		
	}
	
	

}
