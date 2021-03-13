package de.fhdw.informationsinfrastrukturen.cinema.rest.api;

import java.io.Serializable;

/**
 * 
 * @author Robby Rabbitman
 *
 */

public class CommandRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * If parameters are not of a base type, the value is treated as the id of the
	 * complex object.
	 */
	Function targetFunction;

	String targetType;

	Integer targetId;

	public CommandRequest() {
	}

	public CommandRequest(Function targetFunction, String targetType) {
		super();
		this.targetFunction = targetFunction;
		this.targetType = targetType;
	}

	public CommandRequest(Function targetFunction, String targetType, Integer targetId) {
		super();
		this.targetFunction = targetFunction;
		this.targetType = targetType;
		this.targetId = targetId;
	}

	@Override
	public String toString() {
		return "CommandRequest [targetFunction=" + targetFunction + ", targetType=" + targetType + ", targetId="
				+ targetId + "]";
	}

}
