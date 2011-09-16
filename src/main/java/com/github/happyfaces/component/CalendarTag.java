package com.github.happyfaces.component;

import javax.el.ValueExpression;
import javax.faces.webapp.UIComponentELTag;

public class CalendarTag extends UIComponentELTag {
	
	
	@Override
	public String getComponentType() {
		return CalendarComponent.COMPONENT_FAMILY;
	}
	
	@Override
	public String getRendererType() {
		return CalendarRenderer.RENDERER_TYPE;
	}
}