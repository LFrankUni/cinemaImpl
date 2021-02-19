package de.fhdw.informationsinfrastrukturen.cinema.rest.resources.command;

import java.io.Serializable;
import java.util.List;

public class Function implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String name;

	List<Parameter> parameter;

	public Function() {
	}

	public Function(String name, List<Parameter> parameter) {
		super();
		this.name = name;
		this.parameter = parameter;
	}

}
