package fr.upmc.ta.facets4gwt.customisation.module.gwt.server;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.XMLParser;

import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.CustomisationPool;


public class Parser implements IParser
{
	private static IParser instance;
	
	private Parser()
	{
	}
	
	public static IParser getInstance()
	{
		if (instance == null)
		{
			instance = new Parser();
		}
		return instance;
	}
	
	public void parseUICustom(InputStream file, CustomisationPool customisationPool)
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			UICustomHandler handler = new UICustomHandler();
			parser.parse(file, handler);
			customisationPool.setCustomisations(handler.getElementCustomisationSet());
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		String metamodelName = null;
//		
//		Document doc = XMLParser.parse(file);
//		
//		Node n = doc.getElementsByTagName("uicustom:MetamodelView").item(0);
//		System.out.println(((Element)n).getAttribute("metamodelURI"));
	}
}
