package Menues;

import java.util.Scanner;

import leerEscribir.Archivo;
import programa.Usuarios;
import programa.Usuario;
import leerEscribir.Archivo;

public class MenuOpciones {

	
	public void cargarUsuario(Usuarios usuarios, String rutaUsuarios) {
		Archivo archi = new Archivo();
		Scanner sc = new Scanner(System.in);

			System.out.println("ingrese el nombre del usuario a ingresar (0 para salir)");
			String username = sc.next();
			
			if(username.equals("0")) {
				return;
			}
			
			System.out.println("ingrese la contraseña del usuario a ingresar");
			String password = sc.next();
			
			System.out.println("ingrese el nick del usuario a ingresar");
			String nick = sc.next();
			
			
			if(   usuarios.addUsuario(username, password, nick)     ) {
				System.out.println("El usuario se creó perfectamente");
				archi.save(usuarios, rutaUsuarios);
			}else {
				System.out.println("Ya existe un usuario con ese nombre");
			}
	}
	
	
	public Usuario ingresar(Usuarios usuarios) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre de usuario");
		String username = sc.next();
		
		if(!usuarios.existeUsuario(username)) {
			System.out.println("No existe el usuario");
			return null;
		}
		
		Usuario usu = usuarios.getUsuario(username);
		

		
		System.out.println("Ingrese la clave de usuario");
		String password = sc.next();
		
		
		
		if(usu.isClave(password)) {
			return usu;
		}
		return null;
		
		
		
		
	}
	
	
	
	
	
	
}
