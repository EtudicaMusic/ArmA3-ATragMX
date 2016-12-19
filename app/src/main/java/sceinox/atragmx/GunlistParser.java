package sceinox.atragmx;


import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class GunlistParser {
    private Context context;
    private Document xml;

    public GunlistParser(Context context) {
        this.context = context;
        // System.out.println("happend");
        //loadDoc();
    }

    private void loadDoc() {
        System.out.println("AB HIER KOENNTE EIN FEHLER GESCHEHEN!");
        System.out.println("-------------------------------------");

        File dir = new File("/");
        System.out.println("SPAKCUNG");
        String[] files = dir.list();
        if (files.length == 0) {
            System.out.println("dat fuckt rum und is leer");
        } else {
            for (String str : files) {
                System.out.println(str);
            }
        }

        System.out.println("-------------------------------------");
        System.out.println("ENDE DES INTERESSANTEN GEBIETES");
/*
            File xmlFile = new File("../../../res/values/gunstatistics.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            xml = dBuilder.parse(xmlFile);

            xml.getDocumentElement().normalize();

            NodeList nodeList = xml.getElementsByTagName("sting-array");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                System.out.println("\nCurrent Element :" + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    System.out.println(element.getAttribute("name"));

                    NodeList attrList = element.getElementsByTagName("item");

                    for (int j = 0; j < attrList.getLength(); j++) {
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element attr = (Element) attrList.item(j);
                            System.out.println(attr.getNodeName());
                            System.out.println(attr.getNodeValue());
                        }
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}

