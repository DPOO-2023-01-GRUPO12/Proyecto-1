package hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurante
{
    private String ubicacion;
    private Map<String, ArrayList<String>> disponibilidad;
    private ArrayList<Menu> menus;

    public Restaurante(String ubicacion)
    {
        this.ubicacion = ubicacion;
        this.disponibilidad = new HashMap<String,ArrayList<String>>();
        this.menus = new ArrayList<Menu>();
    }

    public String getUbicacion()
    {
        return ubicacion;
    }


    public void agregarDisponibilidad(String dia, ArrayList<String> horas)
    {
        disponibilidad.put(dia, horas);
    }

    public Map<String, ArrayList<String>> getDisponibilidad()
    {
        return disponibilidad;
    }

    public void agregarMenu(Menu menu)
    {
        menus.add(menu);
    }

    public ArrayList<Menu> getMenus()
    {
        return menus;
    }
}