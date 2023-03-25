package hotel;

public class Cama
{
    private String tamanio;
    private int cantidadPersonas;
    private boolean ninios;
    
    public Cama(String tam, int cantidad) {
	tamanio = tam;
	cantidadPersonas = cantidad;
    }
    
    public void setNinios(boolean nin) {
	ninios = nin;
    }
    
    public boolean hasNinios() {
	return ninios;
    }
    
    public String getTamanio() {
	return tamanio;
    }
    
    public int getCantidadPersonas() {
	return cantidadPersonas;
    }

}
