/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.pagos.p.core;

import co.edu.unicauca.pagos.p.common.IPago;
public class SistemaVenta {
    IPago pagoOption;
    
    public SistemaVenta(IPago anOption){
        pagoOption = anOption;
    }
    
    public String realizarPago(String ident, double valor){
        if(pagoOption.validar())
              pagoOption.procesar();
        return pagoOption.obtenerDetalle();
    }
}
