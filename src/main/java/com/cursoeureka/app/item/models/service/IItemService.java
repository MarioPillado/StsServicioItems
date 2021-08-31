package com.cursoeureka.app.item.models.service;

import java.util.List;

import com.cursoeureka.app.item.models.ItemDto;

public interface IItemService {

	public List<ItemDto> findAll();
	public ItemDto findById(Long id, Integer cantidad);
}
