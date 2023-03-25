package com.phaseThreeAssesment.eCommerceAssesment.controller;

import com.phaseThreeAssesment.eCommerceAssesment.model.Category;
import com.phaseThreeAssesment.eCommerceAssesment.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phaseThree/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public List<Category> findAllCategories(){
        return categoryService.fetchList();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable(value = "id") long id){
        return categoryService.getById(id);
    }

    @PostMapping("/")
    public Category createCategory(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable(value = "id") long id, @RequestBody Category category){
        return categoryService.update(category,id);
    }
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable(value = "id") long id){
        categoryService.deleteById(id);
        return "Deleted";
    }
}
