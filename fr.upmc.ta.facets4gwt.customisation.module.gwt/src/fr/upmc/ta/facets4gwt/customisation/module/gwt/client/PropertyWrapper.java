package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class PropertyWrapper extends ACustomisableElementWrapper
{
	private Grid properties;
	
	private IItemPropertyDescriptor propertyDescriptor;
	
	private int index;
	
	private Widget widget = null;
	
	public Widget getWidget() {
		return widget;
	}

	public void setWidget(Widget widget) {
		this.widget = widget;
	}

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
		
		Label l = new Label(propertyDescriptor.getDisplayName(element));
		
		for(Object cf : propertyCustomisation.getCustomisationFeatures())
		{
			switch (((CustomisationFeature)cf).getType())
			{
			case LABEL:
				this.customiseProperyLabel((CustomisationFeature)cf, l);
				break;
			case COLOR:
				this.customiseProperyColor((CustomisationFeature)cf, l);
				break;
			default:
				break;
			}
		}
		
		if (widget == null)
		{
			this.properties.setWidget(index, 0, l);
		}
		this.properties.setWidget(index, 1, widget);
	}
	
	@Override
	public void normalize() {
		if (widget == null)
		{
			this.properties.setText(index, 0, propertyDescriptor.getDisplayName(element));
		}
		else
		{
			 this.properties.setWidget(index, 1, widget);
		}
		
	}
	
	private void customiseProperyLabel(CustomisationFeature cf, Label l)
	{
		if (widget == null)
		{
			l.setText(cf.getValue());
		}
	}
	
	private void customiseProperyColor(CustomisationFeature cf, Label l)
	{
		if (widget == null)
		{
			l.getElement().getStyle().setColor("rgb" + cf.getValue());
			
		}
		else
		{
			widget.getElement().getStyle().setColor("rgb" + cf.getValue());
		}
	}
}
