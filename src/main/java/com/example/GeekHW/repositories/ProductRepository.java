package com.example.GeekHW.repositories;

import com.example.GeekHW.entities.ProductEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductRepository {
    private List<ProductEntity> products;

    @PostConstruct
    public void initRep() {
        products = new ArrayList<>();
        products.add(new ProductEntity(1, "Milk", 40));
        products.add(new ProductEntity(2, "Meat", 300));
        products.add(new ProductEntity(3, "Bread", 30));
        products.add(new ProductEntity(4, "Beer", 100));
        products.add(new ProductEntity(5, "Chocolate", 60));
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public ProductEntity getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public void addNewProduct(ProductEntity productEntity) {
        products.add(productEntity);
    }

    public void deleteProduct(ProductEntity productEntity) {
        products.remove(productEntity);
    }

    public void updateProduct(int id, ProductEntity updatedPoduct) {
        ProductEntity productEntity = getProductById(id);
        productEntity.setId(updatedPoduct.getId());
        productEntity.setTitle(updatedPoduct.getTitle());
        productEntity.setCost(updatedPoduct.getCost());
    }

    public List<ProductEntity> findSubstr(String filter){
        return products.stream().filter(p -> p.getTitle().contains(filter)).collect(Collectors.toList());
    }

}
