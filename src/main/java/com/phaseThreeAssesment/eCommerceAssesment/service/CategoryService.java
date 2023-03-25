package com.phaseThreeAssesment.eCommerceAssesment.service;

import com.phaseThreeAssesment.eCommerceAssesment.model.Category;
import com.phaseThreeAssesment.eCommerceAssesment.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    public Category create(Category category) {
       return categoryRepository.save(category);
    }

    public List<Category> fetchList() {
        return categoryRepository.findAll();
    }

    public Category getById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category update(Category category, long id) {
        Category categoryEntity = categoryRepository.findById(id).orElse(null);
        if(categoryEntity != null){
            categoryEntity.setType(category.getType());
            return categoryRepository.save(categoryEntity);
        }
        return null;
    }

   public void deleteById(long id) {
       Category category = categoryRepository.findById(id).orElse(null);
        if(category != null) categoryRepository.delete(category);
    }
}
