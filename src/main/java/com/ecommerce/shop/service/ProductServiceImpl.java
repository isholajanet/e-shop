package com.ecommerce.shop.service;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.data.model.ProductDto;
import com.ecommerce.shop.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Long id, ProductDto update) {
        Optional<Product> foundProduct = productRepository.findById(id);


        if(foundProduct.isPresent()){
            Product productToUpdate = foundProduct.get();
            boolean isNameValid = update.getName() != null && !update.getName().isEmpty() && !update.getName().isBlank()
                    && !update.getName().equals(productToUpdate.getName());
            boolean isPriceValid = update.getPrice() != null  && update.getPrice() != productToUpdate.getPrice();
            boolean isCurrencyValid = update.getCurrency() != null && !update.getCurrency().equals(productToUpdate.getCurrency());
            boolean isDetailsValid = update.getDetails() != null && !update.getDetails().isEmpty() && !update.getDetails().isBlank()
                    && !update.getDetails().equals(productToUpdate.getDetails());
            boolean isImageUrlValid = update.getImageUrl() != null && !update.getImageUrl().isEmpty()
                    && !update.getImageUrl().equals(productToUpdate.getImageUrl());

            if(isNameValid){
                productToUpdate.setName(update.getName());
            }else{
                productToUpdate.setName(productToUpdate.getName());
            }

            if(isPriceValid){
                productToUpdate.setPrice(update.getPrice());
            }else{
                productToUpdate.setPrice(productToUpdate.getPrice());
            }

            if(isCurrencyValid){
                productToUpdate.setCurrency(update.getCurrency());
            }else{
                productToUpdate.setCurrency(productToUpdate.getCurrency());
            }

            if(isDetailsValid){
                productToUpdate.setDetails(update.getDetails());
            }else{
                productToUpdate.setDetails(productToUpdate.getDetails());
            }

            if(isImageUrlValid){
                productToUpdate.setImageUrl(update.getImageUrl());
            }else{
                productToUpdate.setImageUrl(productToUpdate.getImageUrl());
            }
            return productRepository.save(productToUpdate);
        }else{
            throw new IllegalArgumentException("Incorrect Id");
        }

    }
}
