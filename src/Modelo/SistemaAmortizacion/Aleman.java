/*
Instituto Tecnonlógico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/

package Modelo.SistemaAmortizacion;


public class Aleman extends SistemaAmortizacion {
    
    //Contructores de la clase
    
    public Aleman(double pMontoInicial, int pPeriodos, Double pInteresAnual, String pTipoMoneda) {
        super(pMontoInicial, pPeriodos, pInteresAnual, pTipoMoneda);
    }

    
    //Métodos de calculos de amortización
    @Override
    public String calcularTablaAmortizacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularAmortizacion(double pDeudaInicial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calcularCuota(double pCuentaInicial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
