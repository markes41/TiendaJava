package leerEscribir;
import usuariosArticulos.Articulo;
import usuariosArticulos.Usuario;
public class Parametros {
		
		private static Parametros singleton;
		
		
		private Usuario usuarioLogueado;
		private Articulo articuloCreado;
		
		public static Parametros getInstance() {
			if(singleton == null) {
				singleton = new Parametros();
			}
			
			
			return singleton;
		}
		
		
		
		private Parametros() {
			
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


