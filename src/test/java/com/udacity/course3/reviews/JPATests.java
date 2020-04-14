package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class JPATests {

	@Autowired private ProductRepository productRepository;
	@Autowired private ReviewRepository reviewRepository;
	@Autowired private CommentRepository commentRepository;

	@Test
	public void injectedComponentsAreNotNull(){
		assertThat(productRepository, is(notNullValue()));
		assertThat(reviewRepository, is(notNullValue()));
		assertThat(commentRepository, is(notNullValue()));
	}

	@Test
	public void testSavingEntities(){

		// Test Product
		Product product = new Product();
		product.setName("MacBook Pro");
		Product updatedProduct = productRepository.save(product);
		assertEquals("MacBook Pro", productRepository.findById(product.getpId()).get().getName());
		assertEquals(1, productRepository.findAll().size());

		// Test Review
		Review review = new Review();
		review.setProductId(updatedProduct.getpId());
		Review updatedReview = reviewRepository.save(review);
		assertEquals(1, reviewRepository.findAll().size());

		// Test Comment
		Comment comment = new Comment();
		comment.setReviewId(updatedReview.getrId());
		commentRepository.save(comment);
		assertEquals(1, commentRepository.findAll().size());
	}
}