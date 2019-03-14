package ficheros2;

import java.util.HashMap;

public class DatosFichero {
	HashMap<String, Atributo> atributos;
	String[] formulas; // si es que se quiere tener en un array

	public DatosFichero(HashMap<String, Atributo> atributos, String[] formulas) {
		this.atributos = atributos;
		this.formulas = formulas;
	}

	public DatosFichero() {
	}

	public HashMap<String, Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(HashMap<String, Atributo> atributos) {
		this.atributos = atributos;
	}

	public String[] getFormulas() {
		return formulas;
	}

	public void setFormulas(String[] formulas) {
		this.formulas = formulas;
	}

	public String getFormulasSingleString() {
		String respuesta = "";
		for (int i = 0; i < formulas.length; i++) {
			respuesta += formulas[i] + ";"; // dependiendo de como se quiera formatear la cadena de formulas
		}
		return respuesta;
	}
}
