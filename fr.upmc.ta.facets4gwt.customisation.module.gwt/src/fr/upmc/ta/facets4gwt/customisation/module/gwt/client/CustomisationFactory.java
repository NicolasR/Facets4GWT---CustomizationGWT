package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import java.util.Set;

public class CustomisationFactory
{
	public static ElementCustomisation createElementCustomisation(String metamodelName, String metaclassName, String type, String value, CustomisationValueType valueType, Set properties)
	{
		ElementCustomisation element = new ElementCustomisation();
		element.setMetamodel(metamodelName);
		element.setMetaclass(metaclassName);
		
		element.setValue(value);
		element.setValueType(valueType);
		
		element.setProperties(properties);
		
		if (type.equals("label"))
		{
			element.setType(CustomisationType.LABEL);
		}
		else if (type.equals("color"))
		{
			element.setType(CustomisationType.COLOR);
		}
		
		return element;
	}
	
	public static PropertyCustomisation createPropertyCustomisation(String propertyName, String type, String value, CustomisationValueType valueType )
	{
		PropertyCustomisation prop = new PropertyCustomisation();
		prop.setName(propertyName);
		prop.setValue(value);
		prop.setValueType(valueType);
		
		if (type.equals("label"))
		{
			prop.setType(CustomisationType.LABEL);
		}
		else if (type.equals("color"))
		{
			prop.setType(CustomisationType.COLOR);
		}
		return prop;
	}
	
	
}
