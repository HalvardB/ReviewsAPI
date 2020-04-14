package com.udacity.course3.reviews.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document("reviews")
public class ReviewMongo {

    @Id
    private String id;

    private Long productId;

    private List<CommentMongo> comments = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public List<CommentMongo> getComments() {
        return comments;
    }

    public void setComments(List<CommentMongo> comments) {
        this.comments = comments;
    }

    public void addComment(CommentMongo comment){
        this.comments.add(comment);
    }
}
