package com.phaseThreeAssesment.eCommerceAssesment.service;

import com.phaseThreeAssesment.eCommerceAssesment.model.ProductDetails;
import com.phaseThreeAssesment.eCommerceAssesment.repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductDetailsService {

    @Autowired
    ProductDetailsRepository productDetailsRepository;

    public List<ProductDetails> fetchList(){return productDetailsRepository.findAll();}

    public ProductDetails findById(long id){return productDetailsRepository.findById(id).orElse(null);}

    public ProductDetails create(ProductDetails productDetails){
        productDetails.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
        productDetails.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
        return productDetailsRepository.save(productDetails);
    }

    public ProductDetails update(long id, ProductDetails productDetails){
        ProductDetails productDetailsEntity = productDetailsRepository.findById(id).orElse(null);
        if (null != productDetailsEntity){
            productDetails.setProductId(id);
            productDetails.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
            productDetails.setCreatedAt(productDetailsEntity.getCreatedAt());
            return productDetailsRepository.save(productDetails);
        }
        return null;
    }


    public void delete(long id) {
        ProductDetails productDetailsEntity = productDetailsRepository.findById(id).orElse(null);
        if (null != productDetailsEntity){
         productDetailsRepository.delete(productDetailsEntity);
        }
    }
}
