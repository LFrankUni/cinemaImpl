package de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command;

import java.io.Serializable;

public class CommandResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	Object value;
	String type;
	String error;
	
	public CommandResponse() {
	}

	public CommandResponse(Object value, String type) {
		this.value = value;
		this.type = type;
	}

	public CommandResponse(String error) {
		this.error = error;
	}

	public Object getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	public String getError() {
		return error;
	}

}
