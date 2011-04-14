package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PropertyCustomisation extends ACustomisation  implements IsSerializable
{
	private String name;
	
	public PropertyCustomisation()
	{
	}
	
	public void setName( String name )
	{
		this.name=name;
	}
	
	public String getName( )
	{
		return name;
	}
	
	
}
