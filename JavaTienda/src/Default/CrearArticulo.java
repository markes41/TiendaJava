package Default;
import LeerEscribir.Archivo;

public class CrearArticulo {
	private String codigo, nombre, precio, cantidad;
	Archivo createArticulo = new Archivo();

	public CrearArticulo(String codigo, String nombre,  String precio, String cantidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		createArticulo.escribirFicheroA(codigo, nombre,  precio, cantidad);

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
