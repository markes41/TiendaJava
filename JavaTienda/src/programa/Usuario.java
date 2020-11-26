package programa;
import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 697162543239062490L;
	private String nombreUsuario, contrasenia, nombre;

	public Usuario(String nombreUsuario, String contrasenia, String nombre) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNickname(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isClave(String contrasenia) {
		return this.getContrasenia().equals(contrasenia);
	

}
}