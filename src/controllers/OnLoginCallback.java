package controllers;

import enums.UsuarioTipo;

public interface OnLoginCallback {
	
	public void onLoginSuccess(UsuarioTipo tipo);
	
	public void onLoginFailure();
}
