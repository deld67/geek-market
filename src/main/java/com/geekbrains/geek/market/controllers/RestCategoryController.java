package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.entities.Category;
import com.geekbrains.geek.market.entities.Product;
import com.geekbrains.geek.market.services.CategoryService;
import com.geekbrains.geek.market.utils.ProductFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class RestCategoryController {
    private CategoryService categoryService;

    @GetMapping(produces = "application/json") // /api/v1/category
    public Page<Category>  showAllCategory(@RequestParam(defaultValue = "1", name = "p") Integer page) {
        if (page < 1) {
            page = 1;
        }
        Page<Category> content = categoryService.findAll( page - 1, 5);

        return content;
    }
}
