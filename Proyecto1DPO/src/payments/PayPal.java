package payments;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class PayPal extends PaymentMethod
{
    
    private static int numTrans = 1;
    
    public PayPal(String[] datos)
    {
	super("PayPal.log",datos[0],datos[1],String.valueOf(numTrans),datos[2],datos[3],datos[4]);
	numTrans+=1;
    }
}
