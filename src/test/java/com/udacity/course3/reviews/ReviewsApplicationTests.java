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

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired private DataSource dataSource;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private EntityManager entityManager;
	@Autowired private TestEntityManager testEntityManager;
	@Autowired private ProductRepository productRepository;
	@Autowired private ReviewRepository reviewRepository;
	@Autowired private CommentRepository commentRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void injectedComponentsAreNotNull(){
		assertThat(dataSource, is(notNullValue()));
		assertThat(jdbcTemplate, is(notNullValue()));
		assertThat(entityManager, is(notNullValue()));
		assertThat(testEntityManager, is(notNullValue()));
		assertThat(productRepository, is(notNullValue()));
		assertThat(reviewRepository, is(notNullValue()));
		assertThat(commentRepository, is(notNullValue()));
	}

	@Test
	public void testRepositories(){

		// Test Product
		Product product = new Product();
		product.setName("MacBook Pro");
		Product updatedProduct = productRepository.save(product);
		assertEquals("MacBook Pro", productRepository.findById(updatedProduct.getpId()).get().getName());
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