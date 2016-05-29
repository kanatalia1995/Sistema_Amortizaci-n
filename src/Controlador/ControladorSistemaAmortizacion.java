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
import Modelo.Cliente.Cliente;
import Modelo.Cliente.Fisico;
import Modelo.FabricaSistemaAmortizacion.*;
import Modelo.FabricaSistemaAmortizacion.CreadorSistemaAmortizacion;
import Modelo.SistemaAmortizacion.SistemaAmortizacion;
import Utilidades.DTO;
import Utilidades.Enumeraciones.TipoSistema;

public class ControladorSistemaAmortizacion {
    
    //Atributos de la clase
     private Cliente cliente;
     private SistemaAmortizacion sistemaActual;
     private FechaHoraSistema fechaHora;
     private TipoCambio tipoCambio;
    
    //Contructores de la clase controlador
    public ControladorSistemaAmortizacion(FechaHoraSistema pFechaHora, TipoCambio pTipoCambio){
        this.fechaHora = pFechaHora;
        this.tipoCambio = pTipoCambio;
    }
     //Métodos para crear Cliente y Sistema
     public void crearClienteSistema(DTO datos){
         this.crearCliente(datos.nombreCompleto);
         this.crearSistemaAlCliente(datos);
        //FALTA GUARDAR DATOS EN HISTÓRICOS!!!!!!!!
     }
     
     
    //Métodos públicos para obtener información
    public String obtenerInformacionAmortizacion() {  
        return this.sistemaActual.calcularTablaAmortizacion();
    }
    
    public String obtenerTipoCambioCompra(){
        return String.valueOf(this.tipoCambio.getTipoCambio()); 
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
    private CreadorSistemaAmortizacion obtenerCreador(TipoSistema tipoSistema){
        switch(tipoSistema){
            case ALEMAN: return new CreadorAleman();
            case FRANCES:  return new CreadorFrances();
            case AMERICANO:  return new CreadorAmericano();
        }
        return null;
    }
}
