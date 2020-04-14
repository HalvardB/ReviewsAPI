package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.CommentMongo;
import com.udacity.course3.reviews.entity.ReviewMongo;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataMongoTest
public class MongoDBTests {

    @Autowired private ReviewMongoRepository reviewMongoRepository;

    @Test
    public void loadingMongoDbRepository(){
        assertThat(reviewMongoRepository, is(notNullValue()));
    }

    @Test
    public void testAddingReviewToMongoDB(){
        int expectedReviewCount = reviewMongoRepository.findAll().size() + 1;
        String commentInfo = "Some important info";

        CommentMongo comment = new CommentMongo();
        comment.setInfo(commentInfo);
        List<CommentMongo> comments = new ArrayList<>();
        comments.add(comment);

        ReviewMongo review = new ReviewMongo();
        review.setProductId(1L);
        review.setComments(comments);
        ReviewMongo updatedReview = reviewMongoRepository.save(review);

        assertEquals(expectedReviewCount, reviewMongoRepository.findAll().size());
        assertEquals(commentInfo, updatedReview.getComments().get(0).getInfo());
    }
}
