package interfaz;

import leerEscribir.Parametros;

public class MenuLogueado {

	
	public void logout() {
		Parametros.getInstance().setUsuarioLogueado(null);
	}
}
