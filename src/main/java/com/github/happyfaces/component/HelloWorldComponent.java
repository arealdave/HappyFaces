package com.github.happyfaces.component;

import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

@FacesComponent("HelloWorldComponentFamily")
public class HelloWorldComponent extends UIComponentBase {

	public static final String COMPONENT_FAMILY = "HelloWorldComponentFamily";
	
	private String greeting;
	
	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	public String getGreeting() {
		if (greeting != null)
			return greeting;
		
		ValueExpression ve = getValueExpression("greeting");
		if (ve != null) {
			return (String)ve.getValue(getFacesContext().getELContext());
		} else {
			return greeting;
		}
	}
}