/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_amortización;

import Adaptadores.TipoCambio.AdaptadorBCCR;
import Modelo.FabricaSistemaAmortizacion.CreadorAleman;
import Modelo.FabricaSistemaAmortizacion.CreadorSistemaAmortizacion;
import Modelo.SistemaAmortizacion.SistemaAmortizacion;
import Utilidades.DTO;
import Utilidades.Enumeraciones.TipoMoneda;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

/**
 *
 * @author usuario
 */
public class Sistema_AmortizacionRob {
    private String urlBase = "http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsIndicadoresEconomicos.asmx/ObtenerIndicadoresEconomicos";
    
    public  URL formatURL(String pIndicador, String pNombre, String pFechaInicio, String pFechaFinal, String pSubNiveles) throws MalformedURLException{
       String  urlTemp = this.urlBase+"?tcIndicador="+pIndicador+"&tcFechaInicio="+pFechaInicio+"&tcFechaFinal="+pFechaFinal+"&tcNombre="+pNombre+"&tnSubNiveles="+pSubNiveles;
       URL url = new URL(urlTemp);
       return url;
    }
    
    public  Document getDocumentOfWS(URL pUrl) throws Exception{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        
        Document doc =  db.parse(pUrl.openStream());
        return doc;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //AdaptadorBCCR adpta = new AdaptadorBCCR();
        
        /*DTO datos = new DTO();
        datos.interesAnual=0.15;
        datos.montoInicial = 1000000;
        datos.periodos = 5;
        datos.tipoMoneda = TipoMoneda.COLONES;
        CreadorSistemaAmortizacion creador = new CreadorAleman();
        SistemaAmortizacion tipo = creador.crearSistemaAmortizacion(datos);
        System.out.print(tipo.calcularTablaAmortizacion());*/
        Modelo.SistemaAmortizacion.Aleman al=new Modelo.SistemaAmortizacion.Aleman(1000000, 5, 0.15, "colones");
        System.out.println(al.calcularTablaAmortizacion());
    }
}
