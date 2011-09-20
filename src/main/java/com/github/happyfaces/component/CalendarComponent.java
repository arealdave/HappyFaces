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

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;


@ResourceDependencies({
	@ResourceDependency(library="happyfaces", name="jquery/jquery.js"),
	@ResourceDependency(library="happyfaces", name="jquery/jquery-ui.js"),
	@ResourceDependency(library="happyfaces", name="jquery/css/ui-lightness/jquery-ui.css"),
})
public class CalendarComponent extends UIInput {

	public static final String COMPONENT_FAMILY = "CalendarComponentFamily";
	
    @Override
    public Object saveState(FacesContext context) {
       Object values[] = new Object[1];
       values[0] = super.saveState(context);
       return ((Object) (values));
   }

   @Override
   public void restoreState(FacesContext context, Object state) {
       Object values[] = (Object[])state;
       super.restoreState(context, values[0]);
   }
   
	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}
	
}