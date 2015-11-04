package com.silverneem.study.utils.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class HibernateAwareObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -9203767302100068610L;

	public HibernateAwareObjectMapper() {
		configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		registerModule(getHibernate4Module());
	}

	public Module getHibernate4Module() {
		Hibernate4Module hibernate4Module = new Hibernate4Module();
		return hibernate4Module;
	}

}
