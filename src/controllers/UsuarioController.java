package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Direccion;
import entities.Usuario;
import enums.PrefijoCodigo;
import enums.UsuarioTipo;
import utils.CodigoGenerator;

public enum UsuarioController {

	INSTANCE;
	
	private int usuariosCreados = 0;
	private List<Usuario> usuarios = new ArrayList();
	
	public void createUsuario(String codigo, String nombreUsuario, String password, UsuarioTipo tipoUsuario, Date fechaNacimiento, String nombre, Long dni, Direccion direccion, String mail) {
		Usuario newUsuario = new Usuario(generateCodigoUsuario(), nombreUsuario, password, tipoUsuario, fechaNacimiento, nombre, dni, direccion, mail);
		usuarios.add(newUsuario);
	}
	
	public Usuario getUsuario(String codigoUsuario) throws Exception {
		return usuarios.stream()
		.filter(u -> u.getCodigo().equals(codigoUsuario))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado el usuario"));
	}
	
	public void deleteUsuario(String codigoUsuario) {
		usuarios.removeIf(u -> u.getCodigo().equals(codigoUsuario));
	}
	
	private String generateCodigoUsuario() {
		usuariosCreados++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.USUARIO, usuariosCreados);
	}
	
}
