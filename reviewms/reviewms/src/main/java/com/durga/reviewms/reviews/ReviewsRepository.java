package com.durga.reviewms.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // for good practice
public interface ReviewsRepository extends JpaRepository<Reviews,Long> {

    List<Reviews> findByCompanyId(Long companyId);
}
