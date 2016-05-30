/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaConsola;

import Adaptadores.FechaHoraSistema.AdaptadorChuky;
import Adaptadores.FechaHoraSistema.FechaHoraSistema;
import Adaptadores.TipoCambio.*;
import Controlador.ControladorSistemaAmortizacion;
import Utilidades.DTO;
import Utilidades.Enumeraciones.TipoMoneda;
import Utilidades.Enumeraciones.TipoSistema;
import java.net.ConnectException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class VistaConsola{
    
    
    public static DTO obtenerDatos(){
        try{
        Scanner user_input=new Scanner(System.in);
            DTO datos = new DTO();

            System.out.print("Ingrese su nombre: ");
            datos.nombreCompleto = user_input.nextLine();
            
            System.out.print("Ingrese el monto del préstamo: ");
            datos.montoInicial = Double.parseDouble(user_input.nextLine());
            
            System.out.print("Ingrese el período total en años: ");
            datos.periodos = Integer.parseInt(user_input.nextLine());
            
            System.out.print("Ingrese el interés anual: ");
            double interes= Double.parseDouble(user_input.nextLine());
            datos.interesAnual = DTO.convertirPorcentaje(interes);
            
            String tipoAmortizacion;
            System.out.print("Ingrese el sistema de amortización: ");
            tipoAmortizacion = user_input.nextLine();
            datos.tipoSistema = TipoSistema.valueOf(tipoAmortizacion.toUpperCase());
            
            
            String tipoMoneda;
            System.out.print("Ingrese el tipo de moneda: ");
            tipoMoneda = user_input.nextLine();
            datos.tipoMoneda = TipoMoneda.valueOf(tipoMoneda.toUpperCase());
             
            return datos;
            
        }catch (Exception e){
            System.out.print("No se puede realizar la consulta, dato(s) erróneo(s)");
            return null;
        }
    }
    public static void main(String[] args) {
        
        // Datos del controlador
        FechaHoraSistema fechaHora =  new AdaptadorChuky();
        //System.out.print(fechaHora.getFechaHora());
        TipoCambio cambio = new AdaptadorBCCR();
        ControladorSistemaAmortizacion controlador = new ControladorSistemaAmortizacion(fechaHora,cambio);
        boolean salida = true;
        while (salida){
            DTO datos = obtenerDatos();
            // mostrar los de consulta;
            if (datos!=null){
                 controlador.crearClienteSistema(datos);
                 //Mostrar datos obtenidos del controlador.
                 System.out.print("\n");
                 System.out.print(controlador.obtenerTipoCambioCompra());
                 System.out.print(controlador.obtenerInformacionAmortizacion());
                 System.out.print(controlador.obtenerfechaHoraSistema());
            }
            System.out.print("\n\n¿Desea realizar otra consulta?(1=Si,0=No)");
            
            //Procesa  respuesta 
            Scanner lectura = new Scanner(System.in);
            int respuesta = lectura.nextInt();
            if (respuesta==0) salida= false;
        }
    }
}