package enums;

public enum DataFilesNames {

	FILE_PACIENTES("./pacientes.txt"),
	FILE_USUARIOS("./usuarios.txt"),
	FILE_SUCURSALES("./sucursales.txt"),
	FILE_PRACTICAS("./practicas.txt");
	
	private String name;

	DataFilesNames(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
