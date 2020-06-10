package main.java.controller;

import main.java.enumeration.UsuarioTipo;

public interface OnLoginCallback {
	
	public void onLoginSuccess(UsuarioTipo tipo);
	
	public void onLoginFailure();
}
