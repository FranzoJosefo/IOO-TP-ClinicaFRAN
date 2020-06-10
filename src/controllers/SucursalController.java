package controllers;

import java.util.List;
import java.util.stream.Collectors;

import data.ApiService;
import dtos.SucursalDTO;
import entities.Sucursal;
import enums.DataFilesNames;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum SucursalController {

	INSTANCE;
	
	private int sucursalesCreadas;
	private List<Sucursal> sucursales;
	
	SucursalController() {
		sucursalesCreadas = 0;
		sucursales = fetchSucursalesPersistidas();
	}
	
	public void createSucursal(SucursalDTO sucursalDto) throws Exception {
		checkResponsableExists(sucursalDto.getResponsableCodigo());
		sucursalDto.setCodigo(generateCodigoSucursal());
		Sucursal newSucursal = new Sucursal(sucursalDto);
		sucursales.add(newSucursal);
		updateSucursalesPersistidas();
	}
	
	private List<Sucursal> fetchSucursalesPersistidas() {
		List<SucursalDTO> dtos = ApiService.leer(SucursalDTO.class, DataFilesNames.FILE_SUCURSALES.getName());
		return dtos.stream()
				.map(Sucursal::new)
				.collect(Collectors.toList());				
	}

	private void updateSucursalesPersistidas() {
		ApiService.grabar(getSucursalesDTO(), DataFilesNames.FILE_SUCURSALES.getName());
	}
	
	public List<SucursalDTO> getSucursalesDTO() {
		return sucursales.stream()
				.map(Sucursal::toDTO)
				.collect(Collectors.toList());
	}
	
	public Sucursal getSucursal(String codigoSucursal) throws Exception {
		return sucursales.stream()
				.filter(s -> s.getCodigo().equals(codigoSucursal))
				.findFirst()
				.orElseThrow(() -> new Exception("No se ha encontrado la sucursal"));
	}
	
	public void deleteSucursal(String codigoSucursal) throws Exception {
		if(PeticionController.INSTANCE.hasPeticionesFinalizadas(codigoSucursal)) {
			throw new Exception("No se puede eliminar la sucursal porque tiene peticiones con estudios finalizados.");
		}
		PeticionController.INSTANCE.migratePeticiones(codigoSucursal, findAnotherSucursal(codigoSucursal));
		sucursales.removeIf(s -> s.getCodigo().equals(codigoSucursal));
	}
	
	private void checkResponsableExists(String codigoUsuario) throws Exception {
		if(!UsuarioController.INSTANCE.existsUsuario(codigoUsuario)) {
			throw new Exception(String.format("El usuario %s para asignar como responsable no existe.", codigoUsuario));
		}
	}
	
	private String findAnotherSucursal(String codigoSucursal) throws Exception {
		return sucursales.stream()
				.map(Sucursal::getCodigo)
				.filter(cs -> !cs.equals(codigoSucursal))
				.findFirst()
				.orElseThrow(() -> new Exception("No existe otra sucursal."));
	}
	
	private String generateCodigoSucursal() {
		sucursalesCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.SUCURSAL, sucursalesCreadas);
	}
	
}
