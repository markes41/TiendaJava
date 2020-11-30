package menues;

import leerEscribir.Status;

public class MenuLog {

	public void logout() {
		Status.getInstance().setUsuarioLogueado(null);
	}
}
