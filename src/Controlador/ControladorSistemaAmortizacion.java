/*
Instituto Tecnológico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/
package Controlador;

import Adaptadores.FechaHoraSistema.FechaHoraSistema;
import Adaptadores.TipoCambio.TipoCambio;
import Controlador.Bitácora.Bitacora;
import Controlador.Bitácora.Registro;
import Controlador.Bitácora.XML;
import Modelo.Cliente.Cliente;
import Modelo.Cliente.Fisico;
import Modelo.FabricaSistemaAmortizacion.*;
import Modelo.FabricaSistemaAmortizacion.CreadorSistemaAmortizacion;
import Modelo.SistemaAmortizacion.SistemaAmortizacion;
import Utilidades.DTO;
import Utilidades.Enumeraciones.TipoMoneda;
import Utilidades.Enumeraciones.TipoSistema;

public class ControladorSistemaAmortizacion {
    
    //Atributos de la clase
     private Cliente cliente;
     private SistemaAmortizacion sistemaActual;
     private FechaHoraSistema fechaHora;
     private TipoCambio tipoCambio;
     private Registro registro;
    
    //Contructores de la clase controlador
    public ControladorSistemaAmortizacion(FechaHoraSistema pFechaHora, TipoCambio pTipoCambio){
        this.fechaHora = pFechaHora;
        this.tipoCambio = pTipoCambio;
        this.registro =  new Registro();
        this.asignarBitacoras();
    }
     //Métodos para crear Cliente y Sistema
     public void crearClienteSistema(DTO datos){
        if (verificarMoneda(datos.tipoMoneda)){
            datos.montoInicial = this.convertidorColonesDolares(datos.montoInicial);
        }
         this.crearCliente(datos.nombreCompleto);
         this.crearSistemaAlCliente(datos);
         this.registrarDatos(datos);
     }
     
     
    //Métodos públicos para obtener información
    public String obtenerInformacionAmortizacion() {  
        String respuesta = this.sistemaActual.obtenerInformacion();
        respuesta+= this.sistemaActual.calcularTablaAmortizacion();
        return respuesta;
    }
    
    public String obtenerTipoCambioCompra(){
        String tipoCompra="Tipo de cambio compra BCCR: "+String.valueOf(this.tipoCambio.getTipoCambio());
        return tipoCompra; 
    }
    
    public String obtenerfechaHoraSistema(){
        
         return this.fechaHora.getFechaHora();
    }

    
    
    //Métodos auxiliares para crear y asociar cliente con sistema de amortizacion;
    
    private void crearCliente(String pNombreCompleto) {
        this.cliente= new Fisico(pNombreCompleto);
    }
    
    private void crearSistemaAlCliente(DTO datos) {
        CreadorSistemaAmortizacion creador = this.obtenerCreador(datos.tipoSistema);
        this.sistemaActual = this.cliente.crearAmortizacion(creador,datos);
    }
    
    private boolean verificarMoneda(TipoMoneda pMoneda){
         return TipoMoneda.DOLARES.equals(pMoneda);
    }
    
    private double convertidorColonesDolares(Double pMontoInicial){
            double montoCompra=this.tipoCambio.getTipoCambio();
            return (pMontoInicial/montoCompra);   
    }
    
    private CreadorSistemaAmortizacion obtenerCreador(TipoSistema tipoSistema){
        switch(tipoSistema){
            case ALEMAN: return new CreadorAleman();
            case FRANCES:  return new CreadorFrances();
            case AMERICANO:  return new CreadorAmericano();
        }
        return null;
    }

    private void asignarBitacoras() {
        Bitacora xml = new XML();
        this.registro.agregarBitacora(xml);
    }

    private void registrarDatos(DTO datos) {
        registro.setRegistroActual(datos);
    }
}
