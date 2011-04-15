package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;

public abstract class ACustomisableElementWrapper
{
	protected Object element;
	
	protected AdapterFactoryItemDelegator itemDelegator;
	
	public abstract void customise( ACustomisation customisation );
	
	public abstract void normalize();
	
	public void setElement( Object element )
	{
		this.element=element;
	}
	
	public Object getElement( )
	{
		return element;
	}
	
	public void setItemDelegator( AdapterFactoryItemDelegator itemDelegator )
	{
		this.itemDelegator=itemDelegator;
	}
	
	public AdapterFactoryItemDelegator getItemDelegator( )
	{
		return itemDelegator;
	}
}
