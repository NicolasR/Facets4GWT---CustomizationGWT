package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public abstract class ACustomisation implements IsSerializable
{
	private CustomisationType type;
	
	private String value;
	
	private CustomisationValueType valueType;
	
	public void setType( CustomisationType type )
	{
		this.type=type;
	}
	
	public CustomisationType getType( )
	{
		return type;
	}
	
	public void setValue( String value )
	{
		this.value=value;
	}
	
	public String getValue( )
	{
		return value;
	}
	
	public void setValueType( CustomisationValueType valueType )
	{
		this.valueType=valueType;
	}
	
	public CustomisationValueType getValueType( )
	{
		return valueType;
	}
	
	
}
