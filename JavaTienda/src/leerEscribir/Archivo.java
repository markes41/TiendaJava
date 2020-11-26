package leerEscribir;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Archivo implements Serializable{
		

		public boolean createFile(String ruta) {
			File archivo = new File(ruta);
			try {
				return archivo.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		public Object load(String ruta) {
			try {
				File archivo = new File(ruta);
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivo));
				Object obj = input.readObject();
				input.close();
				return obj;
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}

		public void save(Object objeto, String ruta) {
			File archivo = new File(ruta);
			try {
				ObjectOutputStream ouput = new ObjectOutputStream(new FileOutputStream(archivo, false));
				ouput.writeObject(objeto);
				ouput.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public boolean existe(String ruta) {
			File archivo = new File(ruta);
			return archivo.exists();
		}

}
