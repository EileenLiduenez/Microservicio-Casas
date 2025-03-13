package com.pragma.microserviciocasas.domain.ports.in;

import com.pragma.microserviciocasas.domain.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryServicePort {
    Category createCategory(Category category);
    Page<Category> getCategories(Pageable pageable, String filter);
}