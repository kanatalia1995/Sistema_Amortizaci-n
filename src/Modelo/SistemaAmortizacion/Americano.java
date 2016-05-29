/*
Instituto Tecnonlógico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/

package Modelo.SistemaAmortizacion;


public class Americano extends SistemaAmortizacion {

    
    //Contructores de la clase
    public Americano(double pMontoInicial, int pPeriodos, Double pInteresAnual, String pTipoMoneda) {
        super(pMontoInicial, pPeriodos, pInteresAnual, pTipoMoneda);
    }

    // Métodos para calcular la amortización 
    @Override
    public String calcularTablaAmortizacion() {
        String tablaAmortizacion="Sistema de amortización: Americano\n";
        tablaAmortizacion+="\nTabla de Amortizacion:\n";
        tablaAmortizacion+="\nPeriodo\tDeuda Inicial\tIntereses\tAmortizacion\tCuota\n\n";
        
        for (int i=1;i<this.getPeriodos();i++){
            String montoActual=String.valueOf(this.getDeudaActual());
            String interesActual=String.valueOf(this.calcularInteres());
            String amortizacionActual=String.valueOf(calcularAmortizacion(0.0));
            String cuota=String.valueOf(calcularCuota(i));
            tablaAmortizacion+=String.valueOf(i)+"\t"+montoActual+"\t"+interesActual+"\t"+amortizacionActual+"\t"+cuota+"\n";
        }
        //Ultimos linea de la tabla
        String montoActual=String.valueOf(this.getDeudaActual());
        String interesActual=String.valueOf(this.calcularInteres());
        String amortizacionActual=String.valueOf(calcularAmortizacion(this.getMontoInicial()));
        String cuota=String.valueOf(calcularCuota(this.getPeriodos()));
        tablaAmortizacion+=String.valueOf(this.getPeriodos())+"\t"+montoActual+"\t"+interesActual+"\t"+amortizacionActual+"\t"+cuota+"\n";
        
        //Montos totales
        tablaAmortizacion+="Total\t\t\t"+String.valueOf(this.getInteresTotal())+"\t"+String.valueOf(this.getAmortizacion())+"\t"+String.valueOf(this.getCuotasTotales())+"\n\n\n";
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
        this.actualizarAmortizacion(resultado);
        this.actualizarCuotasTotales(cuota);
        return resultado;
    }

    @Override
    public double calcularCuota(double pCuentaInicial) {
        Double cuota;
        if (validar(pCuentaInicial)){
            cuota=this.getMontoInicial()+this.calcularInteres();
            //this.actualizarCuotasTotales(cuota);
            return cuota;
        }else{
            cuota=this.calcularInteres();
            //this.actualizarCuotasTotales(cuota);
            return cuota;
        }
        
    }
    
    private boolean validar(double pValor){
        if (pValor<this.getPeriodos()){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String obtenerInformacion() {
        String info="";
        info+="\nDatos de la consulta:\n";
        info+=this.getCliente().toString()+"\n";
        info+="Monto del préstamo otorgado: "+String.valueOf(this.getMontoInicial())+" de "+this.getTipoMoneda()+"\n";
        info+="Plazo del préstamo: "+String.valueOf(this.getPeriodos())+" años\n";
        info+="Interés Anual: "+String.valueOf(Math.round(this.getInteresAnual()*100))+"%\n";
        info+="Sistema de amortización: Americano\n";
        return info;
    }
    
}
