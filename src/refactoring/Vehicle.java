package refactoring;

public class Vehicle {
	public static final int BASIC = 1;
	public static final int GENERAL = 2;
	public static final int LUXE = 3;
	
	private String marca;
	private String model;
	private int categoria;
	
	public Vehicle(String marca, String model, int categoria) {
		this.marca = marca;
		this.model = model;
		this.categoria = categoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	
}