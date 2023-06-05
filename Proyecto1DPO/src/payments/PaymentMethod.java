package payments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class PaymentMethod
{
    private String nombre;
    private String identificacion;
    private String monto;
    private String numTarjeta;
    private String numCuenta;
    private String numeroTransaccion;
    private String pathFile;
    
    public PaymentMethod(String path, String persona, String identificacion, String numeroTransaccion, String numeroCuenta, String numTarjeta, String monto )
    {
	nombre = persona;
	this.identificacion = identificacion;
	this.monto = monto;
	numCuenta = numeroCuenta;
	this.numTarjeta = numTarjeta;
	this.numeroTransaccion = numeroTransaccion;
	pathFile = path;
    }
    public void guardarLog()
    {
	String transaccion = "Datos: " + nombre + ", Identificacion: " + identificacion + "Transaccion: " + numeroTransaccion + ", Cuenta: " + numCuenta + ", Tarjeta: " + numTarjeta+ ", Monto: " + monto;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile, true))) {
            writer.write(transaccion);
            writer.newLine();
            System.out.println("Transacción guardada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la transacción: " + e.getMessage());
        }
        
    }
}
