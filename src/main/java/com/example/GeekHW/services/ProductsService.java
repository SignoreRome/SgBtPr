package com.example.GeekHW.services;

import com.example.GeekHW.entities.ProductEntity;
import com.example.GeekHW.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> index(){
        return productRepository.getProducts();
    }

    public void createNewProduct(ProductEntity productEntity){
        productRepository.addNewProduct(productEntity);
    }

    public ProductEntity showProduct(int id){
        return productRepository.getProductById(id);
    }

    public void deleteProduct(int id){
        ProductEntity deleteProduct = productRepository.getProductById(id);
        productRepository.deleteProduct(deleteProduct);
    }

    public void updateProduct(int id, ProductEntity updatedProduct){
        productRepository.updateProduct(id, updatedProduct);
    }

    public List<ProductEntity> filterProductStr(String filter){
        if (filter == null)
            return productRepository.getProducts();
        return productRepository.findSubstr(filter);
    }
}
