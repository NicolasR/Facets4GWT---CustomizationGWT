package fr.upmc.ta.facets4gwt.customisation.module.gwt.server;

import java.io.InputStream;

import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.CustomisationPool;

public interface IParser
{
	void parseUICustom(InputStream file, CustomisationPool customisationPool);
}
