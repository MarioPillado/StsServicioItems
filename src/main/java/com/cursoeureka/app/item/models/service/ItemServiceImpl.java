package com.cursoeureka.app.item.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cursoeureka.app.item.models.ItemDto;
import com.cursoeureka.app.item.models.ProductDto;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<ItemDto> findAll() {
		List<ProductDto> productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", ProductDto[].class));
		return productos.stream().map(p -> new ItemDto(p, 1)).collect(Collectors.toList());
	}

	@Override
	public ItemDto findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		ProductDto producto = clienteRest.getForObject("http://localhost:8001/listar/{id}", ProductDto.class, pathVariables);
		return new ItemDto(producto, cantidad); 
	}

}
