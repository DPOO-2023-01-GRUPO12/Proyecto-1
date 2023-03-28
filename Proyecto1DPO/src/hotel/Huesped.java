package hotel;

import java.util.ArrayList;

public class Huesped
{
    private String nombre;
    private String documento;
    private String correo;
    private String celular;
    private ArrayList<Servicio> serviciosUsados;
    private Registro checkout;
    private static ArrayList<Huesped> huespedes = new ArrayList<>();
    
    public Huesped(String nom, String doc, String cor, String cel) {
	nombre = nom;
	documento = doc;
	correo = cor;
	celular = cel;
    huespedes.add(this);
    }

    public String getNombre()
    {
	return nombre;
    }

    public String getDocumento()
    {
	return documento;
    }

    public String getCorreo()
    {
	return correo;
    }

    public String getCelular()
    {
	return celular;
    }

    public static ArrayList<Huesped> getHuespedes(){
        return huespedes;
    }
    
    
  

}
