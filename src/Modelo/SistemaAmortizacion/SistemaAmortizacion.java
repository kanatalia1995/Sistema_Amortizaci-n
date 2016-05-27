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
    private Double interesAnual;
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
    }
    
    
    //Métodos públicos e implementados
    
    
    public String toString(){
        return "";
    }
    
    public  double calcularInteres(){
        return 0.0;
    }
    
    // Métodos abstractos de la clase
    
    public abstract String calcularTablaAmortizacion();
    
    //Métodos de actualizaciones de variables
    
    private void actualizarAmortizacion(double pAmortizacion){
    }
    
    private  void actualizarCuotasTotales(double pCuota){
    }
    
    private void actualizarMontoInteres(double pMontoInteres){
    }
    
    private  void actualizarDeudaActual(double pMonto){
    }
    
    //Métodos de acceso a atributos
    
    public void  setCliente(Cliente pCliente){
        this.cliente = pCliente;
    }
    
}
