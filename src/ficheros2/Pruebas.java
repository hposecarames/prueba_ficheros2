package ficheros2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class Pruebas {

	public static void main(String[] args) {
		Controlador controlador = new Controlador();

		try {
			DatosFichero ficha = controlador.getDatosFichero(new File("personaje.txt"));

			System.out.println("==================== Atributos =================");
			muestraMapa(ficha.getAtributos());
			System.out.println("==================== Respuesta =================");
			String[] formulas = ficha.getFormulas();
			for (int i = 0; i < formulas.length; i++) {
				System.out.println(formulas[i]);
			}
			System.out.println("==================== Respuesta una linea =================");
			System.out.println(ficha.getFormulasSingleString());
			
			
			System.out.println("=====================================");

			HashMap<String, Atributo> atributos2 = controlador.getHashAtributos("// Esto es un comentario\n" + "\n"
					+ "FUE;Fuerza;15;\n" + "DEX;Destreza;10;\n" + "CON;Constitucion;14;\n");

			muestraMapa(atributos2);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void muestraMapa(HashMap<String, Atributo> atributos) {
		for (Map.Entry<String, Atributo> registro : atributos.entrySet()) {
			String key = registro.getKey();
			Atributo value = registro.getValue();
			// Decorativo para pruebas
			System.out.println("--- " + key + " ---");
			System.out.println(value.toString());
		}
	}
}
