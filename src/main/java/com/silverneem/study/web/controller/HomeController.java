package com.silverneem.study.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Map<String, Object> home(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat
				.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serverTime", formattedDate);
		
		return map;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public Map<String, Object> anotherhome(Locale locale) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat
				.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serverTime", formattedDate);
		
		return map;
	}

}
