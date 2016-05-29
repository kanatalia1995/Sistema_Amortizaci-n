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
        tablaAmortizacion+="Roberto\n";//this.getCliente().toString()+"\n";
        tablaAmortizacion+="Monto del préstamo otorgado: "+String.valueOf(this.getMontoInicial())+" de "+this.getTipoMoneda()+"\n";
        tablaAmortizacion+="Plazo del préstamo: "+String.valueOf(this.getPeriodos())+" años\n";
        tablaAmortizacion+="Interés Anual: "+String.valueOf(this.getInteresAnual()*100)+"%\n";
        tablaAmortizacion+="Sistema de amortización: Francés\n";
        tablaAmortizacion+="\nTabla de Amortizacion:\n";
        tablaAmortizacion+="\nPeriodo\tDeuda Inicial\tIntereses\tAmortizacion\tCuota\n\n";
        
        for (int i=1;i<=this.getPeriodos();i++){
            String montoActual=String.valueOf(this.getDeudaActual());
            System.out.println(montoActual);
            String interesActual=String.valueOf(this.calcularInteres());
            System.out.println(interesActual);
            String amortizacionActual=String.valueOf(calcularAmortizacion(this.getMontoInicial()));
            System.out.println(amortizacionActual);
            String cuota=String.valueOf(calcularCuota(this.getMontoInicial()));
            System.out.println(cuota);
            tablaAmortizacion+=String.valueOf(i)+"\t"+montoActual+"\t"+interesActual+"\t"+amortizacionActual+"\t"+cuota+"\n";
            System.out.println("\n");
        }
        tablaAmortizacion+="Total\t\t"+String.valueOf(this.getInteresTotal())+"\t"+String.valueOf(this.getAmortizacion())+"\t"+String.valueOf(this.getCuotasTotales());
        return tablaAmortizacion;
    }

    @Override
    public double calcularAmortizacion(double pDeudaInicial) {
        Double cuota;
        Double interes;
        cuota=this.calcularCuota(pDeudaInicial);
        interes=this.calcularInteres();
        Double resultado=cuota-interes;
        this.actualizarAmortizacion(resultado);
        return resultado;
        
    }

    @Override
    public double calcularCuota(double pCuentaInicial) {
        Double cuota;
        Double interes=this.getInteresAnual();
        Double periodo=(double)this.getPeriodos();
        Double monto=this.getMontoInicial();
        cuota=(interes/(1-(1/(Math.pow((1+interes),periodo)))))*monto;
        this.actualizarCuotasTotales(cuota);
        return cuota;
    }
    
}
