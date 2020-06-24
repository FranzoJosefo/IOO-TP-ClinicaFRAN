package main.java.controller;

import main.java.dto.CredentialsDTO;
import main.java.dto.UsuarioDTO;
import main.java.entity.Credentials;
import main.java.entity.Usuario;

public enum LoginController {
	
	INSTANCE;

	private Usuario currentUser;

	public void login(CredentialsDTO credentialsDto, OnLoginCallback callback) {
		Credentials credentials = new Credentials(credentialsDto);
		try {
			currentUser = UsuarioController.INSTANCE.getUsuarioByCredentials(credentials);
			callback.onLoginSuccess();
		} catch (Exception e) {
			callback.onLoginFailure();
			e.printStackTrace();
		}
	}
	
	public UsuarioDTO getCurrentUserDTO() {
		return currentUser.toDto();
	}

}
