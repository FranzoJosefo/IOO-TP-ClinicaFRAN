package mocks;

import java.util.ArrayList;
import java.util.List;

import dtos.DireccionDTO;
import dtos.PacienteDTO;
import enums.Sexo;

public class EntitiesMocks {

	public static List<PacienteDTO> getPacientesMock() {
		List<PacienteDTO> pacientesMock = new ArrayList();
		pacientesMock.add(new PacienteDTO("PAC1", Sexo.MASCULINO, 28L, "Araujo", "Manuel", new DireccionDTO("chile", 1410, "CABA"), 36529565L, "manuel@gmail.com"));
		pacientesMock.add(new PacienteDTO("PAC2", Sexo.FEMENINO, 18L, "Fernandez", "Ramon", new DireccionDTO("mexico", 1434, "Tigre"), 23423565L, "ramon@live.com"));
		pacientesMock.add(new PacienteDTO("PAC3", Sexo.MASCULINO, 23L, "Gonzalez", "Pedro", new DireccionDTO("colombia", 3534, "San isidro"), 76543865L, "pedro@hotmail.com"));
		pacientesMock.add(new PacienteDTO("PAC4", Sexo.FEMENINO, 43L, "Milito", "Pablo", new DireccionDTO("cabildo", 3533, "CABA"), 23567543L, "pablo@gmail.com"));
		pacientesMock.add(new PacienteDTO("PAC5", Sexo.MASCULINO, 12L, "Cacho", "Joaquin", new DireccionDTO("libertador", 6756, "Olivos"), 45643786L, "joaquin@live.com"));
		return pacientesMock;
	}
	
}
