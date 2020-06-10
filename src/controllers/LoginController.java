package controllers;

import dtos.CredentialsDTO;
import dtos.UsuarioDTO;
import entities.Credentials;
import entities.Usuario;

public enum LoginController {
	
	INSTANCE;

	private Usuario currentUser;

	public void login(CredentialsDTO credentialsDto, OnLoginCallback callback) {
		Credentials credentials = new Credentials(credentialsDto);
		try {
			currentUser = UsuarioController.INSTANCE.getUsuarioByCredentials(credentials);
			callback.onLoginSuccess(currentUser.getTipoUsuario());
		} catch (Exception e) {
			callback.onLoginFailure();
			e.printStackTrace();
		}
	}
	
	public UsuarioDTO getCurrentUserDTO() {
		return currentUser.toDTO();
	}

}
