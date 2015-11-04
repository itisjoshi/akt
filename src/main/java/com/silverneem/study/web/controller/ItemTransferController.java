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

import com.silverneem.study.core.modal.ItemTransfer;
import com.silverneem.study.core.modal.ItemTransferDetails;
import com.silverneem.study.web.modal.ItemTransferWeb;
import com.silverneem.study.web.modal.ItemTransferWebModel;
import com.silverneem.study.web.service.ItemTransferManagementService;
@RestController
@RequestMapping(value = "/itemtransfer")
@Secured(value = "ROLE_ADMIN")
public class ItemTransferController {

	@Autowired
	private ItemTransferManagementService itemTransferManagementService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ItemTransferWeb> getAllGroups() {
		return itemTransferManagementService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ItemTransferWeb getAllGroupsBy(@PathVariable("id") Long id) {
		return itemTransferManagementService.findById(id);
	}

	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ItemTransferWeb> getAllGroupsByItem(@PathVariable("id") Long id) {
		return itemTransferManagementService.findByItem(id);
	}
	
	@RequestMapping(value = "/search/{searchterm}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<ItemTransfer> search(@PathVariable("searchterm") String searchterm) {
		return itemTransferManagementService.search(searchterm);
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void createGroup(@RequestBody  ItemTransferWebModel  itemTransfer) {
		itemTransferManagementService.createItemTransfer(itemTransfer);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void editGroup(@RequestBody  ItemTransfer  itemTransfer) {
		itemTransferManagementService.updateItemTransfer(itemTransfer);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void deleteGroup(@RequestBody  ItemTransfer  itemTransfer) {
		itemTransferManagementService.deleteTransfer(itemTransfer);
	}
	
	@RequestMapping(value = "/detail/delete", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void delete(@RequestBody ItemTransferDetails itemTransferDetails) {
		itemTransferManagementService.deleteTransferDetails(itemTransferDetails);
	}
	
	@RequestMapping(value = "/detail/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody  ItemTransferDetails itemTransferDetails) {
		itemTransferManagementService.createItemTransferDetail(itemTransferDetails);
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
