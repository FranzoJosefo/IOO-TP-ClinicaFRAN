package main.java.controller;

import java.util.List;
import java.util.stream.Collectors;

import main.java.Interface.IDto;
import main.java.dto.SucursalDTO;
import main.java.entity.Sucursal;
import main.java.enumeration.DataFilesNames;
import main.java.enumeration.PrefijoCodigo;
import main.java.mock.EntitiesMocks;
import main.java.rest.ApiService;
import main.java.util.CodigoGenerator;

public enum SucursalController {

	INSTANCE;
	
	private int sucursalesCreadas;
	private List<Sucursal> sucursales;
	
	SucursalController() {
		sucursalesCreadas = 0;
		ApiService.grabar(EntitiesMocks.getSucursalesMock(), DataFilesNames.FILE_SUCURSALES.getName());
		sucursales = getSucursalesFromDataBase();
	}
	
	public Sucursal getSucursal(String codigoSucursal) throws Exception {
		return sucursales.stream()
				.filter(s -> s.getCodigo().equals(codigoSucursal))
				.findFirst()
				.orElseThrow(() -> new Exception("No se ha encontrado la sucursal"));
	}
	
	public void createSucursal(SucursalDTO sucursalDto) throws Exception {
		checkResponsableEnabled(sucursalDto.getResponsableCodigo());
		sucursalDto.setCodigo(generateCodigoSucursal());
		Sucursal newSucursal = new Sucursal(sucursalDto);
		sucursales.add(newSucursal);
		updateSucursalesDataBase();
	}
	
	public void updateSucursal(SucursalDTO sucursalDto) throws Exception {
		checkResponsableEnabled(sucursalDto.getResponsableCodigo());
		Sucursal existingSucursal = getSucursal(sucursalDto.getCodigo());
		existingSucursal.update(sucursalDto);
		updateSucursalesDataBase();
	}
	
	public void deleteSucursal(String codigoSucursal) throws Exception {
		if(PeticionController.INSTANCE.hasPeticionesFinalizadas(codigoSucursal)) {
			throw new Exception("No se puede eliminar la sucursal porque tiene peticiones con estudios finalizados.");
		}
		PeticionController.INSTANCE.migratePeticiones(codigoSucursal, findAnotherSucursal(codigoSucursal));
		sucursales.removeIf(s -> s.getCodigo().equals(codigoSucursal));
		updateSucursalesDataBase();
	}
		
	private void checkResponsableEnabled(String responsableAAsignar) throws Exception {
		if(sucursales.stream()
				.map(Sucursal::getResponsableCodigo)
				.anyMatch(responsable -> responsable.equals(responsableAAsignar))) {
			throw new Exception(String.format("El usuario %s ya se encuentra asignado a una sucursal.", responsableAAsignar));
		}
	}
	
	private String findAnotherSucursal(String codigoSucursal) throws Exception {
		return sucursales.stream()
				.map(Sucursal::getCodigo)
				.filter(cs -> !cs.equals(codigoSucursal))
				.findFirst()
				.orElseThrow(() -> new Exception("No existe otra sucursal."));
	}
	
	private List<Sucursal> getSucursalesFromDataBase() {
		List<SucursalDTO> dtos = ApiService.leer(SucursalDTO.class, DataFilesNames.FILE_SUCURSALES.getName());
		return dtos.stream()
				.map(Sucursal::new)
				.collect(Collectors.toList());				
	}

	private void updateSucursalesDataBase() {
		ApiService.grabar(getAllSucursalesDTO(), DataFilesNames.FILE_SUCURSALES.getName());
	}
	
	public List<IDto> getAllSucursalesDTO() {
		return sucursales.stream()
				.map(Sucursal::toDTO)
				.collect(Collectors.toList());
	}
	
	private String generateCodigoSucursal() {
		sucursalesCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.SUC, sucursalesCreadas);
	}
	
}
