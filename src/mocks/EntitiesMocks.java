package mocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dtos.CredentialsDTO;
import dtos.DireccionDTO;
import dtos.PacienteDTO;
import dtos.UsuarioDTO;
import enums.Sexo;
import enums.UsuarioTipo;

public class EntitiesMocks {

	public static List<PacienteDTO> getPacientesMock() {
		List<PacienteDTO> pacientesMock = new ArrayList();
		pacientesMock.add(new PacienteDTO("PAC1_TEST", Sexo.MASCULINO, 28L, "Araujo", "Manuel",
				new DireccionDTO("chile", 1410, "CABA"), 36529565L, "manuel@gmail.com"));
		pacientesMock.add(new PacienteDTO("PAC2_TEST", Sexo.FEMENINO, 18L, "Fernandez", "Ramon",
				new DireccionDTO("mexico", 1434, "Tigre"), 23423565L, "ramon@live.com"));
		pacientesMock.add(new PacienteDTO("PAC3_TEST", Sexo.MASCULINO, 23L, "Gonzalez", "Pedro",
				new DireccionDTO("colombia", 3534, "San isidro"), 76543865L, "pedro@hotmail.com"));
		pacientesMock.add(new PacienteDTO("PAC4_TEST", Sexo.FEMENINO, 43L, "Milito", "Pablo",
				new DireccionDTO("cabildo", 3533, "CABA"), 23567543L, "pablo@gmail.com"));
		pacientesMock.add(new PacienteDTO("PAC5_TEST", Sexo.MASCULINO, 12L, "Cacho", "Joaquin",
				new DireccionDTO("libertador", 6756, "Olivos"), 45643786L, "joaquin@live.com"));
		return pacientesMock;
	}

	public static List<UsuarioDTO> getUsuariosMock() {
		List<UsuarioDTO> usuariosMock = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			usuariosMock.add(new UsuarioDTO("USU1_TEST", new CredentialsDTO("admin", "admin"),
					UsuarioTipo.ADMINISTRADOR, sdf.parse("31/12/1998"), "Olivero", "Francisco",
					new DireccionDTO("Ricardo Gutierrez", 1434, "Olivos"), new Long(36904265), "admin@gmail.com"));
			usuariosMock.add(new UsuarioDTO("USU2_TEST", new CredentialsDTO("recepcionista", "recepcionista"),
					UsuarioTipo.RECEPCIONISTA, sdf.parse("14/06/1988"), "Menem", "Carlos",
					new DireccionDTO("Armenia", 2004, "Palermo"), new Long(32404122), "recep@gmail.com"));
			usuariosMock.add(new UsuarioDTO("USU3_TEST", new CredentialsDTO("laboratorista", "laboratorista"),
					UsuarioTipo.LABORATORISTA, sdf.parse("12/03/1976"), "Banderas", "Antonio",
					new DireccionDTO("Francia", 300, "San Isidro"), new Long(38106541), "laborat@gmail.com"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuariosMock;
	}
}
