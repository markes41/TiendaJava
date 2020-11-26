package leerEscribir;
import programa.Usuario;
public class Parametros {
		
		private static Parametros singleton;

		private Usuario usuarioLogueado;
		
		
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
		
		


	}


