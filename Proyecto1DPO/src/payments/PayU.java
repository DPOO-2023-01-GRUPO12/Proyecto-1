package payments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PayU extends PaymentMethod
{
    private static int numTrans = 1;
    public PayU(String[] datos)
    {
	super("PayU.txt",datos[0],datos[1],String.valueOf(numTrans),datos[2],datos[3],datos[4]);
	numTrans+=1;

    }

}
