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
        String tablaAmortizacion="Sistema de amortización: Alemán\n";
        tablaAmortizacion+="\nTabla de Amortizacion:\n";
        tablaAmortizacion+="\nPeriodo\tDeuda Inicial\tIntereses\tAmortizacion\tCuota\n\n";
        
        for (int i=1;i<=this.getPeriodos();i++){
            String montoActual=String.valueOf(this.getDeudaActual());
            String interesActual=String.valueOf(this.calcularInteres());
            String amortizacionActual=String.valueOf(calcularAmortizacion(this.getMontoInicial()));
            String cuota=String.valueOf(calcularCuota(this.getMontoInicial()));
            tablaAmortizacion+=String.valueOf(i)+"\t"+montoActual+"\t"+interesActual+"\t"+amortizacionActual+"\t"+cuota+"\n";             
        }
        tablaAmortizacion+="Total\t\t"+String.valueOf(this.getInteresTotal())+"\t"+String.valueOf(this.getAmortizacion())+"\t"+String.valueOf(this.getCuotasTotales())+"\n\n\n";
        return tablaAmortizacion;
    }

    @Override
    public double calcularAmortizacion(double pDeudaInicial) {
        double amortizacion=pDeudaInicial/this.getPeriodos();
        this.actualizarAmortizacion(amortizacion);
        return amortizacion;
    }

    @Override
    public double calcularCuota(double pCuentaInicial) {
        double interes=this.calcularInteres();
        this.actualizarMontoInteres(interes);
        double amortizacion=this.calcularAmortizacion(pCuentaInicial);
        this.actualizarAmortizacion(amortizacion);
        double cuota=interes+amortizacion;
        this.actualizarCuotasTotales(cuota);
        return cuota;
    }

    @Override
    public String obtenerInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
