package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

public interface ICustomisation
{
	void customise( ACustomisableElementWrapper wrapper );
	
	CustomisableElementWrapperFactory getCustomisableElementWrapperFactory( );
	
	
}
