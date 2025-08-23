package com.durga.firstjobapp.reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> findAll(Long companyId);
    Reviews findById(Long companyId,Long reviewId);
    boolean createReview(Long companyId,Reviews review);
    boolean deleteById(Long companyId,Long reviewId);
    boolean updateReview(Long companyId,Long reviewId,Reviews review);
}
