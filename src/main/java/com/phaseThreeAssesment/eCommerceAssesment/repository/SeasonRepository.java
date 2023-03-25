package com.phaseThreeAssesment.eCommerceAssesment.repository;

import com.phaseThreeAssesment.eCommerceAssesment.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}
