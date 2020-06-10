package controllers;

import dtos.CredentialsDTO;
import entities.Credentials;
import entities.Usuario;
import enums.UsuarioTipo;

public enum LoginController {
	INSTANCE;

	private static UsuarioController usuarioController = UsuarioController.INSTANCE;
	private Credentials credentials;

	private LoginController() {

	}

	public void login(CredentialsDTO credentialsDto) {
		credentials = new Credentials(credentialsDto);
		try {
			//Solo devlovera usuario si lo encuentra, por ende las credenciales son correctas
			Usuario usuario = usuarioController.getUsuarioByCredentials(credentials);
			UsuarioTipo tipo = usuario.getTipoUsuario();
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

}
