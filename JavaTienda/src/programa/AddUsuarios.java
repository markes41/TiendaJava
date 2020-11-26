package programa;
import java.io.Serializable;
import java.util.HashMap;

public class AddUsuarios implements Serializable {

	private static final long serialVersionUID = 1228017876672057371L;
	private HashMap<String, Usuario> diccionarioUsuarios = new HashMap<String, Usuario>();
	

	public boolean addUsuarios(String nombreUsuario, String contrasenia, String nombre) {
		
		if(existeUsuario(nombreUsuario)){
			return false;
		}
		
		
		Usuario u = new Usuario(nombreUsuario,contrasenia, nombre);

		this.diccionarioUsuarios.put(nombreUsuario.toLowerCase(), u);
		
		return true;
	}
	
	public boolean existeUsuario(String nombreUsuario) {
		return this.diccionarioUsuarios.containsKey(nombreUsuario.toLowerCase());
	}
	
	public Usuario getUsuario(String nombreUsuario) {
		return this.diccionarioUsuarios.get(nombreUsuario.toLowerCase());
	}
	
	public void mostrarUsuarios() {
		
		for( String clave : this.diccionarioUsuarios.keySet()   ) {
			System.out.println(clave);
			System.out.println(this.getUsuario(clave));
		}
		
	}
}
