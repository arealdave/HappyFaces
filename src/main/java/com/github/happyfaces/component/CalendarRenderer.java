package com.github.happyfaces.component;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class CalendarRenderer extends Renderer {

	public static final String RENDERER_TYPE = "CalendarRenderer";

	@Override
	public void decode(FacesContext context, UIComponent component) {
		/* Grab the request map from the external context */
		Map requestMap = context.getExternalContext().getRequestParameterMap();
		/* Get client ID, use client ID to grab value from parameters */
		String clientId = component.getClientId(context)+"_input";
		//String valueParam = (String) requestMap.get(clientId)+"_input";
		String value = context.getExternalContext().getRequestParameterMap().get(clientId);

		CalendarComponent calendarComponent = (CalendarComponent) component;
		/* Set the submitted value */
		calendarComponent.setSubmittedValue(value);
	}

	@Override
	public void encodeBegin(FacesContext context, UIComponent component)
			throws IOException {
		CalendarComponent calendar = (CalendarComponent) component;

		encodeMarkup(context, calendar);
		encodeScript(context, calendar);
	}

	protected void encodeMarkup(FacesContext context,
			CalendarComponent calendar) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String clientId = calendar.getClientId(context);

		writer.startElement("span", calendar);
		writer.writeAttribute("id", clientId, null);

		writer.startElement("div", null);
		writer.writeAttribute("id", clientId , null);
		writer.endElement("div");

		writer.startElement("input", calendar);
		writer.writeAttribute("id", calendar.getClientId(context)+"_input", "id");
		writer.writeAttribute("name", calendar.getClientId(context)+"_input", "name");
		writer.writeAttribute("class", "date-pick", "class");
		writer.writeAttribute("type", "text", "type");

		String value="";
		if (calendar.getValue()!=null)
			value = calendar.getValue().toString();
		
		writer.writeAttribute("value", value, "value");

		writer.endElement("input");

		writer.endElement("span");
		
	}

	protected void encodeScript(FacesContext context,
			CalendarComponent calendar) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String clientId = calendar.getClientId(context);
		String inputId = ".date-pick";

		writer.startElement("script", null);
		writer.writeAttribute("type", "text/javascript", null);

		writer.write("$(function() { $('" + inputId+ "').datepicker({dateFormat : 'dd-mm-yy'});});");

		writer.endElement("script");
	}

}
