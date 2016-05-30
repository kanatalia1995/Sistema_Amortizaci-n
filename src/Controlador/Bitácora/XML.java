/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Bitácora;

import Utilidades.DTO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.text.DecimalFormat;
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
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;


public class XML extends Bitacora {
    private String urlArchivo = "src/ArchivosXMl/BitacoraXML";

    
    @Override
    public void actualizarRegistro() {
        DTO datos = this.registro.getRegistroActual();
        File archivo =  new File(this.urlArchivo);
        Document documento = null;
       //Si la estructura no existe
        if(!archivo.exists()) {
            BufferedWriter creado = null;
            try {
                creado = new BufferedWriter(new FileWriter(archivo));
                documento = this.crearDocumentoBase();
            } catch (IOException ex) {
                Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    creado.close();
                } catch (IOException ex) {
                    Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else documento = this.abrirDocumentoBase();
        //Asignar Datos a la estructura
        this.crearEstructura(documento,datos);
        //Guardar el nuevo Registro;
        this.guardarRegistro(documento);
        
    }
    
    
    private Document crearDocumentoBase(){
        try {
            //Se crea el documento donde se almacenará la estructura
            Document document = null;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            //Asignamos la versión al XML
            document.setXmlVersion("1.0"); 
            Element clientes = document.createElement("Clientes");
            document.getDocumentElement().appendChild(clientes); 
            return document;
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private Document abrirDocumentoBase(){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File(this.urlArchivo));
            document.getDocumentElement().normalize();
            return document;
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Document crearEstructura(Document document,DTO datos){
        //Creación de elementos
            Element Cliente = document.createElement("Cliente");
            Cliente.setAttribute("Nombre",datos.nombreCompleto);
            
            DecimalFormat decimales = new DecimalFormat("0.00");
            Element montoInicial= document.createElement("Monto_préstamo");
            Text txtMontoInicial =document.createTextNode(decimales.format(datos.montoInicial));
            montoInicial.appendChild(txtMontoInicial);
            Cliente.appendChild(montoInicial);
            
            Element periodo = document.createElement("Plazo");
            Text txtPeriodo =document.createTextNode(String.valueOf(datos.periodos));
            periodo.appendChild(txtPeriodo);
            Cliente.appendChild(periodo);
            
            Element tasaInteres = document.createElement("Tasa_Interés");
            Text txtTasaInteres =document.createTextNode(String.valueOf(datos.interesAnual*100));
            tasaInteres.appendChild(txtTasaInteres);
            Cliente.appendChild(tasaInteres);
            
            Element tipoSistema = document.createElement("Sistema_Amortización");
            Text txtTipoSistema =document.createTextNode(String.valueOf(datos.tipoSistema));
            tipoSistema.appendChild(txtTipoSistema);
            Cliente.appendChild(tipoSistema);
            
            Element tipoMoneda  = document.createElement("Tipo_Moneda");
            Text txtTipoMoneda = document.createTextNode(String.valueOf(datos.tipoMoneda));
            tipoMoneda.appendChild(txtTipoMoneda);
            Cliente.appendChild(tipoMoneda);
            
            document.getDocumentElement().appendChild(Cliente);
            NodeList nodoRaiz = document.getDocumentElement().getElementsByTagName("Clientes");
            nodoRaiz.item(0).appendChild(Cliente);
            
           return document;
    }
       
    
    private void guardarRegistro(Document document){
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

        try(PrintWriter writer = new PrintWriter(new FileWriter(this.urlArchivo))) {
            writer.println(sw.toString());
        }  catch (IOException ex) {
               Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
           }
    } catch(IllegalArgumentException | TransformerException ex) {
    }   
    }
    
}
