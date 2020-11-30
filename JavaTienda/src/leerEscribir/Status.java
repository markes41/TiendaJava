package leerEscribir;

import usuariosArticulos.Articulo;
import usuariosArticulos.Usuario;

public class Status {

	private static Status singleton;

	private Usuario usuarioLogueado;
	private Articulo articuloCreado;

	public static Status getInstance() {
		if (singleton == null) {
			singleton = new Status();
		}

		return singleton;
	}

	private Status() {

	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
	}

	public Articulo getArticuloCreado() {
		return articuloCreado;
	}

	public void setArticuloCreado(Articulo articuloCreado) {
		this.articuloCreado = articuloCreado;
	}

}
