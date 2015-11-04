package com.silverneem.study.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silverneem.study.core.modal.Item;
import com.silverneem.study.core.repository.ItemRepository;

@Service("ItemService")
@Repository
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item create(Item entity) {
		// TODO Auto-generated method stub
		return itemRepository.save(entity);
	}

	@Override
	public Item update(Item entity) {
		// TODO Auto-generated method stub
		return itemRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		itemRepository.delete(id);	
	}

	@Override
	public void delete(Item entity) {
		// TODO Auto-generated method stub
		itemRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<Item> entities) {
		// TODO Auto-generated method stub
		itemRepository.delete(entities);
	}

	@Override
	public Item findOne(Long id) {
		// TODO Auto-generated method stub
		return itemRepository.findOne(id);
	}

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public List<Item> search(String searchterm) {
		// TODO Auto-generated method stub
		return itemRepository.search(searchterm);
	}
	
}