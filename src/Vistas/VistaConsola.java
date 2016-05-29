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
            nombre = user_input.nextLine();
            
            double montoInicial;
            System.out.print("Ingrese el monto del préstamo: ");
            montoInicial = Double.parseDouble(user_input.nextLine());
            
            int periodos;
            System.out.print("Ingrese el período total en años: ");
            periodos = Integer.parseInt(user_input.nextLine());
            
            double interesAnual;
            System.out.print("Ingrese el interés anual: ");
            interesAnual = Double.parseDouble(user_input.nextLine());
            
            String tipoAmortizacion;
            System.out.print("Ingrese el monto del préstamo: ");
            tipoAmortizacion = user_input.nextLine();
            
            String tipoMoneda;
            System.out.print("Ingrese el tipo de moneda: ");
            tipoMoneda = user_input.nextLine();
        }
    }
}