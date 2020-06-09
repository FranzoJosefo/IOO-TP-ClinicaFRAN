package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dtos.DireccionDTO;
import dtos.UsuarioDTO;
import entities.Direccion;
import entities.Usuario;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum UsuarioController {

	INSTANCE;
	
	private int usuariosCreados;
	private List<Usuario> usuarios;
	
	UsuarioController() {
		usuariosCreados = 0;
		usuarios = new ArrayList();
	}
	
	public void createUsuario(UsuarioDTO usuarioDto) {
		
		// tenemos que meter un check de que no exista el usuario por nombre o mail
		usuarioDto.setCodigo(generateCodigoUsuario());
		Usuario newUsuario = new Usuario(usuarioDto);
		usuarios.add(newUsuario);
	}
	
	public Usuario getUsuario(String codigoUsuario) throws Exception {
		return findUsuario(codigoUsuario)
				.orElseThrow(() -> new Exception("No se ha encontrado el usuario"));
	}
	
	public boolean existsUsuario(String codigoUsuario) {
		return findUsuario(codigoUsuario)
				.isPresent();
	}
	
	public Optional<Usuario> findUsuario(String codigoUsuario) {
		return usuarios.stream()
				.filter(u -> u.getCodigo().equals(codigoUsuario))
				.findFirst();
	}
	
	public void deleteUsuario(String codigoUsuario) {
		usuarios.removeIf(u -> u.getCodigo().equals(codigoUsuario));
	}
	
	public Direccion createDireccion(DireccionDTO direccionDto) {
		return new Direccion(direccionDto);
	}
	
	private String generateCodigoUsuario() {
		usuariosCreados++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.USUARIO, usuariosCreados);
	}
	
}
