package com.jsf.component;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
/**
 * 没看懂，以后再说吧
 * @author may
 *
 */
public class UITextWithCmd extends UIInput {
	private static final String TEXT = ".text";
	private static final String CMD = ".cmd";

	public UITextWithCmd() {
		this.setRendererType(null);
	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		String clientId = this.getClientId(context);
		encodeTextField(writer, clientId);
		encodeCommand(writer, clientId);
	}

	@Override
	public void decode(FacesContext context) {
		Map reqParaMap = context.getExternalContext().getRequestParameterMap();
		String clientId = getClientId(context);
		String submittedValue = (String) reqParaMap.get(clientId + TEXT);
		setSubmittedValue(submittedValue);
		setValid(true);
	}

	private void encodeTextField(ResponseWriter writer, String clientId) throws IOException {
		writer.startElement("input", this);
		writer.writeAttribute("name", clientId + TEXT, null);
		Object value = this.getValue();
		if (value != null) {
			writer.writeAttribute("value", value.toString(), null);
		}
		String size = (String) getAttributes().get("size");
		if (size != null) {
			writer.writeAttribute("size", size, null);
		}
		writer.endElement("input");
	}

	private void encodeCommand(ResponseWriter writer, String clientId) throws IOException {
		writer.startElement("input", this);
		writer.writeAttribute("type", "submit", null);
		writer.writeAttribute("name", clientId + CMD, null);
		writer.writeAttribute("value", "submit", null);
		writer.endElement("input");
	}
}