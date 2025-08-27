package com.durga.reviewms.reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> findAll(Long companyId);
    Reviews findById(Long reviewId);
    boolean createReview(Long companyId,Reviews review);
    boolean deleteById(Long reviewId);
    boolean updateReview(Long reviewId,Reviews review);
}
