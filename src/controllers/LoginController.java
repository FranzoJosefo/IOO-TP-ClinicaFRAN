package controllers;

import dtos.CredentialsDTO;
import dtos.UsuarioDTO;
import entities.Credentials;
import entities.Usuario;

public enum LoginController {
	
	INSTANCE;

	private Usuario currentUser;

	public void login(CredentialsDTO credentialsDto, OnLoginCallback callback) throws Exception {
		Credentials credentials = new Credentials(credentialsDto);
		try {
			currentUser = UsuarioController.INSTANCE.getUsuarioByCredentials(credentials);
			callback.onLoginSuccess();
		} catch (Exception e) {
			callback.onLoginFailure();
			throw new Exception("El usuario y/o la password son incorrectos. ");
		}
				
	}
	
	public UsuarioDTO getCurrentUserDTO() {
		return currentUser.toDTO();
	}

}
