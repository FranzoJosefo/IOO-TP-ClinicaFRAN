package main.java.mock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.dto.CredentialsDTO;
import main.java.dto.DireccionDTO;
import main.java.dto.PacienteDTO;
import main.java.dto.PracticaDTO;
import main.java.dto.SucursalDTO;
import main.java.dto.UsuarioDTO;
import main.java.enumeration.PracticaValores;
import main.java.enumeration.PracticaValoresTipo;
import main.java.enumeration.Sexo;
import main.java.enumeration.UsuarioTipo;

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
			usuariosMock.add(new UsuarioDTO("USU4_TEST", new CredentialsDTO("laboratorista2", "laboratorista2"),
					UsuarioTipo.LABORATORISTA, sdf.parse("12/03/1976"), "Adolfina", "Pedro",
					new DireccionDTO("Uruguay", 450, "San Pedro"), new Long(34234676), "laborat2@gmail.com"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return usuariosMock;
	}
	
	public static List<SucursalDTO> getSucursalesMock() {
		List<SucursalDTO> sucursalesMock = new ArrayList();
		sucursalesMock.add(new SucursalDTO("SUC1_TEST", new DireccionDTO("Libertador", 1503, "Olivos"), "USU3_TEST"));
		return sucursalesMock;
	}
	
	public static List<PracticaDTO> getPracticasMock() {
		List<PracticaDTO> practicasMock = new ArrayList();
		practicasMock.add(new PracticaDTO("PRA1_TEST", "Recuento leucocitos", "Analisis de sangre", 96, true, PracticaValoresTipo.RANGE, buildPracticaValoresMap("100-150", "150-200", "200-300")));
		practicasMock.add(new PracticaDTO("PRA2_TEST", "Estudio HIV", null, 180, true, PracticaValoresTipo.WORD, buildPracticaValoresMap("negativo", "N/A", "positivo")));
		practicasMock.add(new PracticaDTO("PRA3_TEST", "Medicion glucosa", null, 120, true, PracticaValoresTipo.RANGE, buildPracticaValoresMap("0-100", "100-150", "150-300")));
		practicasMock.add(new PracticaDTO("PRA4_TEST", "Orina", null, 48, false, PracticaValoresTipo.WORD, buildPracticaValoresMap("amarilla", "verde", "roja")));
		return practicasMock;
	}
	
	private static Map<String, String> buildPracticaValoresMap(String valoresNormales, String valoresCriticos, String valoresReservados){
		Map<String, String> map = new HashMap<String, String>(); 
		map.put(PracticaValores.NORMALES.name(), valoresNormales);
		map.put(PracticaValores.CRITICOS.name(), valoresCriticos);
		map.put(PracticaValores.RESERVADOS.name(), valoresReservados);
		return map;
	}
	
}
