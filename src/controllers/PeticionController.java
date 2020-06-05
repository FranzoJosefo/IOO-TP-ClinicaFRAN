package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Interfaces.Resultado;
import entidades.Estudio;
import entidades.Peticion;

public enum PeticionController {
	
	INSTANCE;
	
	private List<Peticion> peticiones = new ArrayList();
	
	public void createPeticion() {
		Peticion newPeticion = new Peticion();
		peticiones.add(newPeticion);
	}
	
	public Peticion getPeticion(String codigoPeticion) throws Exception {
		return peticiones.stream()
		.filter(p -> p.getCodigo().equals(codigoPeticion))
		.findFirst()
		.orElseThrow(() -> new Exception("No se ha encontrado la petición"));
	}
	
	public void cargarResultado(String codigoPeticion, String codigoPractica, Resultado resultado) throws Exception {
		Optional<Estudio> estudio = getPeticion(codigoPeticion)
				.getEstudios()
				.stream()
				.filter(e -> e.getPractica().getCodigo().equals(codigoPractica))
				.findFirst();

		if(estudio.isPresent()) {
			estudio.get().setResultado(resultado);
		} else {
			throw new Exception("No se ha encontrado el estudio asociado a dicha práctica");
		}
	}
	
}
