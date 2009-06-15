/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import gui.Wizard;

import excepcion.XMLParseException;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.SAXException;

/** Clase principal del programa. Punto de entrada a la apliación.
 *
 *  @author Sergio
 */
public class Main {

    /** Método de entrada.
     *
     *  @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args)
    {
        Wizard wiz;
        SetupData setupData;

        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch(Exception ex) { }

        wiz = new Wizard();

        try
        {
            // Cargar los datos de la instalación
            setupData = loadSetupData();

            wiz.setSetupData(setupData);
            wiz.setVisible(true);
        }
        catch(ParserConfigurationException pcEx)
        {
            JOptionPane.showMessageDialog(null, "No se puede inicializar el parser XML, ha ocurrido un error interno\n" +
                    "por favor contacte al fabricane de la apliación. La instalación no puede continuar.",
                    "¡Ha ocurrido un error!", JOptionPane.ERROR_MESSAGE);

            wiz.dispose();
        }
        catch(SAXException saxEx)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error de parseo XML al leer el archivo de datos de la\n" +
                    "instalación. Por favor contacte al fabricante de la apliación. La siguiente es la información detallada\n" +
                    "del error:\n\n" + saxEx.getMessage() + "\n\nLa instalación no puede continuar", "¡Ha ocurrido un error!",
                    JOptionPane.ERROR_MESSAGE);

            wiz.dispose();
        }
        catch(IOException ioEx)
        {
            JOptionPane.showMessageDialog(null, "No se puede encontrar o leer el archivo de datos de la instalación.\n" +
                    "Por favor contacte al fabricante de la apliación. La instalación no puede continuar", "¡Ha ocurrido un error!",
                    JOptionPane.ERROR_MESSAGE);

            wiz.dispose();
        }
        catch(XMLParseException xmlPEx)
        {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error de parseo XML al leer el archivo de datos de la\n" +
                    "instalación. Por favor contacte al fabricante de la apliación. La siguiente es la información detallada\n" +
                    "del error:\n\n" + xmlPEx.getMessage() + "\n\nLa instalación no puede continuar", "¡Ha ocurrido un error!",
                    JOptionPane.ERROR_MESSAGE);

            wiz.dispose();
        }
    }

    /** Parsea el archivo setup.xml y carga de el los datos sobre la instalación.
     *
     *  @return Una estructura SetupData que contiene los datos de la instalación.
     *  @throws ParserConfigurationException Si no se puede crear el Parser XML.
     *  @throws IOException Si no se encuentra o no se puede leer el archivo setup.xml.
     *  @throws SAXException Si falla el parseo físico del archivo XML.
     *  @throws XMLParseException Si falla el parseo lógico del archivo XML.
     */
    
