/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Bitácora;

import Utilidades.DTO;
import java.util.ArrayList;

/**
 *
 * @author Katerine
 */
public class Registro {
    
    //Atributos de la clase
    private DTO registroActual;
    private ArrayList<Bitacora> bitacoras;
    
    //Contructores de la clase
    //Constructor Inicial REGISTRO();
    public Registro(){
        this.bitacoras =  new ArrayList<Bitacora>();
    }
    
    // Métodos de la clase
    
    public void setRegistroActual(DTO pRegistroActual){
        this.registroActual = pRegistroActual;
        this.notificarBitacoras();
    }
    public DTO getRegistroActual(){
        return this.registroActual;
    }
    public void notificarBitacoras(){
        for (Bitacora bitacora : this.bitacoras){
            bitacora.actualizarRegistro();
        }
    }
    public void agregarBitacora(Bitacora pBitacora){
        this.bitacoras.add(pBitacora);
        pBitacora.setRegistro(this);
    }
}
