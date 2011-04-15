package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;

public class Customiser implements ICustomisation
{	
	public CustomisableElementWrapperFactory getCustomisableElementWrapperFactory()
	{
		return CustomisableElementWrapperFactory.getInstance();
	}
	
	public void render(ACustomisableElementWrapper wrapper)
	{
		ElementCustomisation ec = getElementCustomisation(wrapper.getItemDelegator().getText(wrapper.getElement()));
		
		if (wrapper instanceof ElementWrapper)
		{
			if (ec == null)
			{
				wrapper.normalize();
			}
			else
			{
				wrapper.customise(ec);
			}
		}
		else if (wrapper instanceof PropertyWrapper)
		{
			if (ec == null)
			{
				wrapper.normalize();
			}
			else
			{
				PropertyCustomisation pc = getPropertyCustomisation(ec, ((PropertyWrapper)wrapper).getPropertyDescriptor().getDisplayName(wrapper.getElement()));
				if (pc == null)
				{
					wrapper.normalize();
				}
				else
				{
					wrapper.customise(pc);
				}
			}
		}
	}
	
	private ElementCustomisation getElementCustomisation(String metaclassName)
	{
		ElementCustomisation res = null;
		for(Object obj : CustomisationPool.getInstance().getCustomisations())
		{
			ElementCustomisation ec = (ElementCustomisation)obj;
			if ( ec.getMetaclass().toLowerCase().contains(metaclassName.toLowerCase().split(" ")[0]) )
			{
				res = ec;
				break;
			}
		}
		return res;
	}
	
	private PropertyCustomisation getPropertyCustomisation(ElementCustomisation ec, String propertyName)
	{
		PropertyCustomisation res = null;
		for(Object obj : ec.getProperties())
		{
			PropertyCustomisation pc = (PropertyCustomisation)obj;
			if (pc.getName().toLowerCase().contains(propertyName.toLowerCase()))
			{
				res = pc;
				break;
			}
		}
		return res;
	}
}
