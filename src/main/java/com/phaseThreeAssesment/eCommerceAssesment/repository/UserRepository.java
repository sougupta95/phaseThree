package com.phaseThreeAssesment.eCommerceAssesment.repository;

import com.phaseThreeAssesment.eCommerceAssesment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
