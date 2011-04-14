package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import com.google.gwt.user.client.ui.Grid;

public class CustomisableElementWrapperFactory
{
	private static CustomisableElementWrapperFactory instance;
	
	private CustomisableElementWrapperFactory()
	{
	}
	
	public ACustomisableElementWrapper createWrapper( Object element, StringBuilder stringBuilder, AdapterFactoryItemDelegator itemDelegator )
	{
		ElementWrapper elementWrapper = new ElementWrapper();
		elementWrapper.setElement(element);
		elementWrapper.setStringBuilder(stringBuilder);
		elementWrapper.setItemDelegator(itemDelegator);
		return elementWrapper;
	}
	
	public ACustomisableElementWrapper createWrapper( Object element, Grid properties, IItemPropertyDescriptor propertyDescriptor, int index )
	{
		return null;
	}
	
	public static CustomisableElementWrapperFactory getInstance( )
	{
		if (instance == null)
		{
			instance = new CustomisableElementWrapperFactory();
		}
		return instance;
	}
	
	
}
