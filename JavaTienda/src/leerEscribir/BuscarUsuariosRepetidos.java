package leerEscribir;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class BuscarUsuariosRepetidos {

	BufferedReader br;
	BufferedWriter bw;
	private boolean existe = false;
	int a = 0;

	public void leerFichero(String data1) {
		try {
			FileReader usuario = new FileReader("usuarios.txt");
			br = new BufferedReader(usuario);
			String texto = br.readLine();

			while (texto != null) {
				String[] word = texto.split(" ");
				if (word[2].equalsIgnoreCase(data1)) {
					existe = true;
					setExiste(existe);
				}
				texto = br.readLine();

			}

		} catch (Exception e) {
			System.out.println("Error: Fichero no encontrado");
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar el fichero");
				System.out.println(e.getMessage());
			}
		}
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public boolean isExiste() {
		return existe;
	}

}
