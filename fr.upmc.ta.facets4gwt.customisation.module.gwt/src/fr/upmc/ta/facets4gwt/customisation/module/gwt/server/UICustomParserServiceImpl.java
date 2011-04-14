package fr.upmc.ta.facets4gwt.customisation.module.gwt.server;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.CustomisationPool;
import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.ElementCustomisation;
import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.PropertyCustomisation;
import fr.upmc.ta.facets4gwt.customisation.module.gwt.client.UICustomParserService;

public class UICustomParserServiceImpl extends RemoteServiceServlet implements UICustomParserService {
	
	@Override
	public CustomisationPool parseUICustomFile(String fileName) {
		String content = this.getFileContentFromName(fileName);
		if (content == null)
		{
			return null;
		}
		
		CustomisationPool pool = CustomisationPool.getInstance();
		//Parser.getInstance().parseUICustom(content, pool);
		Parser.getInstance().parseUICustom(getStreamFromFile(fileName), pool);
		
		return pool;
	}
	
	private InputStream getStreamFromFile(String fileName)
	{
		return getServletContext().getResourceAsStream(fileName);
	}
	
	private String getFileContentFromName(String fileName)
	{
		InputStreamReader flog	= null;
		LineNumberReader llog	= null;
		String myLine		     = null;
		
		StringBuffer res = new StringBuffer();
		try{ 
			
			flog = new InputStreamReader(getServletContext().getResourceAsStream(fileName));
			llog = new LineNumberReader(flog);
			while ((myLine = llog.readLine()) != null) {
	                      res.append(myLine + "\n");
	                }
	        }catch (Exception e){
	               System.err.println("Error : "+e.getMessage());
	               return null;
	        }
	        return res.toString();
	}
}
