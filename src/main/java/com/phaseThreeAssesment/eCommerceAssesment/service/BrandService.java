package com.phaseThreeAssesment.eCommerceAssesment.service;

import com.phaseThreeAssesment.eCommerceAssesment.model.Brand;
import com.phaseThreeAssesment.eCommerceAssesment.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;
    public Brand create(Brand brand) {
       return brandRepository.save(brand);
    }

    public List<Brand> fetchList() {
        return brandRepository.findAll();
    }

    public Brand getById(long id) {
        return brandRepository.findById(id).orElse(null);
    }

    public Brand update(Brand brand, long id) {
        Brand brandEntity = brandRepository.findById(id).orElse(null);
        if(brandEntity != null){
            brandEntity.setName(brand.getName());
            return brandRepository.save(brandEntity);
        }
        return null;
    }

   public void deleteById(long id) {
       Brand brand = brandRepository.findById(id).orElse(null);
        if(brand != null) brandRepository.delete(brand);
    }
}
