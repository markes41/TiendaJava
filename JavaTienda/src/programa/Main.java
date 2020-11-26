package programa;
import java.util.Scanner;
import interfaz.VentanaLogin;
import leerEscribir.*;
import interfaz.*;


public class Main {
	
	public static void main(String[] args) {

		String rutaUsuarios = "usuarios.dat";

		Archivo archi = new Archivo();

		Scanner sc = new Scanner(System.in);
		AddUsuarios AddUsuarios;

		if (archi.createFile(rutaUsuarios)) {
			AddUsuarios = new AddUsuarios();
			archi.save(AddUsuarios, rutaUsuarios);
		} else {
			AddUsuarios = (AddUsuarios) archi.load(rutaUsuarios);
		}

		MenuOpciones menuOpciones = new MenuOpciones();

		MenuLogueado menuLogueado = new MenuLogueado();


		boolean fin = false;

		while (!fin) {

			System.out.println("Que accion desea realizar?");
			System.out.println("1. Cargar usuarios");
			System.out.println("2. Ingresar al sistema");
			System.out.println("3. Mostrar usuarios");

			System.out.println("0. Salir");

			switch (sc.next()) {
			case "1":
				menuOpciones.cargarUsuario(AddUsuarios,rutaUsuarios);
				break;
			case "2":
				Parametros.getInstance().setUsuarioLogueado( menuOpciones.ingresar(AddUsuarios));

				
				while(Parametros.getInstance().getUsuarioLogueado() != null) {
					System.out.println("Ingrese una opcion");
					System.out.println("1. Comprar");
					System.out.println("2. Vender");
					System.out.println("3. Cargar");
					
					System.out.println("0. Log out");
					
					switch (sc.next()) {
					case "0":
						
						menuLogueado.logout();
						break;

					default:

						System.out.println("Opcion incorrecta");
						break;
					}
					
				}

				break;
			case "3":
				AddUsuarios.mostrarUsuarios();
				break;

			case "0":
				fin = true;
				break;
			default:

				System.out.println("Opcion incorrecta");
				break;
			}

		}

	}

	//public static void main(String[] args) {
		//VentanaLogin login = new VentanaLogin();
		//login.setVisible(true);
		
	//}

}
