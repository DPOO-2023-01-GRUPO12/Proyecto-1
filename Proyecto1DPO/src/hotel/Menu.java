package hotel;

import java.util.ArrayList;

public class Menu {
    private int identificador;
    private ArrayList<ProductoMenu> productosMenu;
    private boolean servicioCuarto;
    private static int contadorMenus=0;

    public Menu() {
        identificador = contadorMenus;
        productosMenu = new ArrayList<ProductoMenu>();
        servicioCuarto = false;
        contadorMenus++;
        
    }

    public int getIdentificador() {
        return identificador;
    }
    
    public void agregarProductoMenu(ProductoMenu productoMenu) {
        productosMenu.add(productoMenu);
    }

    public ArrayList<ProductoMenu> getProductosMenu() {
        return productosMenu;
    }

    public void setServicioCuarto(boolean ser) {
        servicioCuarto = ser;
    }
        
    public boolean hasServicioCuarto() {
        return servicioCuarto;
    }
}
