package ficheros2;

import ficheros2.DatosFichero;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class Controlador {

	public HashMap<String, Atributo> getHashAtributos(String datos)
			throws FileNotFoundException, ParseException, IOException {

		HashMap<String, Atributo> atributos = new HashMap<String, Atributo>();

		String[] datosSeparados = datos.split("\n");
		for (int i = 0; i < datosSeparados.length; i++) {
			String cadenaLeida = datosSeparados[i].trim();
			if (!cadenaLeida.isEmpty()) {
				if (!cadenaLeida.substring(0, 2).equals("//")) {
					// Cosas que hacemos despues de ignorar los comentarios
					Atributo atributo = atributoFromString(cadenaLeida);
					atributos.put(atributo.getStr_ID(), atributo);
				} else {
					System.out.println("Comentario: " + cadenaLeida);
				}
			}
		}
		return atributos;
	}

	public DatosFichero getDatosFichero(File fichero) // Modificar la salida al gusto
			throws FileNotFoundException, ParseException, IOException {
		// Peque�o control de estados
		int estado = 0; // 0 Inicial, 1 cargando atributos, 2 cargando formulas, 3 salir

		DatosFichero datosFichero = new DatosFichero();
		HashMap<String, Atributo> atributos = new HashMap<String, Atributo>();
		ArrayList<String> formulas = new ArrayList<String>();
		FileReader fileReader;
		BufferedReader bufferedReader;

		try {
			if (fichero.exists()) {
				fileReader = new FileReader(fichero);
				bufferedReader = new BufferedReader(fileReader);
				String cadenaLeida;
				while (((cadenaLeida = bufferedReader.readLine()) != null) && estado != 3) {
					// Aqui va la logica de proceso de las cadenas leidas desde el fichero
					cadenaLeida = cadenaLeida.trim();
					if (!cadenaLeida.isEmpty()) {
						if (!cadenaLeida.substring(0, 2).equals("//")) {
							// Cosas que hacemos despues de procesar los comentarios
							switch (cadenaLeida) {
							case "DECLARE": // if
								// System.out.println("estado leyendo atributos");
								estado = 1;
								break;
							case "BEGIN": // elseif
								// System.out.println("estado leyendo formulas");
								estado = 2;
								break;
							case "END": // elseif
								// System.out.println("estado saliendo");
								estado = 3;
								break;
							default: // else
								if (estado == 1) {
									Atributo atributo = atributoFromString(cadenaLeida);
									atributos.put(atributo.getStr_ID(), atributo);
								} else if (estado == 2) {
									formulas.add(cadenaLeida);
								}
								break;
							}

						} else {
							System.out.println("Comentario: " + cadenaLeida);
						}
					}
				}
				datosFichero.setAtributos(atributos);
				datosFichero.setFormulas(convierteFormulas(formulas));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datosFichero;
	}

	public Atributo atributoFromString(String cadenaDatos) throws ParseException {
		String[] valores = cadenaDatos.split(";");
		Double valorAtributo = -1d;
		valorAtributo = Double.parseDouble(valores[2]);
		Atributo atributo = new Atributo(valores[1], valores[0], valorAtributo);
		return atributo;
	}

	public String[] convierteFormulas(ArrayList<String> formulas) {
		String[] listaFormulas = new String[formulas.size()];
		int contador = 0;
		for (String formula : formulas) {
			listaFormulas[contador] = formula;
			contador++;
		}
		return listaFormulas;
	}
}
