/*
Instituto Tecnológico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/
package Modelo.FabricaSistemaAmortizacion;

//Librerías y Paquetes utilizados
import Modelo.SistemaAmortizacion.SistemaAmortizacion;
import Utilidades.DTO;

public interface CreadorSistemaAmortizacion {
    
    public SistemaAmortizacion crearSistemaAmortizacion(DTO pDatos);
}
