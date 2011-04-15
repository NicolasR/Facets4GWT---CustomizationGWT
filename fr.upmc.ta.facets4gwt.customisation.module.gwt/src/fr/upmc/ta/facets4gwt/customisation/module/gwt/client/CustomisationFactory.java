package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import java.util.Set;

public class CustomisationFactory
{
	public static ElementCustomisation createElementCustomisation(String metamodelName, String metaclassName, Set customisationFeatures, Set properties)
	{
		ElementCustomisation element = new ElementCustomisation();
		element.setMetamodel(metamodelName);
		element.setMetaclass(metaclassName);
		element.setCustomisationFeatures(customisationFeatures);
		element.setProperties(properties);
		
		return element;
	}
	
	public static PropertyCustomisation createPropertyCustomisation(String metamodelName, String propertyName, Set customisationFeatures)
	{
		PropertyCustomisation prop = new PropertyCustomisation();
		prop.setName(propertyName);
		prop.setCustomisationFeatures(customisationFeatures);
		
		return prop;
	}
	
	public static CustomisationFeature createCustomisationFeature(String type, String value, CustomisationValueType valueType)
	{
		CustomisationFeature customisationFeature = new CustomisationFeature();
		customisationFeature.setValue(value);
		customisationFeature.setValueType(valueType);
		
		if (type.equals("label"))
		{
			customisationFeature.setType(CustomisationType.LABEL);
		}
		else if (type.equals("color"))
		{
			customisationFeature.setType(CustomisationType.COLOR);
		}
		return customisationFeature;
	}
}
