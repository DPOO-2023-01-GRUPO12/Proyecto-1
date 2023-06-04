package payments;


public class Pago
{
    private PaymentMethod metodoPago;
    
    public Pago(String tipo, String[] datos) {
	try{
	    Class clase = Class.forName(tipo);
	    metodoPago = (PaymentMethod) clase.getDeclaredConstructor(null).newInstance(datos); 
	    metodoPago.guardarLog();
	    
	}   catch (ClassNotFoundException e)   {
	    System.out.println("No existe la clase " + metodoPago);
	    
	}   catch (Exception e)   {    
	    System.out.println("Hubo otro error construyendo la agenda telefónica: " + e.getMessage());    
	    e.printStackTrace();   
	}
	
    }

}
