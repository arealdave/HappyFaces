package com.github.happyfaces.component;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

public class CalendarRenderer extends Renderer {

	public static final String RENDERER_TYPE="CalendarRenderer";

	@Override
	public void decode(FacesContext context, UIComponent component) {
		CalendarComponent calendar = (CalendarComponent) component;

	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component)
			throws IOException {
		CalendarComponent calendar = (CalendarComponent) component;

		encodeMarkup(context, calendar, "");
		encodeScript(context, calendar, "");
	}

	protected void encodeMarkup(FacesContext context, CalendarComponent calendar,
			String value) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String clientId = calendar.getClientId(context);
		String inputId = clientId + "_input";

		writer.startElement("span", calendar);
		writer.writeAttribute("id", clientId, null);

		writer.startElement("div", null);
		writer.writeAttribute("id", clientId + "_inline", null);
		writer.endElement("div");


		writer.startElement("input", null);
		writer.writeAttribute("id", inputId, null);
		writer.writeAttribute("name", inputId, null);
		writer.writeAttribute("type", "text", null);

		writer.writeAttribute("value", value, null);

		writer.endElement("input");

		writer.endElement("span");
	}

	protected void encodeScript(FacesContext context, CalendarComponent calendar,
			String value) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String clientId = calendar.getClientId(context);
		String inputId = clientId + "_input";

		writer.startElement("script", null);
		writer.writeAttribute("type", "text/javascript", null);

		writer.write("$(function() { $(\"#"+inputId+"\").datepicker({dateFormat : 'dd-mm-yy'});});");

		writer.endElement("script");
	}


}

