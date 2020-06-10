package controllers;

import dtos.CredentialsDTO;
import dtos.UsuarioDTO;
import entities.Credentials;
import entities.Usuario;
import enums.UsuarioTipo;

public enum LoginController {
	INSTANCE;

	private static UsuarioController usuarioController = UsuarioController.INSTANCE;
	private Credentials credentials;
	private Usuario currentUser;

	private LoginController() {

	}

	public void login(CredentialsDTO credentialsDto) {
		credentials = new Credentials(credentialsDto);
		try {
			//Solo devlovera usuario si lo encuentra, por ende las credenciales son correctas
			currentUser = usuarioController.getUsuarioByCredentials(credentials);
			
			
			//Esto de aca abajo en realidad habria que tenerlo en la vista, usando getCUrrentUserDTO.getTipoUSuario y ahcer un switch asi para ver que escondemos y que no 
			//al cargar la pantalla principal.
			UsuarioTipo tipo = currentUser.getTipoUsuario();
			switch(tipo) {
				case ADMINISTRADOR:
					//TODO nocultar vistas? 
					break;
				case RECEPCIONISTA:
					//TODO nocultar vistas? 
					break;
				case LABORATORISTA:
					//TODO nocultar vistas? 
					break;
			}
		} catch (Exception e) {
			// Mando error a la vista:  USUARIO O CONTRASEÑA INCORRECTOS
			e.printStackTrace();
		}
	}
	
	public UsuarioDTO getCurrentUserDTO() {
		return currentUser.toDTO();
	}

}
