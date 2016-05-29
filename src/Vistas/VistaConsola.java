/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class VistaConsola{
    
    public void menuConsola(){
        while (true){
            Scanner user_input=new Scanner(System.in);
            
            
            String nombre;
            System.out.print("Ingrese su nombre: ");
            user_input.next();
            
            Double montoInicial;
            System.out.print("Ingrese el monto del préstamo: ");
            Double.parseDouble(user_input.next());
            
            Integer periodos;
            System.out.print("Ingrese el período total en años: ");
            Integer.parseInt(user_input.next());
            
            Double interesAnual;
            System.out.print("Ingrese el interés anual: ");
            Double.parseDouble(user_input.next());
            
            String tipoAmortizacion;
            System.out.print("Ingrese el monto del préstamo: ");
            user_input.next();
            
            String tipoMoneda;
            System.out.print("Ingrese el tipo de moneda: ");
            user_input.next();
        }
    }
}