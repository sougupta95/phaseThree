package com.phaseThreeAssesment.eCommerceAssesment.repository;

import com.phaseThreeAssesment.eCommerceAssesment.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
}
