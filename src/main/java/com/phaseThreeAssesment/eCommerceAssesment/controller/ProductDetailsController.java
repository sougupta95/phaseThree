package com.phaseThreeAssesment.eCommerceAssesment.controller;

import com.phaseThreeAssesment.eCommerceAssesment.model.ProductDetails;
import com.phaseThreeAssesment.eCommerceAssesment.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phaseThree/productDetails")
public class ProductDetailsController {

    @Autowired
    ProductDetailsService productDetailsService;

    @GetMapping("/")
    public List<ProductDetails> findAllProducts(){
        return productDetailsService.fetchList();
    }

    @GetMapping("/{id}")
    public ProductDetails findProductById(@PathVariable(value = "id") long id){
        return productDetailsService.findById(id);
    }
    @PostMapping("/")
    public ProductDetails createProductDetail(@RequestBody ProductDetails productDetails){
        System.out.println(productDetails);
        return productDetailsService
                .create(productDetails);
    }

    @PutMapping("/{id}")
    public ProductDetails updateProductDetail(@PathVariable(value = "id") long id, @RequestBody ProductDetails productDetails){
        return productDetailsService
                .update(id,productDetails);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") long id){
        productDetailsService.delete(id);
        return "Deleted";
    }
}
