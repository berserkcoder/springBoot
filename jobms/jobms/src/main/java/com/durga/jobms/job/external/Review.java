package com.durga.jobms.job.external;

public class Review {
    private Long reviewId;
    private String review_title;
    private String review_context;
    private double rating;

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview_title() {
        return review_title;
    }

    public void setReview_title(String review_title) {
        this.review_title = review_title;
    }

    public String getReview_context() {
        return review_context;
    }

    public void setReview_context(String review_context) {
        this.review_context = review_context;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
