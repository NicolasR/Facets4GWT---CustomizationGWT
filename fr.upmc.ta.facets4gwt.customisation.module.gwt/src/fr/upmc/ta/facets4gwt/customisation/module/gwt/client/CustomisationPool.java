package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class CustomisationPool implements IsSerializable
{
	private static CustomisationPool instance;
	
	/**
	 * 
	 * @gwt.typeArgs <fr.upmc.ta.facets4gwt.customisation.module.gwt.client.ElementCustomisation>
	 */
	private java.util.Set customisations;
	
	private CustomisationPool()
	{
	}
	
	public static CustomisationPool getInstance()
	{
		if (instance == null)
		{
			instance = new CustomisationPool();
		}
		return instance;
	}
	
	/**
	 * 
	 * @gwt.typeArgs <fr.upmc.ta.facets4gwt.customisation.module.gwt.client.ElementCustomisation>
	 */
	public void setCustomisations( java.util.Set customisations )
	{
		this.customisations=customisations;
	}
	
	/**
	 * 
	 * @gwt.typeArgs <fr.upmc.ta.facets4gwt.customisation.module.gwt.client.ElementCustomisation>
	 */
	public java.util.Set getCustomisations( )
	{
		return customisations;
	}
	
	
}
