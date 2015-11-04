package com.silverneem.study.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silverneem.study.core.modal.Item;
import com.silverneem.study.core.modal.ItemTransfer;
import com.silverneem.study.core.repository.ItemTansferRepository;
@Service("ItemTransferService")
@Repository
@Transactional
public class ItemTransferServiceImpl implements ItemTransferService {

	@Autowired
	private ItemTansferRepository itemTansferRepository;
	
	@Override
	public ItemTransfer create(ItemTransfer entity) {
		// TODO Auto-generated method stub
		return itemTansferRepository.save(entity);
	}

	@Override
	public ItemTransfer update(ItemTransfer entity) {
		// TODO Auto-generated method stub
		return itemTansferRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		itemTansferRepository.delete(id);
	}

	@Override
	public void delete(ItemTransfer entity) {
		// TODO Auto-generated method stub
		itemTansferRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ItemTransfer> entities) {
		// TODO Auto-generated method stub
		itemTansferRepository.delete(entities);
	}

	@Override
	public Iterable<ItemTransfer> findAll() {
		// TODO Auto-generated method stub
		return itemTansferRepository.findAll();
	}

	@Override
	public ItemTransfer findOne(Long id) {
		// TODO Auto-generated method stub
		return itemTansferRepository.findOne(id);
	}

	@Override
	public List<ItemTransfer> findByItem(Item item) {
		// TODO Auto-generated method stub
		return itemTansferRepository.findByItem(item);
	}

	@Override
	public List<ItemTransfer> search(String searchterm) {
		// TODO Auto-generated method stub
		return itemTansferRepository.search(searchterm);
	}

	@Override
	public ItemTransfer findById(Long id) {
		// TODO Auto-generated method stub
		return itemTansferRepository.findById(id);
	}

}