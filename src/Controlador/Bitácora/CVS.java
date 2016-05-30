/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Bitácora;

import Utilidades.DTO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CVS  extends Bitacora{
    //Atributos de la clase;
    
    private String archivoURL ="src/ArchivosXMl/BitacoraCVS";
    
    @Override
    public void actualizarRegistro() {
        DTO datos = this.registro.getRegistroActual();
        File archivo =  new File(this.archivoURL);
        if(!archivo.exists()){
            this.crearArchivo();
        }
        agregarFila(datos);
    }
    


    

    private void crearArchivo() {
        try {
            String encabezado= "Cliente    ;Monto del préstamo     ;Plazo  ;Interés Anual;Sistema de Amortización    ;Tipo de Moneda\n";
            BufferedWriter creado = null;
            creado = new BufferedWriter(new FileWriter(this.archivoURL));
            creado.close();
            //Agregar Encabezado;
            FileWriter fwriter = new FileWriter(archivoURL);
            fwriter.write('\ufeff'); //si no se escribe esto, excel no muestra bien el texto con tildes
            fwriter.write(encabezado);
            fwriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(CVS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarFila(DTO datos) {
        FileWriter fwriter = null;
        try {
            DecimalFormat decimales = new DecimalFormat("0.00");
            String fila = datos.nombreCompleto+";";
            fila += String.valueOf(decimales.format(datos.montoInicial))+";";
            fila += String.valueOf(datos.periodos)+";";
            fila += String.valueOf(datos.interesAnual*100)+";";
            fila += String.valueOf(datos.tipoSistema)+";";
            fila += String.valueOf(datos.tipoMoneda)+";\n";
            
            //Agregar al archivo
            fwriter = new FileWriter(archivoURL,true);
            fwriter.write('\ufeff'); //si no se escribe esto, excel no muestra bien el texto con tildes
            fwriter.write(fila);
            fwriter.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(CVS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fwriter.close();
            } catch (IOException ex) {
                Logger.getLogger(CVS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
