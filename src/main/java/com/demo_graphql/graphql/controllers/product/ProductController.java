package com.demo_graphql.graphql.controllers.product;

import com.demo_graphql.graphql.modules.product.ProductEntity;
import com.demo_graphql.graphql.repositories.product.ProductRepository;
import org.hibernate.annotations.Mutability;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    ProductRepository repository;

    @MutationMapping()
    public ProductEntity addProduct(@Argument ProductInput product){
        return repository.save(new ProductEntity(product.name, product.price, product.categoryId));
    }

    @QueryMapping()
    public Iterable<ProductEntity> products(){
        return repository.findAll();
    }

    record  ProductInput(String name, BigDecimal price, UUID categoryId){}
}
