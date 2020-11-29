package programa;
import java.io.Serializable;

public class Articulo implements Serializable{

	private static final long serialVersionUID = 2796074017515047685L;
	private String nombre;
	private double precio;
	private int codigo, cantidad;
	
	public Articulo(int codigo, String nombre,  double precio, int cantidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "Articulo [Codigo=" + codigo + ", Nombre=" + nombre + ", precio=" + precio + ", Cantidad=" + cantidad +"]";
	}
	
}
