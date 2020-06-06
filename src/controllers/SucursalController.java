package controllers;

import java.util.ArrayList;
import java.util.List;

import entities.Direccion;
import entities.Sucursal;
import entities.Usuario;
import enums.PrefijoCodigo;
import utils.CodigoGenerator;

public enum SucursalController {

	INSTANCE;
	
	private int sucursalesCreadas = 0;
	private List<Sucursal> sucursales = new ArrayList();
	
	public void createSucursal(String codigo, Direccion direccion, Usuario responsable) {
		Sucursal newSucursal = new Sucursal(generateCodigoSucursal(), direccion, responsable);
		sucursales.add(newSucursal);
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
