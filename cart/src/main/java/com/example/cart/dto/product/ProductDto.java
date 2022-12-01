package com.example.cart.dto.product;

import com.example.cart.entity.Product;

public class ProductDto {

    private Integer id;
    private  String name;
    private  String imageURL;
    private  double price;
    private  String description;

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setImageURL(product.getImageURL());
        this.setDescription(product.getDescription());
        this.setPrice(product.getPrice());
    }

    public ProductDto( String name,  String imageURL,  double price,  String description) {
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.description = description;
    }

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
