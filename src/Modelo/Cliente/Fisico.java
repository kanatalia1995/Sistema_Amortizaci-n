/*
Instituto Tecnológico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/
package Modelo.Cliente;


public class Fisico extends Cliente  {
    //Atributos de la clase
    private String nombreCompleto;
    
    //Constructores de la clase
    public Fisico(String pNombreCompleto ){
        this.nombreCompleto = pNombreCompleto;
    }
    
    //Implementacion de métodos abstractos
    @Override
    public String toString() {
        String respuesta =  "Cliente:"+this.nombreCompleto;
        return respuesta;
    }
    
}
