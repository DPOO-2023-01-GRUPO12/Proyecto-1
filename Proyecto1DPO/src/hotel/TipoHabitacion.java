package hotel;

public class TipoHabitacion
{
    private String nombreTipo;
    private boolean vista;
    private boolean balcon;
    private boolean cocina;
    
    public TipoHabitacion(String nombre) {
	nombreTipo = nombre;
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
