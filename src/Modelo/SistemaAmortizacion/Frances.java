/*
Instituto Tecnonlógico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/

package Modelo.SistemaAmortizacion;

import Adaptadores.TipoCambio.AdaptadorBCCR;

public class Frances extends SistemaAmortizacion{

    // Constructores de la clase
    public Frances(double pMontoInicial, int pPeriodos, Double pInteresAnual, String pTipoMoneda) {
        super(pMontoInicial, pPeriodos, pInteresAnual, pTipoMoneda);
    }

    
    // Métodos de calculo de Amortización
    @Override
    public String calcularTablaAmortizacion() {
        AdaptadorBCCR adpta = new AdaptadorBCCR();
        String tablaAmortizacion="Tipo de cambio compra BCCR: "+String.valueOf(adpta.getTipoCambio());
        tablaAmortizacion+="\nDatos de la consulta:\n";
        tablaAmortizacion+=this.getCliente().toString()+"\n";
        tablaAmortizacion+="Monto del préstamo otorgado: "+String.valueOf(this.getMontoInicial())+" de "+this.getTipoMoneda()+"\n";
        tablaAmortizacion+="Plazo del préstamo: "+String.valueOf(this.getPeriodos())+" años\n";
        tablaAmortizacion+="Interés Anual: "+String.valueOf(this.getInteresAnual()/* *100 en caso de que guardemos el interes como 0.15*/)+" %\n";
        tablaAmortizacion+=
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
