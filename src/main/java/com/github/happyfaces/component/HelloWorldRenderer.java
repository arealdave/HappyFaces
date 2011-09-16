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