/*
Instituto Tecnonlógico de Costa Rica
Ingeniería en Computación
Diseño de Software- IC6821
Semestre I-2016
Katerine Molina Sánchez
Roberto Ortiz Salazar
*/

package Modelo.Cliente;
//Librerías y paquetes utilizados
import Modelo.FabricaSistemaAmortizacion.CreadorSistemaAmortizacion;
import Modelo.SistemaAmortizacion.*;
import Utilidades.DTO;

public abstract class Cliente {

   
    //Constructores de la clase
    
    //Métodos Implementados
    
    //public SistemaAmortizacion crearAmortizacion(CreadorSistemaAmortizador pCreador, DTO pDatos){ return null;}
    
    //Métodos abstractos
    public abstract String toString();
    
    // Crea el sistema deseado
    public SistemaAmortizacion crearAmortizacion(CreadorSistemaAmortizacion pCreador, DTO pDatos){
        SistemaAmortizacion sistema = pCreador.crearSistemaAmortizacion(pDatos);
        this.asociarClienteSistemaAmortizacion(sistema);
        return sistema;
    }
    //Métodos Privados
    
    //Asocia el cliente con el nuevo sistema creado;
    private void asociarClienteSistemaAmortizacion(SistemaAmortizacion pSistema){
        pSistema.setCliente(this);
    }
}
