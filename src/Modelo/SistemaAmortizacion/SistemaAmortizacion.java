/*
Instituto Tecnonlógico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/


package Modelo.SistemaAmortizacion;

//Librerías y paquetes utilizados
import Modelo.InterfazAmortizacion.calculoCuotas;
import Modelo.Cliente.Cliente;

public  abstract class SistemaAmortizacion implements calculoCuotas{
    // Atributos de la clase
    
    private double montoInicial;
    private int periodos;
    private double interesAnual;
    private String tipoMoneda;
    private double deudaActual;
    private double interesTotal;
    private double amortizacion;
    private double cuotasTotales;
    private Cliente cliente;
    
    //Constructores de clase

    public SistemaAmortizacion(double pMontoInicial, int pPeriodos, Double pInteresAnual, String pTipoMoneda) {
        this.montoInicial = pMontoInicial;
        this.periodos = pPeriodos;
        this.interesAnual = pInteresAnual;
        this.tipoMoneda = pTipoMoneda;
        this.deudaActual = pMontoInicial;
        this.interesTotal = 0;
        this.amortizacion = 0;
        this.cuotasTotales = 0;
    }
    
    
    //Métodos públicos e implementados
    
    
    public String toString(){
        String respuesta = String.valueOf(this.interesAnual)+String.valueOf(this.montoInicial)+String.valueOf(this.interesAnual)+String.valueOf(this.periodos);
        return respuesta;
    }
    
    public double calcularInteres(){
        Double interes=this.deudaActual*this.interesAnual;
        return interes;
    }
    
    // Métodos abstractos de la clase
    
    public abstract String calcularTablaAmortizacion();
    
    //Métodos de actualizaciones de variables
    
    public void actualizarAmortizacion(double pAmortizacion){
        this.amortizacion+=pAmortizacion;
        this.actualizarDeudaActual(pAmortizacion);
    }
    
    public  void actualizarCuotasTotales(double pCuota){
        this.cuotasTotales+=pCuota;
    }
    
    public void actualizarMontoInteres(double pMontoInteres){
        this.interesTotal+=pMontoInteres;
    }
    
    public  void actualizarDeudaActual(double pMonto){
        this.deudaActual-=pMonto;
    }
    
    //Métodos de acceso a atributos
    
    public void  setCliente(Cliente pCliente){
        this.cliente = pCliente;
    }

    public Double getInteresAnual() {
        return interesAnual;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public int getPeriodos() {
        return periodos;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public double getDeudaActual() {
        return deudaActual;
    }

    public double getInteresTotal() {
        return interesTotal;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public double getCuotasTotales() {
        return cuotasTotales;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
}
