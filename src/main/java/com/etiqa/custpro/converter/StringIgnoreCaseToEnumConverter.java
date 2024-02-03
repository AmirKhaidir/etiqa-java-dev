package com.etiqa.custpro.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.etiqa.custpro.enumeration.Relationship;

@Component
public class StringIgnoreCaseToEnumConverter implements Converter<String, Relationship>{

	@Override
	public Relationship convert(String source) {
		return Relationship.valueOf(source.toUpperCase());
	}
}
