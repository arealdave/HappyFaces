package com.github.happyfaces.component;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentELTag;

public class HelloWorldTag extends UIComponentELTag {
	
	private ValueExpression greeting;
	
	@Override
	public String getComponentType() {
		return HelloWorldComponent.COMPONENT_FAMILY;
	}
	
	@Override
	public String getRendererType() {
		return HelloWorldRenderer.RENDERER_TYPE;
	}
	
	public void setGreeting(ValueExpression greeting) {
		this.greeting = greeting;
	}
	
	public ValueExpression getGreeting() {
		return greeting;
	}
	
	@Override
	protected void setProperties(UIComponent component) {
		super.setProperties(component);
		
		if (component instanceof HelloWorldComponent) {
			if (greeting != null) {
				if (greeting.isLiteralText()) {
					((HelloWorldComponent)component).setGreeting(greeting.getExpressionString());
				} else {
					((HelloWorldComponent)component).setValueExpression("greeting", greeting);
				}
			}
		}
	}
}