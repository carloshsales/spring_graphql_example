package com.demo_graphql.graphql.controllers.category;

import com.demo_graphql.graphql.modules.category.CategoryEntity;
import com.demo_graphql.graphql.repositories.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;


@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @MutationMapping()
    public CategoryEntity addCategory(@Argument CategoryInput category){
        return repository.save(new CategoryEntity(category.name));
    }

    @QueryMapping()
    public CategoryEntity categoryById(@Argument UUID id){
        return repository.findById(id).get();
    }


    record CategoryInput(String name){}
}
