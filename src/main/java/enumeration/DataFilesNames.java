package main.java.enumeration;

public enum DataFilesNames {

	FILE_PACIENTES("./src/main/resources/pacientes.txt"),
	FILE_USUARIOS("./src/main/resources/usuarios.txt"),
	FILE_SUCURSALES("./src/main/resources/sucursales.txt"),
	FILE_PRACTICAS("./src/main/resources/practicas.txt");
	
	private String name;

	DataFilesNames(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
