package com.durga.firstjobapp.reviews.Implements;


import com.durga.firstjobapp.company.Company;
import com.durga.firstjobapp.company.CompanyService;
import com.durga.firstjobapp.reviews.Reviews;
import com.durga.firstjobapp.reviews.ReviewsRepository;
import com.durga.firstjobapp.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsServiceImplementation implements ReviewsService {
//    public ReviewsServiceImplementation companyRepository;
    private ReviewsRepository reviewsRepository;
    private CompanyService companyService;
    List<Reviews> reviews;

    public ReviewsServiceImplementation(ReviewsRepository reviewsRepository,CompanyService companyService){
        this.reviewsRepository = reviewsRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Reviews> findAll(Long companyId) {
        List<Reviews> review = reviewsRepository.findByCompanyCompanyId(companyId);
        return review;
    }

    @Override
    public Reviews findById(Long companyId, Long reviewId) {
        List<Reviews> reviews = reviewsRepository.findByCompanyCompanyId(companyId);
        return reviews.stream().filter(review -> review.getReviewId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean createReview(Long companyId, Reviews review) {
        Company company = companyService.findById(companyId);
        if(company != null){
            review.setCompany(company);
//            c.setReview((List<Reviews>) review);
            reviewsRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Long companyId, Long reviewId) {
        if(companyService.findById(companyId) != null && reviewsRepository.existsById(reviewId)){
            Reviews review = reviewsRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReview().remove(review);
            review.setCompany(null);
            companyService.updateCompany(companyId,company);
            reviewsRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Reviews updateReview) {
        if(companyService.findById(companyId) != null){
            updateReview.setCompany(companyService.findById(companyId));
            updateReview.setReviewId(reviewId);
            reviewsRepository.save(updateReview);
            return true;
        }
        return false;
    }
}
