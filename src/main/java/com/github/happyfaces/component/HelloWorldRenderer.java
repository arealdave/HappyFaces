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

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(rendererType="HelloWorldRenderer", componentFamily="HelloWorldComponentFamily")
public class HelloWorldRenderer extends Renderer {
	
	public static final String RENDERER_TYPE="HelloWorldRenderer";
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		
		String greeting = "stranger";
		
		if (component instanceof HelloWorldComponent) {
			greeting = ((HelloWorldComponent)component).getGreeting();
		}
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", component);
        writer.writeAttribute("style", "color: red", null);
        writer.writeText("HelloWorld "+greeting, null);
        writer.endElement("div");
    }
}