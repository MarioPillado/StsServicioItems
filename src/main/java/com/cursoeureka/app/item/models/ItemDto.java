package com.cursoeureka.app.item.models;

public class ItemDto {

	private ProductDto product;
	private Integer cantidad;

	public ItemDto() {
	}

	public ItemDto(ProductDto product, Integer cantidad) {
		super();
		this.product = product;
		this.cantidad = cantidad;
	}

	public ProductDto getProduct() {
		return product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return product.getPrecio() * cantidad.doubleValue();
	}
	
}
