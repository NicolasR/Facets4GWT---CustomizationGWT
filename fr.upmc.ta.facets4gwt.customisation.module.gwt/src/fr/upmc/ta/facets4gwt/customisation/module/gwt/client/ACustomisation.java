package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import java.util.Set;

import com.google.gwt.user.client.rpc.IsSerializable;

public abstract class ACustomisation implements IsSerializable
{
	/**
	 * @gwt.typeArgs <fr.upmc.ta.facets4gwt.customisation.module.gwt.client.CustomisationFeature>
	 */
	protected Set customisationFeatures; 
	
	private String metamodel;
	
	/**
	 * @gwt.typeArgs <fr.upmc.ta.facets4gwt.customisation.module.gwt.client.CustomisationFeature>
	 */
	public Set getCustomisationFeatures() {
		return customisationFeatures;
	}

	/**
	 * @gwt.typeArgs <fr.upmc.ta.facets4gwt.customisation.module.gwt.client.CustomisationFeature>
	 */
	public void setCustomisationFeatures(Set customisationFeatures) {
		this.customisationFeatures = customisationFeatures;
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
