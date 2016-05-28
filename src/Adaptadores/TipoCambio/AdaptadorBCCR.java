
package Adaptadores.TipoCambio;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class AdaptadorBCCR  implements TipoCambio{

    
    private final String urlBase;

    public AdaptadorBCCR() {
        this.urlBase = "http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsIndicadoresEconomicos.asmx/ObtenerIndicadoresEconomicos";
    }
    
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
    @Override
     public double getTipoCambio() {
        try {
            String fecha = obtenerFechaActual();
            URL url = this.formatoURL("317","ProyectoI",fecha,fecha,"N");
            Document documento =  this.obtenerDocumento(url);
            return obtenerCompra(documento);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AdaptadorBCCR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AdaptadorBCCR.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    }

    private String obtenerFechaActual() {
      Calendar fecha = Calendar.getInstance();

       String fechaString = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH))+"/"+
                String.valueOf(fecha.get(Calendar.MONTH)+1)+"/"+ String.valueOf(fecha.get(Calendar.YEAR));
       return fechaString;
    }
    private double obtenerCompra(Document docXML){
        NodeList nodos = docXML.getElementsByTagName("INGC011_CAT_INDICADORECONOMIC");
        Element unNodo = (Element)nodos.item(0);

        NodeList lista = unNodo.getElementsByTagName("NUM_VALOR");
        
        return Double.parseDouble( lista.item(0).getTextContent());
        
       
    }
}

