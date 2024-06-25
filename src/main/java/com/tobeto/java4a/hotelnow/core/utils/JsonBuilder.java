package com.tobeto.java4a.hotelnow.core.utils;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonBuilder {
	
	private final ObjectMapper mapper;

	public JsonBuilder() {
		this.mapper = new ObjectMapper();
	}

	public String serialize(Object object) throws JsonProcessingException {
		return mapper.writeValueAsString(object);
	}
}
