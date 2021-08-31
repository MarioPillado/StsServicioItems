package com.cursoeureka.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cursoeureka.app.item.models.ItemDto;
import com.cursoeureka.app.item.models.service.IItemService;

@RestController
public class ItemController {

	@Autowired
	private IItemService itemService;
	
	@GetMapping("/listar")
	public List<ItemDto> listar(){
		return itemService.findAll();
	}
	
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public ItemDto detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
}
