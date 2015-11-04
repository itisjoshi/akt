package com.silverneem.study.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.silverneem.study.core.modal.Item;
import com.silverneem.study.web.service.ItemManagementService;
@RestController
@RequestMapping(value = "/item")
@Secured(value = "ROLE_ADMIN")
public class ItemController {

	@Autowired
	private ItemManagementService itemService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Item> getAllGroups() {
		return itemService.findAll();
	}
	
	@RequestMapping(value = "/search/{searchterm}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Item> search(@PathVariable("searchterm") String searchterm) {
		return itemService.search(searchterm);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void createGroup(@RequestBody  Item  item) {
		itemService.createItem(item);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void editGroup(@RequestBody  Item item) {
		itemService.updateItem(item);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void deleteGroup(@RequestBody  Item item) {
		itemService.deleteGroup(item);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<FieldError> processValidationError(
    		MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
 
        return fieldErrors;
    }
}
