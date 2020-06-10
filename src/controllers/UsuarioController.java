package controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import data.ApiService;
import dtos.CredentialsDTO;
import dtos.DireccionDTO;
import dtos.UsuarioDTO;
import entities.Credentials;
import entities.Direccion;
import entities.Usuario;
import enums.DataFilesNames;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum UsuarioController {

	INSTANCE;
	
	private int usuariosCreados;
	private List<Usuario> usuarios;
	
	UsuarioController() {
		usuariosCreados = 0;
		usuarios = fetchUsuariosPersistidos();
	}
	
	public void createUsuario(UsuarioDTO usuarioDto) throws Exception {
		checkNotExistsUsername(usuarioDto.getCredentialsDto());
		usuarioDto.setCodigo(generateCodigoUsuario());
		Usuario newUsuario = new Usuario(usuarioDto);
		usuarios.add(newUsuario);
		updateUsuariosPersistidos();
	}
	
	private List<Usuario> fetchUsuariosPersistidos() {
		List<UsuarioDTO> dtos = ApiService.leer(UsuarioDTO.class, DataFilesNames.FILE_USUARIOS.getName());
		return dtos.stream()
				.map(Usuario::new)
				.collect(Collectors.toList());				
	}

	private void updateUsuariosPersistidos() {
		ApiService.grabar(getUsuariosDTO(), DataFilesNames.FILE_USUARIOS.getName());
	}
	
	public List<UsuarioDTO> getUsuariosDTO() {
		return usuarios.stream()
				.map(Usuario::toDTO)
				.collect(Collectors.toList());
	}
	
	public Usuario getUsuario(String codigoUsuario) throws Exception {
		return findUsuario(codigoUsuario)
				.orElseThrow(() -> new Exception("No se ha encontrado el usuario"));
	}
	
	public Usuario getUsuarioByCredentials(Credentials credentials) throws Exception {
		return findUsuarioByCredentials(credentials)
				.orElseThrow(() -> new Exception("No se ha encontrado el usuario"));
	}
	
	public boolean existsUsuario(String codigoUsuario) {
		return findUsuario(codigoUsuario)
				.isPresent();
	}
	
	private void checkNotExistsUsername(CredentialsDTO credentialsDto) throws Exception {
		if(existsUsername(credentialsDto)) {
			throw new Exception("El nombre de usuario ya está en uso.");
		}
	}
	
	private boolean existsUsername(CredentialsDTO credentialsDto) {
		return usuarios.stream()
				.map(Usuario::getCredentials)
				.map(Credentials::getUsername)
				.anyMatch(userName -> userName.equals(credentialsDto.getUsername()));
	}
	
	private Optional<Usuario> findUsuario(String codigoUsuario) {
		return usuarios.stream()
				.filter(u -> u.getCodigo().equals(codigoUsuario))
				.findFirst();
	}
	
	public Optional<Usuario> findUsuarioByCredentials(Credentials credential) {
		return usuarios.stream()
				.filter(u -> u.getCredentials().equals(credential))
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
