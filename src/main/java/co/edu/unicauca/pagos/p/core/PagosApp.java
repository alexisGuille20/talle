/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package co.edu.unicauca.pagos.p.core;
import co.edu.unicauca.pagos.p.plug.in.PagoCriptoMoneda;
import co.edu.unicauca.pagos.p.plug.in.PagoTarjetaCredito;
import co.edu.unicauca.pagos.p.plug.in.PagoTransferenciaBancaria;
import co.edu.unicauca.pagos.p.plug.in.PasarelaPago;
//import co.edu.unicauca.pagos.pagosapp.domain.PagoCriptoMoneda;
//import edu.co.unicauca.pagos.pagosapp.domain.PagoTransferenciaBancaria;

/**
 *
 * @author ahurtado
 */
public class PagosApp {

    public static void main(String[] args) {
        PagoTransferenciaBancaria pago = new PagoTransferenciaBancaria("746453746452", 340000.0);

        if (pago.validar()) {
            pago.procesar();
            System.out.println("\n_______________Pago_______________|");
            System.out.println(pago.obtenerDetalle());
            System.out.println();
        } else {
            System.out.println("Numero de cuenta invalido.");
        }
        
        PagoCriptoMoneda pago1 = new PagoCriptoMoneda("1A2B3C4D5E");
        if (pago1.validar()) {
            System.out.println();
            pago1.procesar();
            System.out.println("\n_______________Transaccion CriptoModenas_______________|");
            System.out.println(pago1.obtenerDetalle());
        } else {
            System.out.println("Numero de cuenta invalido.");
        }
        
        PasarelaPago pasarela = new PasarelaPago();

        // Crear un pago con una tarjeta válida
        PagoTarjetaCredito pago2 = new PagoTarjetaCredito("1234567812345678", 250000.0, pasarela);
        System.out.println("\n_______________Transaccion TARJETA_______________|");
        System.out.println("Validando tarjeta...");
        
        if (pago2.validar()) {
            System.out.println("Tarjeta válida. Procesando pago...");
            pago2.procesar();
            System.out.println(pago2.obtenerDetalle());
        } else {
            System.out.println("Número de tarjeta inválido.");
        }
    }
}
