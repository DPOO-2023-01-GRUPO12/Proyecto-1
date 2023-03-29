package hotel;

public class TipoHabitacion
{
    private static int contadorTipos;
    private int identificador;
    
    private String nombreTipo;
    private boolean vista;
    private boolean balcon;
    private boolean cocina;
    
    public TipoHabitacion(String nombre) {
    identificador = contadorTipos;
	nombreTipo = nombre;
    vista = false;
    balcon = false;
    cocina = false;
    contadorTipos++;
    }

    public int getIdentificador() {
        return identificador;
    }
    
    public String getTipo() {
	return nombreTipo;
    }
    
    public void setVista(boolean vis) {
	vista = vis;
    }
    
    public void setCocina(boolean co) {
	cocina = co;
    }
    
    public void setBalcon(boolean bal) {
	balcon = bal;
    }
    
    public boolean hasVista() {
	return vista;
    }
    
    public boolean hasCocina() {
	return cocina;
    }
    
    public boolean hasBalcon() {
	return balcon;
    }

}
