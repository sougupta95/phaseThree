package com.phaseThreeAssesment.eCommerceAssesment.controller;

import com.phaseThreeAssesment.eCommerceAssesment.model.Brand;
import com.phaseThreeAssesment.eCommerceAssesment.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phaseThree/brands")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping("/")
    public List<Brand> findAllBrands(){
        return brandService.fetchList();
    }

    @GetMapping("/{id}")
    public Brand findById(@PathVariable(value = "id") long id){
        return brandService.getById(id);
    }

    @PostMapping("/")
    public Brand createBrand(@RequestBody Brand brand){
        return brandService.create(brand);
    }

    @PutMapping("/{id}")
    public Brand updateBrand(@PathVariable(value = "id") long id, @RequestBody Brand brand){
        return brandService.update(brand,id);
    }
    @DeleteMapping("/{id}")
    public String deleteBrand(@PathVariable(value = "id") long id){
        brandService.deleteById(id);
        return "Deleted";
    }
}
