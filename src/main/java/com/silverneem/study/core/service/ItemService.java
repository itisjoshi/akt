package com.silverneem.study.core.service;

import java.util.List;

import com.silverneem.study.core.modal.Item;

public interface ItemService extends CrudService<Item, Long>{

	public List<Item> findAll();

	public List<Item> search(String searchterm);

}
