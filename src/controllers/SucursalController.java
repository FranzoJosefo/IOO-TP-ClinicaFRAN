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
	
	private String generateCodigoSucursal() {
		sucursalesCreadas++;
		return CodigoGenerator.generateCodigo(PrefijoCodigo.SUCURSAL, sucursalesCreadas);
	}
	
}
