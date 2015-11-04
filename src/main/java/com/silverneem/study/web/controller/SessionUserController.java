package com.silverneem.study.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.silverneem.study.web.service.SessionUserService;
@RestController
@RequestMapping(value = "/currentuser")
public class SessionUserController {

	@Autowired
	private SessionUserService sessionUserService;
		
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getCurrentUser() {
		return sessionUserService.getCurrentUser();
	}
	
}
