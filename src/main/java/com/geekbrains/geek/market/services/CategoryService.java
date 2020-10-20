package com.geekbrains.geek.market.services;

import com.geekbrains.geek.market.entities.Category;
import com.geekbrains.geek.market.entities.Product;
import com.geekbrains.geek.market.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public Page<Category>  findAll( int page, int size ) {
        return categoryRepository.findAll(PageRequest.of(page, size));
    }

}
