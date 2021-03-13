package de.fhdw.informationsinfrastrukturen.cinema.rest.api;

import java.io.Serializable;

public class Parameter implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Object value;
	
	String type;

	public Parameter() {
	}

	public Parameter(Object value, String type) {
		super();
		this.value = value;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Parameter [value=" + value + ", type=" + type + "]";
	}
}
