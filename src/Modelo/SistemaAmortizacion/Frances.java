/*
Instituto Tecnonlógico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/

package Modelo.SistemaAmortizacion;

import Adaptadores.FechaHoraSistema.AdaptadorChuky;
import Adaptadores.TipoCambio.AdaptadorBCCR;

public class Frances extends SistemaAmortizacion{

    // Constructores de la clase
    public Frances(double pMontoInicial, int pPeriodos, Double pInteresAnual, String pTipoMoneda) {
        super(pMontoInicial, pPeriodos, pInteresAnual, pTipoMoneda);
    }

    
    // Métodos de calculo de Amortización
    @Override
    public String calcularTablaAmortizacion() {
        String tablaAmortizacion="";
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
        Double cuota;
        Double interes;
        cuota=this.calcularCuota(pDeudaInicial);
        interes=this.calcularInteres();
        Double resultado=cuota-interes;
        this.actualizarMontoInteres(interes);
        this.actualizarCuotasTotales(cuota);
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
        return cuota;
    }
    
    public String obtenerTipoCompra(){
        AdaptadorBCCR adpta = new AdaptadorBCCR();
        String tipoCompra="Tipo de cambio compra BCCR: "+String.valueOf(adpta.getTipoCambio());
        return tipoCompra;
    }
    
    public String obtenerInformacion(){
        String info="";
        info+="\nDatos de la consulta:\n";
        info+=this.getCliente().toString()+"\n";
        info+="Monto del préstamo otorgado: "+String.valueOf(this.getMontoInicial())+" de "+this.getTipoMoneda()+"\n";
        info+="Plazo del préstamo: "+String.valueOf(this.getPeriodos())+" años\n";
        info+="Interés Anual: "+String.valueOf(Math.round(this.getInteresAnual()*100))+"%\n";
        info+="Sistema de amortización: Francés\n";
        return info;
    }
    
    public String contactarChucky(){
        String info="";
        AdaptadorChuky adp =  new AdaptadorChuky();
        System.out.println(adp.getFechaHora());
        return info;
    }
}
