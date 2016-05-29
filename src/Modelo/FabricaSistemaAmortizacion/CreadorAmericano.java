/*
Instituto Tecnológico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/
package Modelo.FabricaSistemaAmortizacion;

import Modelo.SistemaAmortizacion.Americano;
import Modelo.SistemaAmortizacion.SistemaAmortizacion;
import Utilidades.DTO;

public class CreadorAmericano  implements CreadorSistemaAmortizacion{

    
    //Contructores de la clase
    //Constructor inicial sin parámetros
    
    @Override
    public SistemaAmortizacion crearSistemaAmortizacion(DTO pDatos) {
        return new Americano(pDatos.montoInicial,pDatos.periodos,pDatos.interesAnual,pDatos.tipoMoneda.toString());
    }
    //Constructor = double pMontoInicial, int pPeriodos, Double pInteresAnual, String pTipoMoneda
}
