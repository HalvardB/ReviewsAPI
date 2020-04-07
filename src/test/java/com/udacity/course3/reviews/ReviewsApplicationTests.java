package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired private CommentRepository commentRepository;
	@Autowired private ReviewRepository reviewRepository;
	@Autowired private ProductRepository productRepository;
	@Autowired private EntityManager entityManager;

	// @Autowired ReviewsApplication app = new ReviewsApplication();

	@Test
	public void contextLoads() {
	}

	@Test
	public void injectedComponentsAreNotNull(){
		Assert.assertNotNull(commentRepository);
		Assert.assertNotNull(reviewRepository);
		Assert.assertNotNull(productRepository);
	}

	@Test
	public void testProducts(){
		Product product = new Product();
		product.setName("MacBook Pro");
		Product updatedProduct = productRepository.save(product);

		// entityManager.persist(products);
		// Products updatedProducts = productRepository.findById(products.getId()).get();
		Assert.assertEquals("MacBook Pro", updatedProduct.getName());

	}

}