package main.java.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import main.java.dto.CredentialsDTO;
import main.java.dto.UsuarioDTO;
import main.java.entity.Credentials;
import main.java.entity.Usuario;
import main.java.enumeration.DataFilesNames;
import main.java.enumeration.PrefijoCodigo;
import main.java.enumeration.UsuarioTipo;
import main.java.mock.EntitiesMocks;
import main.java.rest.ApiService;
import main.java.util.CodigoGenerator;

public enum UsuarioController {

	INSTANCE;
	
	private int usuariosCreados;
	private List<Usuario> usuarios;
	
	UsuarioController() {
		usuariosCreados = 0;
		ApiService.grabar(EntitiesMocks.getUsuariosMock(), DataFilesNames.FILE_USUARIOS.getName());
		usuarios = getUsuariosFromDataBase();
	}
	
	public Usuario getUsuario(String codigoUsuario) throws Exception {
		return findUsuario(codigoUsuario)
				.orElseThrow(() -> new Exception("No se ha encontrado el usuario"));
	}
	
	public void createUsuario(UsuarioDTO usuarioDto) throws Exception {
		validateNotExistsUsername(usuarioDto.getCredentialsDto());
		usuarioDto.setCodigo(generateCodigoUsuario());
		Usuario newUsuario = new Usuario(usuarioDto);
		usuarios.add(newUsuario);
		updateUsuariosDataBase();
	}
	
	public void updateUsuario(UsuarioDTO usuarioDto) throws Exception {
		Usuario existingUsuario = getUsuario(usuarioDto.getCodigo());
		existingUsuario.update(usuarioDto);
		updateUsuariosDataBase();
	}
	
	public void deleteUsuario(String codigoUsuario) {
		usuarios.removeIf(u -> u.getCodigo().equals(codigoUsuario));
		updateUsuariosDataBase();
	}
	
	public Usuario getUsuarioByCredentials(Credentials credentials) throws Exception {
		return findUsuarioByCredentials(credentials)
				.orElseThrow(() -> new Exception("No se ha encontrado el usuario"));
	}
	
	public boolean existsUsuario(String codigoUsuario) {
		return findUsuario(codigoUsuario)
				.isPresent();
	}
	
	private void validateNotExistsUsername(CredentialsDTO credentialsDto) throws Exception {
		if(existsUsername(credentialsDto)) {
			throw new Exception("El nombre de usuario ya esta en uso.");
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
	
	private List<Usuario> getUsuariosFromDataBase() {
		List<UsuarioDTO> dtos = ApiService.leer(UsuarioDTO.class, DataFilesNames.FILE_USUARIOS.getName());
		return dtos.stream()
				.map(Usuario::new)
				.collect(Collectors.toList());				
	}

	private void updateUsuariosDataBase() {
		ApiService.grabar(getAllUsuariosDTO(), DataFilesNames.FILE_USUARIOS.getName());
	}
	
	public List<UsuarioDTO> getAllUsuariosDTO() {
		return usuarios.stream()
				.map(Usuario::toDto)
				.collect(Collectors.toList());
	}
	
	public List<UsuarioDTO> getLaboratoristasDTO() {
		return usuarios.stream()
				.filter(usuario -> usuario.getTipoUsuario().equals(UsuarioTipo.LABORATORISTA))
				.map(Usuario::toDto)
				.collect(Collectors.toList());
	}
	
	private String generateCodigoUsuario() {
		usuariosCreados++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.USR, usuariosCreados);
	}
	
}
