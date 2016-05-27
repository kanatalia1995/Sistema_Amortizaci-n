/*
Instituto Tecnonlógico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/
package Modelo.InterfazAmortizacion;


/*Interface calculoCuotas
Objetivo: Describir el comportamiento que deberán de seguir todas 
aquellas clases que deseen realizar calculos para las cuotas de un préstamo.
*/
public interface calculoCuotas {
    public abstract double  calcularAmortizacion(double pDeudaInicial);
    public abstract double calcularCuota(double pCuentaInicial);
}
