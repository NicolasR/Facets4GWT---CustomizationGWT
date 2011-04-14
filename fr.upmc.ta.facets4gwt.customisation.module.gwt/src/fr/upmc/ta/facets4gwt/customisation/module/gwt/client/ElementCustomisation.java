package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ElementCustomisation extends ACustomisation implements IsSerializable
{
	private String metaclass;
	
	/**
	 * @gwt.typeArgs <fr.upmc.ta.facets4gwt.customisation.module.gwt.client.PropertyCustomisation>
	 */
	private java.util.Set properties;
	
	private String metamodel;
	
	public ElementCustomisation()
	{
	}
	
	public void setMetaclass( String metaclass )
	{
		this.metaclass=metaclass;
	}
	
	public String getMetaclass( )
	{
		return metaclass;
	}
	
	/**
	 * 
	 * @gwt.typeArgs <fr.upmc.ta.facets4gwt.customisation.module.gwt.client.PropertyCustomisation>
	 */
	public void setProperties( java.util.Set properties )
	{
		this.properties=properties;
	}
	
	/**
	 * 
	 * @gwt.typeArgs <fr.upmc.ta.facets4gwt.customisation.module.gwt.client.PropertyCustomisation>
	 */
	public java.util.Set getProperties( )
	{
		return properties;
	}
	
	public void setMetamodel( String metamodel )
	{
		this.metamodel=metamodel;
	}
	
	public String getMetamodel( )
	{
		return metamodel;
	}
	
	
}
