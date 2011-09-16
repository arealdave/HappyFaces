package com.github.happyfaces.component;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

public class CalendarTag extends UIComponentELTag {
	
	private ValueExpression value;
	
	@Override
    protected void setProperties(UIComponent component) {

		super.setProperties(component);
		
		if (component instanceof HelloWorldComponent) {
			if (value != null) {
				if (value.isLiteralText()) {
					((CalendarComponent)component).setValue(value.getExpressionString());
				} else {
					((CalendarComponent)component).setValueExpression("value", value);
				}
			}
		}         
    }

	public void setValue(ValueExpression value) {
		this.value = value;
	}
	
	public ValueExpression getValue() {
		return value;
	}
	
	@Override
	public String getComponentType() {
		return CalendarComponent.COMPONENT_FAMILY;
	}
	
	@Override
	public String getRendererType() {
		return CalendarRenderer.RENDERER_TYPE;
	}
}