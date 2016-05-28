/*
Instituto Tecnonlógico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/

package Modelo.SistemaAmortizacion;


public class Frances extends SistemaAmortizacion{

    // Constructores de la clase
    public Frances(double pMontoInicial, int pPeriodos, Double pInteresAnual, String pTipoMoneda) {
        super(pMontoInicial, pPeriodos, pInteresAnual, pTipoMoneda);
    }

    
    // Métodos de calculo de Amortización
    @Override
    public String calcularTablaAmortizacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularAmortizacion(double pDeudaInicial) {
        Double cuota;
        Double interes;
        cuota=this.calcularCuota(pDeudaInicial);
        interes=this.calcularInteres();
        return cuota-interes;
    }

    @Override
    public double calcularCuota(double pCuentaInicial) {
        Double cuota;
        Double interes=this.getInteresAnual();
        Double periodo=(double) this.getPeriodos();
        Double monto=this.getMontoInicial();
        cuota=(interes/(1-(1/(Math.pow((1+interes),periodo)))))*monto;
        return cuota;
    }
    
}
