/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Bitácora;

import Utilidades.DTO;

/**
 *
 * @author Katerine
 */
public abstract class Bitacora {
    //Atributos de la clase
    protected Registro registro;
    
    //Contructores de la clase
    //Contructor inicial BITACORA();
    
    public  void setRegistro(Registro pRegistro){
        this.registro = pRegistro;
    }
    
    public abstract  void actualizarRegistro();
}
