/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_amortización;

import Adaptadores.TipoCambio.AdaptadorBCCR;
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
public class Sistema_Amortizacion {
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
        /*AdaptadorBCCR adpta = new AdaptadorBCCR();
        System.out.print(adpta.getTipoCambio());*/
        VistaConsola vc = new VistaConsola();
        vc.menuConsola();
    }
    
}
