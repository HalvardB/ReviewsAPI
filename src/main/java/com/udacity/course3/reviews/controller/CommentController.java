package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.CommentMongo;
import com.udacity.course3.reviews.entity.ReviewMongo;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentController {

    // TODO: Wire needed JPA repositories here

    @Autowired
    private ReviewMongoRepository reviewRepository;

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") String reviewId, @RequestBody CommentMongo comment) {

        Optional<ReviewMongo> review = reviewRepository.findById(reviewId);

        if(review.isPresent()){
            CommentMongo newComment = new CommentMongo();
            newComment.setInfo(comment.getInfo());
            review.get().addComment(newComment);
            ReviewMongo updatedReview = reviewRepository.save(review.get());
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listCommentsForReview(@PathVariable("reviewId") String reviewId) {

        Optional<ReviewMongo> review = reviewRepository.findById(reviewId);

        if(review.isPresent()){
            List<CommentMongo> allComments = review.get().getComments();
            return new ResponseEntity<>(allComments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}