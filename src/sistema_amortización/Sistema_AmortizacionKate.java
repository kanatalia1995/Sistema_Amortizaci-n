/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_amortización;

import Adaptadores.FechaHoraSistema.AdaptadorChuky;
import Adaptadores.TipoCambio.AdaptadorBCCR;
import Modelo.FabricaSistemaAmortizacion.*;
import Modelo.SistemaAmortizacion.Aleman;
import Modelo.SistemaAmortizacion.SistemaAmortizacion;
import Utilidades.DTO;
import Utilidades.Enumeraciones.TipoMoneda;
import Vistas.VistaConsola;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 *
 * @author Katerine
 */
public class Sistema_AmortizacionKate {
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
        DTO datos = new DTO();
        datos.interesAnual=2.0;
        datos.montoInicial = 30000;
        datos.periodos = 5;
        datos.tipoMoneda = TipoMoneda.COLONES;
         CreadorSistemaAmortizacion creador = new CreadorAleman();
         SistemaAmortizacion tipo = creador.crearSistemaAmortizacion(datos);
         //System.out.print(tipo);
        
         VistaConsola consola = new VistaConsola();
         consola.menuConsola();
        
    }
    
}
