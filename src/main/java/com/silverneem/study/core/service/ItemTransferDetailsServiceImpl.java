package com.silverneem.study.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silverneem.study.core.modal.ItemTranferDetailsStatus;
import com.silverneem.study.core.modal.ItemTransfer;
import com.silverneem.study.core.modal.ItemTransferDetails;
import com.silverneem.study.core.repository.ItemTransferDetailsRepository;
@Service("ItemTransferDetailsTransferDetails")
@Repository
@Transactional
public class ItemTransferDetailsServiceImpl implements ItemTransferDetailsService {

	@Autowired
	private ItemTransferDetailsRepository itemTransferDetailsRepository;
	
	@Override
	public ItemTransferDetails create(ItemTransferDetails entity) {
		// TODO Auto-generated method stub
		return itemTransferDetailsRepository.save(entity);
	}

	@Override
	public ItemTransferDetails update(ItemTransferDetails entity) {
		// TODO Auto-generated method stub
		return itemTransferDetailsRepository.save(entity);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		itemTransferDetailsRepository.delete(id);		
	}

	@Override
	public void delete(ItemTransferDetails entity) {
		// TODO Auto-generated method stub
		itemTransferDetailsRepository.delete(entity);
	}

	@Override
	public void delete(Iterable<ItemTransferDetails> entities) {
		// TODO Auto-generated method stub
		itemTransferDetailsRepository.delete(entities);
	}

	@Override
	public List<ItemTransferDetails> findAll() {
		// TODO Auto-generated method stub
		return itemTransferDetailsRepository.findAll();
	}

	@Override
	public ItemTransferDetails findOne(Long id) {
		// TODO Auto-generated method stub
		return itemTransferDetailsRepository.findOne(id);
	}

	@Override
	public List<ItemTransferDetails> findByItemTransfer(
			ItemTransfer itemTransfer) {
		// TODO Auto-generated method stub
		return itemTransferDetailsRepository.findByItemTransfer(itemTransfer);
	}

	@Override
	public ItemTransferDetails findByItemTransferAndItemTranferDetailsStatus(
			ItemTransfer itemTransfer, ItemTranferDetailsStatus receive) {
		// TODO Auto-generated method stub
		return itemTransferDetailsRepository.findByItemTransferAndItemTranferDetailsStatus(itemTransfer, receive);
	}
}