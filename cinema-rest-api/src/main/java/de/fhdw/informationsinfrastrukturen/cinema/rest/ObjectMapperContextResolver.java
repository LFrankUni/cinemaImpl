package de.fhdw.informationsinfrastrukturen.cinema.rest;

import java.util.Collection;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import observation.Observer;

/**
 * Für den Moment noch ok, aber langfristig muss ein schlaues Serialisieren her.
 * 
 * Problem: Wie soll man die generierten Klassen serialiseren? Eigentlich
 * garnicht, DTOs sollten auch generiert werden.
 * 
 * @author Robby Rabbitman
 *
 */
@Provider
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {

	private final ObjectMapper mapper;

	public ObjectMapperContextResolver() {
		this.mapper = createObjectMapper();
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}

	private ObjectMapper createObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		// ignore getter, work on fields
		mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE).setVisibility(PropertyAccessor.FIELD,
				JsonAutoDetect.Visibility.ANY);
		// ignore non null
		mapper.setSerializationInclusion(Include.NON_NULL);
		// ignore observers, TODO doesnt work
		mapper.addMixIn(Object.class, Filter.class);
		return mapper;
	}
}

@JsonIgnoreProperties
class Filter {
	Collection<Observer> observers;
}
