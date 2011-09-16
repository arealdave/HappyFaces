package com.github.happyfaces.component;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponentBase;


@ResourceDependencies({
	@ResourceDependency(library="happyfaces", name="jquery/jquery.js"),
	@ResourceDependency(library="happyfaces", name="jquery/jquery-ui.js"),
	@ResourceDependency(library="happyfaces", name="jquery/css/ui-lightness/jquery-ui.css"),
})
public class CalendarComponent extends UIComponentBase {

	public static final String COMPONENT_FAMILY = "CalendarComponentFamily";
	
	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
}