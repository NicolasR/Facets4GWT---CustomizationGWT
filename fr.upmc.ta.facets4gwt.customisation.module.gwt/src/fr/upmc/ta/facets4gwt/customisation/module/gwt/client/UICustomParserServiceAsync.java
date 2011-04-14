package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UICustomParserServiceAsync {

	void parseUICustomFile(String fileName, AsyncCallback<CustomisationPool> callback)
	throws IllegalArgumentException;
}
