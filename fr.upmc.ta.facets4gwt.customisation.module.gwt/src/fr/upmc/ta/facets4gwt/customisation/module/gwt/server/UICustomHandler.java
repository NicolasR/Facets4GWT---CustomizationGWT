package fr.upmc.ta.facets4gwt.customisation.module.gwt.server;

import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.CustomisationFactory;
import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.CustomisationType;
import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.CustomisationValueType;
import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.ElementCustomisation;
import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.PropertyCustomisation;

public class UICustomHandler extends DefaultHandler {
	
	private PropertyCustomisation pc;
	private ElementCustomisation ec;
	private Set elementCustomisationSet;
	private Set propertyCustomisationSet;
	
	private boolean inTypes, inAttributes;
	private String metamodel;
	private String metaclass;
	private String type;
	private String attributeName;
	private String value;
	private CustomisationValueType valueType;
	
	public Set getElementCustomisationSet()
	{
		return this.elementCustomisationSet;
	}
	
	public UICustomHandler()
	{
		super();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if (qName.equals("uicustom:MetamodelView"))
		{
			this.elementCustomisationSet = new HashSet();
			this.metamodel = attributes.getValue("metamodelURI");
		}
		else if (qName.equals("types"))
		{
			this.propertyCustomisationSet = new HashSet();
			this.metaclass = attributes.getValue("metaclassName");
			this.inTypes = true;
		}
		else if (qName.equals("attributes"))
		{
			this.attributeName = attributes.getValue("attributeName");
			this.inAttributes = true;
			this.inTypes = false;
		}
		else if (qName.equals("customizedFeatures"))
		{
			this.type = attributes.getValue("customizedFeature");
		}
		else if (qName.equals("defaultValue"))
		{
			this.value = attributes.getValue("value");
			this.valueType = CustomisationValueType.STATIC;
		}
		else if (qName.equals("valueCalculator"))
		{
			this.valueType = CustomisationValueType.QUERY;
		}
		else
		{
			throw new SAXException("Unknown tag : " + qName);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals("uicustom:MetamodelView"))
		{
		}
		else if (qName.equals("types"))
		{
			this.elementCustomisationSet.add(ec);
			this.inTypes = false;
		}
		else if (qName.equals("attributes"))
		{
			this.propertyCustomisationSet.add(pc);
			this.inAttributes = false;
			this.inTypes = true;
		}
		else if (qName.equals("customizedFeatures"))
		{
			if (this.inTypes)
			{
				this.ec = CustomisationFactory.createElementCustomisation(metamodel, metaclass, type, value, valueType, propertyCustomisationSet);
			}
			else if (this.inAttributes)
			{
				this.pc = CustomisationFactory.createPropertyCustomisation(attributeName, type, value, valueType);
			}
		}
		else if (qName.equals("defaultValue"))
		{
		}
		else if (qName.equals("valueCalculator"))
		{
		}
		else
		{
			throw new SAXException("Unknown tag : " + qName);
		}
	}
	
}
