/*
Instituto Tecnológico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/
package Modelo.FabricaSistemaAmortizacion;

import Modelo.SistemaAmortizacion.Aleman;
import Modelo.SistemaAmortizacion.SistemaAmortizacion;
import Utilidades.DTO;


public class CreadorAleman implements CreadorSistemaAmortizacion {

    
   //Contructores
    
    //Contructor inicial
    
    @Override
    public SistemaAmortizacion crearSistemaAmortizacion(DTO pDatos) {
        return new Aleman(pDatos.montoInicial,pDatos.periodos,pDatos.interesAnual,pDatos.tipoMoneda.toString());
    }
    // Contructor = double pMontoInicial, int pPeriodos, Double pInteresAnual, String pTipoMoneda
    
    
}
