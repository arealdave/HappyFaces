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