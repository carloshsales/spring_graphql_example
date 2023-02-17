package com.demo_graphql.graphql.repositories.product;

import com.demo_graphql.graphql.modules.product.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<ProductEntity, UUID>{}

