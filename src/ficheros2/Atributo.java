package ficheros2;


public class Atributo {

	private String str_Nombre = null;
	private String str_ID = null;
	private Double dou_Valor = null;

	public Atributo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Atributo(String str_Nombre, String str_ID, Double dou_Valor) {
		super();
		this.str_Nombre = str_Nombre;
		this.str_ID = str_ID;
		this.dou_Valor = dou_Valor;
	}

	/*
	public Atributo(String datosCompletos) {
		String[] datos = datosCompletos.split(";");
		this.str_Nombre = datos[0];
		this.str_ID = datos[1];
		Double tempD = -1d;
		try {
			tempD = Double.parseDouble(datos[2]);
		} catch (Exception e) {
			tempD = -2d;
		}		
		this.dou_Valor = tempD;
	}
*/
	public String getStr_Nombre() {
		return str_Nombre;
	}

	public void setStr_Nombre(String str_Nombre) {
		this.str_Nombre = str_Nombre;
	}

	public String getStr_ID() {
		return str_ID;
	}

	public void setStr_ID(String str_ID) {
		this.str_ID = str_ID;
	}

	public Double getDou_Valor() {
		return dou_Valor;
	}

	public void setDou_Valor(Double dou_Valor) {
		this.dou_Valor = dou_Valor;
	}

	@Override
	public String toString() {
		return "Atributo [str_Nombre=" + str_Nombre + ", str_ID=" + str_ID + ", dou_Valor=" + dou_Valor + "]";
	}

}
