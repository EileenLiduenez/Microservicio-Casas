package com.pragma.microserviciocasas.infrastructure.endpoints.rest;

import com.pragma.microserviciocasas.domain.model.Category;
import com.pragma.microserviciocasas.domain.ports.in.CategoryServicePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryServicePort categoryServicePort;

    public CategoryController(CategoryServicePort categoryServicePort) {
        this.categoryServicePort = categoryServicePort;
    }

    @GetMapping
    public Page<Category> index(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String filter) {

        Pageable pageable = PageRequest.of(page, size);
        return categoryServicePort.getCategories(pageable, filter);
    }

}
