package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

public abstract class ACustomisableElementWrapper
{
	private Object element;
	
	public abstract void customise( ACustomisation customisation );
	
	public void setElement( Object element )
	{
		this.element=element;
	}
	
	public Object getElement( )
	{
		return element;
	}
	
	
}
