package controllers;

import dtos.CredentialsDTO;
import dtos.UsuarioDTO;
import entities.Credentials;
import entities.Usuario;

public enum LoginController {
	
	INSTANCE;

	private Usuario currentUser;

	public UsuarioDTO login(CredentialsDTO credentialsDto) throws Exception {
		Credentials credentials = new Credentials(credentialsDto);
		try {

			currentUser = UsuarioController.INSTANCE.getUsuarioByCredentials(credentials);
			
		} catch (Exception e) {
			throw new Exception("El usuario y/o la password son incorrectos. ");
		}
		
		return currentUser.toDTO();
		
	}
	
	public UsuarioDTO getCurrentUserDTO() {
		return currentUser.toDTO();
	}

}
