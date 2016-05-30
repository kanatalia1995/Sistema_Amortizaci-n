/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_amortización;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jaw2
 */
public class EscribirArchivo {
    public static void main(String args[]){
        
        try{
            
            String nombreArchivo = "src/ArchivosXMl/BitacoraCVS";
            
            String texto = "columna1;columna2;columna3\n";
            texto += "acá;allí;lejos";
            
            BufferedWriter creado = null;
            creado = new BufferedWriter(new FileWriter(nombreArchivo));
            try{
                try (FileWriter fwriter = new FileWriter(nombreArchivo)) {
                    fwriter.write('\ufeff'); //si no se escribe esto, excel no muestra bien el texto con tildes
                    fwriter.write(texto);
                    fwriter.flush();
                } //si no se escribe esto, excel no muestra bien el texto con tildes
            }catch (IOException e){
                Logger.getLogger(EscribirArchivo.class.getName()).log(Level.SEVERE, null, e);
            }
        }catch (IOException ex){
            Logger.getLogger(EscribirArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
