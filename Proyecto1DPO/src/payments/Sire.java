package payments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sire extends PaymentMethod
{
    private static int numTrans = 1;
    
    public Sire(String[] datos)
    {
	super("Sire.json",datos[0],datos[1],String.valueOf(numTrans),datos[2],datos[3],datos[4]);
	numTrans+=1;
    }
    
}
