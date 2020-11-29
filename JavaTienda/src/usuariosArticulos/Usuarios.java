package usuariosArticulos;

import java.io.Serializable;
import java.util.HashMap;

public class Usuarios implements Serializable{

	
	private static final long serialVersionUID = 716376672158449670L;
	private HashMap<String, Usuario> diccionarioUsuarios = new HashMap<String, Usuario>();
	
	
	
	public boolean addUsuario(String username, String password, String nickname) {
		
		if(existeUsuario(username)){
			return false;
		}
		
		
		Usuario usu = new Usuario(username,password, nickname);

		this.diccionarioUsuarios.put(username.toLowerCase(), usu);
		
		return true;
	}
	
	public boolean existeUsuario(String username) {
		return this.diccionarioUsuarios.containsKey(username.toLowerCase());
	}
	
	public Usuario getUsuario(String username) {
		return this.diccionarioUsuarios.get(username.toLowerCase());
	}
	
	public void mostrarUsuarios() {
		
		for( String clave : this.diccionarioUsuarios.keySet()   ) {
			System.out.println(clave);
			System.out.println(this.getUsuario(clave));
		}
		
	}
	
	
	
	
}