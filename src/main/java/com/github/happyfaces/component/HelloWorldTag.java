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