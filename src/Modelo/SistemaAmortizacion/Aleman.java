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
        tablaAmortizacion+="Total\t\t\t"+String.valueOf(this.getInteresTotal())+"\t"+String.valueOf(this.getAmortizacion())+"\t"+String.valueOf(this.getCuotasTotales())+"\n\n\n";
        return tablaAmortizacion;
    }

    @Override
    public double calcularAmortizacion(double pDeudaInicial) {
        double amortizacion=pDeudaInicial/this.getPeriodos();
        return amortizacion;
    }

    @Override
    public double calcularCuota(double pCuentaInicial) {
        double interes=this.calcularInteres();
        this.actualizarMontoInteres(interes);
        double amortizacion=this.calcularAmortizacion(pCuentaInicial);
        double cuota=interes+amortizacion;
        this.actualizarAmortizacion(amortizacion);
        this.actualizarCuotasTotales(cuota);
        return cuota;
    }

    @Override
    public String obtenerInformacion() {
        String info="";
        info+="\nDatos de la consulta:\n";
        info+=this.getCliente().toString()+"\n";
        info+="Monto del préstamo otorgado: "+String.valueOf(this.getMontoInicial())+" de "+this.getTipoMoneda()+"\n";
        info+="Plazo del préstamo: "+String.valueOf(this.getPeriodos())+" años\n";
        info+="Interés Anual: "+String.valueOf(Math.round(this.getInteresAnual()*100))+"%\n";
        info+="Sistema de amortización: Alemán\n";
        return info;
    }
    
    
}
