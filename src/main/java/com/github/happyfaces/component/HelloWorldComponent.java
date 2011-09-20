/*
 * Copyright 2011 arealdave@gmail.com
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
	
	@Override
	public String getRendererType() {
		return HelloWorldRenderer.RENDERER_TYPE;
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