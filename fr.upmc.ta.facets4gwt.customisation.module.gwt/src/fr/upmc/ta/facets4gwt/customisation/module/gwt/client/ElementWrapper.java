package fr.upmc.ta.facets4gwt.customisation.module.gwt.client;


public class ElementWrapper extends ACustomisableElementWrapper
{
	private StringBuilder stringBuilder;
	
	public void setStringBuilder( StringBuilder stringBuilder )
	{
		this.stringBuilder = stringBuilder;
	}
	
	public StringBuilder getStringBuilder( )
	{
		return stringBuilder;
	}

	@Override
	public void customise(ACustomisation customisation) {
		ElementCustomisation elementCustomisation = (ElementCustomisation)customisation;
		
		StringBuilder text = new StringBuilder();
		StringBuilder color = new StringBuilder();
		StringBuilder end = new StringBuilder();
		
		String[] splittedText = this.itemDelegator.getText(this.getElement()).split(" ");
		
		text.append(splittedText[0]);
		for (int i = 1; i < splittedText.length; i++) {
			end.append(" " + splittedText[i]);
		}
		
		for(Object cf : elementCustomisation.getCustomisationFeatures())
		{
			switch (((CustomisationFeature)cf).getType())
			{
			case LABEL:
				this.customiseElementLabel((CustomisationFeature)cf, text);
				break;
			case COLOR:
				this.customiseElementColor((CustomisationFeature)cf, color);
				break;
			default:
				break;
			}
		}
		
		if(color.length() == 0)
		{
			this.stringBuilder.append(text.toString());
			this.stringBuilder.append(end.toString());
		}
		else
		{
			this.stringBuilder.append(color.toString());
			this.stringBuilder.append(text.toString());
			this.stringBuilder.append(end.toString());
			this.stringBuilder.append("</div>");
		}
	}
	
	@Override
	public void normalize() {
		this.stringBuilder.append(this.itemDelegator.getText(this.getElement()));
	}

	private void customiseElementColor(CustomisationFeature cf, StringBuilder color) {
		color.append("<div style='color:rgb" + cf.getValue() + ";'>");
	}

	private void customiseElementLabel(CustomisationFeature cf, StringBuilder text) {
		text.delete(0, text.length());
		text.append(cf.getValue());
	}
	
}
