package com.phaseThreeAssesment.eCommerceAssesment.repository;

import com.phaseThreeAssesment.eCommerceAssesment.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
}
