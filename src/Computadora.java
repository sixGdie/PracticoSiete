import java.util.HashSet;

public class Computadora {

	private String marca;
	private String modelo;
	private HashSet<ComponenteCPU> componentes;
	
	public Computadora() {
		
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public HashSet<ComponenteCPU> getComponentes() {
		return componentes;
	}
	
	public void setComponentes(HashSet<ComponenteCPU> componentes) {
		this.componentes = componentes;
	}
	
	public void agregarComponente(ComponenteCPU componente) {
		
		if (this.componentes == null) {
			
			this.componentes = new HashSet<ComponenteCPU>();
			
		}
		this.componentes.add(componente);
		
	}
	
	public double precioTotal() {
		
		double precioTotal = 0;
		
		for (ComponenteCPU c : componentes) {
			
			precioTotal += c.calculoSubTotal();
			
		}
		
		return precioTotal;
		
	}
	
	public String precioSugerido() {
		
		double precioVenta = precioTotal();
		
		if (precioTotal() < 50000) {
			
			precioVenta += precioTotal() * 0.4;
			
		} else {
			
			precioVenta += precioTotal() * 0.3;
			
		}
		
		return "El precio de venta sugerido es " + precioVenta;		
	}
	
}
