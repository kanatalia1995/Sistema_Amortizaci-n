/*
Instituto Tecnológico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/
package Utilidades;

import Utilidades.Enumeraciones.*;

public class DTO {
    public String nombreCompleto;
    public double montoInicial;
    public int periodos;
    public double interesAnual;
    public TipoMoneda tipoMoneda;
    public TipoSistema tipoSistema;
    
    @Override
    public String toString(){
        String respuesta = "\nNombreCompleto = "+ this.nombreCompleto;
        respuesta+= "\n Monto Inicial = "+ String.valueOf(montoInicial);
        respuesta+= "\n periodos  = "+ String.valueOf(periodos);
        respuesta+= "\n InteresAnual = "+ String.valueOf(interesAnual);
        respuesta+= "\n TipoMoneda= "+ String.valueOf(tipoMoneda);
        respuesta+= "\n TipoSistema= "+ String.valueOf(tipoSistema);
        return respuesta;
    }
    
    public static  double convertirPorcentaje(double porcentaje){
        return (double)(porcentaje/100);
    }
}
