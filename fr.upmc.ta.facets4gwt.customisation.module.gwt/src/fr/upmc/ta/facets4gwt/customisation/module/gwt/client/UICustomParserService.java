package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("UICustomParserService")
public interface UICustomParserService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static UICustomParserServiceAsync instance;
		public static UICustomParserServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(UICustomParserService.class);
			}
			return instance;
		}
	}
	
	CustomisationPool parseUICustomFile(String fileName);
}
