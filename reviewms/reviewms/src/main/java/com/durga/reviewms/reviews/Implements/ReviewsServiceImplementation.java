package com.durga.reviewms.reviews.Implements;

import com.durga.reviewms.reviews.Reviews;
import com.durga.reviewms.reviews.ReviewsRepository;
import com.durga.reviewms.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImplementation implements ReviewsService {
    private ReviewsRepository reviewsRepository;
    List<Reviews> reviews;

    public ReviewsServiceImplementation(ReviewsRepository reviewsRepository){
        this.reviewsRepository = reviewsRepository;
    }

    @Override
    public List<Reviews> findAll(Long companyId) {
        List<Reviews> review = reviewsRepository.findByCompanyId(companyId);
        return review;
    }

    @Override
    public Reviews findById(Long reviewId) {
        return reviewsRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean createReview(Long companyId, Reviews review) {
        if(companyId != null && review != null){
            review.setCompanyId(companyId);
            reviewsRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long reviewId) {
        Reviews review = reviewsRepository.findById(reviewId).orElse(null);
        if(review != null){
            reviewsRepository.delete(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long reviewId, Reviews updateReview) {
        Reviews review = reviewsRepository.findById(reviewId).orElse(null);
        if(review != null){
            review.setReview_title(updateReview.getReview_title());
            review.setReview_context(updateReview.getReview_context());
            review.setRating(updateReview.getRating());
            review.setCompanyId(updateReview.getCompanyId());
            reviewsRepository.save(review);
            return true;
        }
        return false;
    }
}
