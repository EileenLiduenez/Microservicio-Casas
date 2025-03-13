//Se puede llamar handler. En esta capa de implementacion estamos

package com.pragma.microserviciocasas.application.services.impl;

import com.pragma.microserviciocasas.domain.model.Category;
import com.pragma.microserviciocasas.domain.ports.in.CategoryServicePort;
import com.pragma.microserviciocasas.domain.ports.out.CategoryPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryServiceImpl(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryPersistencePort.save(category);
    }

    @Override
    public Page<Category> getCategories(Pageable pageable, String filter) {
        // Implement the logic to get categories with pagination and filtering
        return categoryPersistencePort.findAll(pageable, filter);
    }
}