package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import com.google.gwt.user.client.ui.Grid;

public class PropertyWrapper extends ACustomisableElementWrapper
{
	private Grid properties;
	
	private IItemPropertyDescriptor propertyDescriptor;
	
	private int index;
	
	public void setProperties( Grid properties )
	{
		this.properties=properties;
	}
	
	public Grid getProperties( )
	{
		return properties;
	}
	
	public void setPropertyDescriptor( IItemPropertyDescriptor propertyDescriptor )
	{
		this.propertyDescriptor = propertyDescriptor;
	}
	
	public IItemPropertyDescriptor getPropertyDescriptor( )
	{
		return propertyDescriptor;
	}
	
	public void setIndex( int index )
	{
		this.index=index;
	}
	
	public int getIndex( )
	{
		return index;
	}

	@Override
	public void customise(ACustomisation customisation) {
		PropertyCustomisation propertyCustomisation = (PropertyCustomisation)customisation;
		
		switch (propertyCustomisation.getType())
		{
		case LABEL:
			this.customiseProperyLabel(propertyCustomisation);
			break;
		case COLOR:
			this.customiseProperyColor(propertyCustomisation);
			break;
		default:
			break;
		}
	}
	
	private void customiseProperyLabel(PropertyCustomisation propertyCustomisation)
	{	
	}
	
	private void customiseProperyColor(PropertyCustomisation propertyCustomisation)
	{
	}
}
