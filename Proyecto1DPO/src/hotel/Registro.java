package hotel;

import java.util.ArrayList;

public class Registro
{
    private boolean entrada;
    private ArrayList<Consumo> consumos;
    private ArrayList<Consumo> consumosPagados;
    private Huesped checkin;
    
    public void setEntrada(boolean en) {
	entrada = en;
    }
    
    public boolean isEntrada() {
	return entrada;
    }

}
