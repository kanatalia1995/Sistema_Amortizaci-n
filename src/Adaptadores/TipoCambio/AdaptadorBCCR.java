
package Adaptadores.TipoCambio;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;


public class AdaptadorBCCR  implements TipoCambio{

    @Override
   
    
   private final String urlBase = "http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsIndicadoresEconomicos.asmx/ObtenerIndicadoresEconomicos";
    
    private  URL formatoURL(String pIndicador, String pNombre, String pFechaInicio, String pFechaFinal, String pSubNiveles) throws MalformedURLException{
       String  urlTemp = this.urlBase+"?tcIndicador="+pIndicador+"&tcFechaInicio="+pFechaInicio+"&tcFechaFinal="+pFechaFinal+"&tcNombre="+pNombre+"&tnSubNiveles="+pSubNiveles;
       URL url = new URL(urlTemp);
       return url;
    }
    
    private  Document obtenerDocumento(URL pUrl) throws Exception{
        DocumentBuilderFactory constructor = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentoConstructor = constructor.newDocumentBuilder();
        Document documentoXML =  documentoConstructor.parse(pUrl.openStream());
        return documentoXML;
    }
    
     public double getTipoCambio() {
         String fecha = obtenerFechaActual();
         
        //this.formatoURL("317","ProyectoI","", urlBase, urlBase)
         return 0.0;
    }

    private String obtenerFechaActual() {
      Calendar fecha = Calendar.getInstance();

       String fechaString = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH))+"/"+
                String.valueOf(fecha.get(Calendar.MONTH)+1)+"/"+ String.valueOf(fecha.get(Calendar.YEAR));
       System.out.print(fechaString);
       return fechaString;
    }
    
}
