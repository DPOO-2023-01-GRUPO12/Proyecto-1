package payments;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PayPal extends PaymentMethod
{
    
    private static int numTrans = 1;
    
    public PayPal(ArrayList<String> datos)
    {
	
	super("PayPal.log",datos.get(0),datos.get(1),String.valueOf(numTrans),datos.get(2),datos.get(3),datos.get(4));
	numTrans+=1;
    }
}
