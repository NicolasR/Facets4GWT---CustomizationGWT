package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;

public class ElementWrapper extends ACustomisableElementWrapper
{
	private StringBuilder stringBuilder;
	
	private AdapterFactoryItemDelegator itemDelegator;
	
	public void setItemDelegator( AdapterFactoryItemDelegator itemDelegator )
	{
		this.itemDelegator=itemDelegator;
	}
	
	public AdapterFactoryItemDelegator getItemDelegator( )
	{
		return itemDelegator;
	}
	
	public void setStringBuilder( StringBuilder stringBuilder )
	{
		this.stringBuilder = stringBuilder;
	}
	
	public StringBuilder getStringBuilder( )
	{
		return stringBuilder;
	}

	@Override
	public void customise(ACustomisation customisation) {
		ElementCustomisation elementCustomisation = (ElementCustomisation)customisation;
		
		switch (elementCustomisation.getType())
		{
		case LABEL:
			this.customiseElementLabel(elementCustomisation);
			break;
		case COLOR:
			this.customiseElementColor(elementCustomisation);
			break;
		default:
			break;
		}
	}

	private void customiseElementColor(ElementCustomisation elementCustomisation) {
		this.stringBuilder.append("<div style='color:rgb" + elementCustomisation.getValue() + ";>");
		this.stringBuilder.append(this.itemDelegator.getText(this.getElement()));
		this.stringBuilder.append("</div>");
	}

	private void customiseElementLabel(ElementCustomisation elementCustomisation) {
		this.stringBuilder.append(elementCustomisation.getValue());
	}
	
}