    private static SetupData loadSetupData() throws ParserConfigurationException, SAXException, IOException, XMLParseException
    {
        DocumentBuilderFactory dbf;
        NamedNodeMap attributes;
        String osPathSeparator;
        SetupData setupData;
        DocumentBuilder db;
        Document document;
        NodeList nodes;
        NodeList files;
        Node attribute;
        File setupXML;
        String value;
        Node node;
        Node text;
        int i;
        int n;

        osPathSeparator = System.getProperty("file.separator");
        setupXML = new File("setup.xml");

        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        document = db.parse(setupXML);
        document.getDocumentElement().normalize();

        // Nombre de la apliación
        nodes = document.getElementsByTagName("application_name");
        if(nodes.getLength() != 1)
        {
            throw new XMLParseException("Falta, o hay duplicados de la etiqueta obligatoria 'application_name'");
        }

        node = nodes.item(0);
        text = node.getFirstChild();
        if(text != null && text.getNodeType() == Node.TEXT_NODE)
        {
            value = text.getNodeValue();
        }
        else
        {
            throw new XMLParseException("Se esperaba un valor de texto para la etiqueta 'application_name'");
        }
        
        setupData = new SetupData();
        setupData.setApplicationName(value);

        // Licencia
        nodes = document.getElementsByTagName("licence");
        if(nodes.getLength() >= 1)
        {
            node = nodes.item(0);
            text = node.getFirstChild();
            if(text != null && text.getNodeType() == Node.TEXT_NODE)
            {
                value = text.getNodeValue();
                setupData.setLicence(value);
            }
            else
            {
                throw new XMLParseException("Se esperaba un valor de texto para la etiqueta 'licence'");
            }
        }

        // Carpeta de Destino
        nodes = document.getElementsByTagName("destination_folder");
        if(nodes.getLength() != 1)
        {
            throw new XMLParseException("Falta, o hay duplicados de la etiqueta obligatoria 'destination_folder'");
        }

        node = nodes.item(0);
        text = node.getFirstChild();
        if(text != null && text.getNodeType() == Node.TEXT_NODE)
        {
            value = text.getNodeValue();
            value = value.replace("|", osPathSeparator);
            setupData.setDestinationFolder(value);
        }
        else
        {
            throw new XMLParseException("Se esperaba un valor de texto para la etiqueta 'destination_folder'");
        }

        // Acceso directo en el escritorio
        nodes = document.getElementsByTagName("desktop_shortcut");
        if(nodes.getLength() > 1)
        {
            throw new XMLParseException("Hay duplicados de la etiqueta 'desktop_shortcut'");
        }
        else
        {
            if(nodes.getLength() == 0)
            {
                setupData.setDesktopShortcut(false);
            }
            else
            {
                node = nodes.item(0);
                attributes = node.getAttributes();
                attribute = attributes.getNamedItem("option");
                if(attribute != null)
                {
                    value = attribute.getNodeValue();
                    if(value.equals("true"))
                        setupData.setDesktopShortcut(true);

                    else if(value.equals("false"))
                        setupData.setDesktopShortcut(false);

                    else
                        throw new XMLParseException("Valor inválido para el atributo 'option' de la etiqueta 'desktop_shortcut' : '" + value + "'");
                }
                else
                {
                    throw new XMLParseException("No se proporcionó el atributo obligatorio 'option' de la etiqueta 'desktop_shortcut'");
                }

                text = node.getFirstChild();
                if(text != null && text.getNodeType() == Node.TEXT_NODE)
                {
                    value = text.getNodeValue();
                    value = value.replace("|", osPathSeparator);
                    setupData.setDesktopShortcutDestination(value);
                }
                else
                {
                    throw new XMLParseException("Se esperaba un valor de texto para la etiqueta 'desktop_shortcut'");
                }
            }
        }

        // Acceso directo en el menú de programas
        nodes = document.getElementsByTagName("programs_shortcut");
        if(nodes.getLength() > 1)
        {
            throw new XMLParseException("Hay duplicados de la etiqueta 'programs_shortcut'");
        }
        else
        {
            if(nodes.getLength() == 0)
            {
                setupData.setProgramsShortcut(false);
            }
            else
            {               
                node = nodes.item(0);
                attributes = node.getAttributes();
                attribute = attributes.getNamedItem("option");
                if(attribute != null)
                {
                    value = attribute.getNodeValue();
                    if(value.equals("true"))
                        setupData.setProgramsShortcut(true);

                    else if(value.equals("false"))
                        setupData.setProgramsShortcut(false);

                    else
                        throw new XMLParseException("Valor inválido para el atributo 'option' de la etiqueta 'programs_shortcut' : '" + value + "'");
                }
                else
                {
                    throw new XMLParseException("No se proporcionó el atributo obligatorio 'option' de la etiqueta 'programs_shortcut'");
                }

                text = node.getFirstChild();
                if(text != null && text.getNodeType() == Node.TEXT_NODE)
                {
                    value = text.getNodeValue();
                    value = value.replace("|", osPathSeparator);
                    setupData.setDesktopShortcutDestination(value);
                }
                else
                {
                    throw new XMLParseException("Se esperaba un valor de texto para la etiqueta 'programs_shortcut'");
                }
            }
        }

        // Archivos
        nodes = document.getElementsByTagName("files");

        if(nodes.getLength() != 1)
            throw new XMLParseException("Falta, o hay duplicados de la etiqueta obligatoria 'files'");

        node = nodes.item(0);
        files = node.getChildNodes();
        n = files.getLength();

        if(n < 1)
            throw new XMLParseException("No se encuentran etiquetas 'file' dentro de la etiqueta 'files'. Debe haber almenos 1.");

        for(i = 0; i < n; i++)
        {
            node = files.item(i);
            if(node.getNodeName().equals("file"))
            {
                text = node.getFirstChild();
                if(text != null && text.getNodeType() == Node.TEXT_NODE)
                {
                    value = text.getNodeValue();
                    value = value.replace("|", osPathSeparator);
                    setupData.getFilesToCopy().add(value);
                }
                else
                {
                    throw new XMLParseException("Se esperaba un valor de texto para la etiqueta 'file'");
                }
            }
        }

        if(setupData.getFilesToCopy().isEmpty())
            throw new XMLParseException("No se encuentran etiquetas 'file' dentro de la etiqueta 'files'. Debe haber almenos 1.");

        return setupData;
    }

}
