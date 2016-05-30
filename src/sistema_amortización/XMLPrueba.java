/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_amortización;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XMLPrueba {

    public static void main(String[] args) throws org.xml.sax.SAXException {
         Document document = null;
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);

            //Creación de elementos
            //creamos el elemento principal casa
            Element casa = document.createElement("Casa"); 
            //creamos un nuevo elemento. Casa contiene habitaciones
            Element habitacion= document.createElement("Habitacion");
            //creamos un nuevo elemento. Habitación tiene color
            Element color = document.createElement("Color"); 
            //Ingresamos la info. El color de esta habitación es azul
            Text valorColor = document.createTextNode("Azul"); 

            //Asignamos la versión de nuestro XML
            document.setXmlVersion("1.0"); 
            //Añadimos la casa al documento
            document.getDocumentElement().appendChild(casa); 
            //Añadimos el elemento hijo a la raíz
            casa.appendChild(habitacion); 
            //Añadimos elemento
            habitacion.appendChild(color); 
            //Añadimos valor
            color.appendChild(valorColor); 
            
             try {
                 guardaConFormato(document,"src/ArchivosXMl/BitacoraXML");
             } catch (IOException ex) {
                 Logger.getLogger(XMLPrueba.class.getName()).log(Level.SEVERE, null, ex);
             }
            AnadirCaracteristica("src/ArchivosXMl/BitacoraXML");
         }catch(ParserConfigurationException | DOMException e){
             //System.err.println("Error);
         }
    }
    public static void guardaConFormato(Document document, String URI) throws IOException{
    try {
        TransformerFactory transFact = TransformerFactory.newInstance();

        //Formateamos el fichero. Añadimos sangrado y la cabecera de XML
        transFact.setAttribute("indent-number", 3);
        Transformer trans = transFact.newTransformer();
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

        //Hacemos la transformación
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        DOMSource domSource = new DOMSource(document);
        trans.transform(domSource, sr);

        try(PrintWriter writer = new PrintWriter(new FileWriter(URI))) {
            writer.println(sw.toString());
        }
    } catch(IllegalArgumentException | TransformerException ex) {
    }
}
    public static void AnadirCaracteristica(String URI) throws org.xml.sax.SAXException{
    try {
        //Obtenemos el document del fichero XML existente
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File(URI));
        document.getDocumentElement().normalize();
        
        //Creamos un nuevo elemento en la casa
    Element terraza = document.createElement("Terraza");
    //Le añadimos una característica
    Element tamano = document.createElement("Tamano");
    //Le añadimos su valor
    Text valor = document.createTextNode("20m2");

    //Añadimos la información a la casa ya existente
    NodeList nodoRaiz = document.getDocumentElement().getElementsByTagName("Casa");
    nodoRaiz.item(0).appendChild(terraza);
    terraza.appendChild(tamano);
    tamano.appendChild(valor);
    guardaConFormato(document,"src/ArchivosXMl/BitacoraXML");
    } catch (ParserConfigurationException | IOException e) {
    }
        //Guardamos la nueva estructura la fichero XML
        

    

    //Guardamos la nueva estructura la fichero XML
}
}