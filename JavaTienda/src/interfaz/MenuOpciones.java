package interfaz;
import java.util.Scanner;
import leerEscribir.Archivo;
import programa.Usuario;
import programa.AddUsuarios;

public class MenuOpciones {

		public void cargarUsuario(AddUsuarios usuario, String rutaUsuarios) {
			Archivo archi = new Archivo();
			Scanner sc = new Scanner(System.in);

				System.out.println("ingrese el nombre del usuario a ingresar (0 para salir)");
				String nombreUsuario = sc.next();
				
				if(nombreUsuario.equals("0")) {
					return;
				}
				
				System.out.println("ingrese la contraseña del usuario a ingresar");
				String contrasenia = sc.next();
				
				System.out.println("ingrese el nick del usuario a ingresar");
				String nombre = sc.next();
				
				
				if(   usuario.addUsuarios(nombreUsuario, contrasenia, nombre)     ) {
					System.out.println("El usuario se creó perfectamente");
					archi.save(usuario, rutaUsuarios);
				}else {
					System.out.println("Ya existe un usuario con ese nombre");
				}	
			
		}
		
		
		public Usuario ingresar(AddUsuarios usuario) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Ingrese el nombre de usuario");
			String nombreUsuario = sc.next();
			
			if(!usuario.existeUsuario(nombreUsuario)) {
				System.out.println("No existe el usuario");
				return null;
			}
			
			Usuario u = usuario.getUsuario(nombreUsuario);
			

			
			System.out.println("Ingrese la clave de usuario");
			String contrasenia = sc.next();
			
			
			
			if(u.isClave(contrasenia)) {
				return u;
			}
			return null;
			
			
			
			
		}
		
		
		
		
		
		
	}


