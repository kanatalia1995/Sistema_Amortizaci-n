/*
Instituto Tecnológico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/
package Modelo.FabricaSistemaAmortizacion;

import Modelo.SistemaAmortizacion.Frances;
import Modelo.SistemaAmortizacion.SistemaAmortizacion;
import Utilidades.DTO;

public class CreadorFrances implements CreadorSistemaAmortizacion {

    
    //Contructores de la clase
    //** Constructor inicial sin parámetros
    
    //Creador
    @Override
    public SistemaAmortizacion crearSistemaAmortizacion(DTO pDatos) {
        return new Frances(pDatos.montoInicial,pDatos.periodos,pDatos.interesAnual,pDatos.tipoMoneda.toString());
    }
    
}
