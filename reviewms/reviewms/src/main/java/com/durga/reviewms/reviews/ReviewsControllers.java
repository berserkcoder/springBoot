package com.durga.reviewms.reviews;



// GET/companies/{companyId}/reviews
// POST/companies/{companyId}/reviews
// GET/companies/{companyId}/reviews/{reviewId}
// PUT/companies/{companyId}/reviews/{reviewId}
// DELETE//companies/{companyId}/reviews/{reviewId}

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewsControllers {
    ReviewsService reviewsService;
    public ReviewsControllers(ReviewsService reviewsService){
        this.reviewsService = reviewsService;
    }

    @GetMapping("")
    public ResponseEntity<List<Reviews>> findAll(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewsService.findAll(companyId), HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Reviews> findById(@PathVariable Long reviewId){
        Reviews review = reviewsService.findById(reviewId);
        if(review == null) return new ResponseEntity<>(review,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createReview(@RequestParam Long companyId,@RequestBody Reviews review){
        boolean created = reviewsService.createReview(companyId,review);
        if(!created) return new ResponseEntity<>("Company doesnot Exist",HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Review Created Successfully",HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,@RequestBody Reviews updateReview){
        boolean updated = reviewsService.updateReview(reviewId,updateReview);
        if(updated) return new ResponseEntity<>("Review Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>("Reviw Not Found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviews(@PathVariable Long reviewId){
        boolean deleted = reviewsService.deleteById(reviewId);
        if(deleted) return new ResponseEntity<>("Review Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>("Review Not Found",HttpStatus.NOT_FOUND);
    }
}
