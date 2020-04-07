package com.udacity.course3.reviews.entity;

import javax.persistence.*;

@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long cId;

    @Column(name = "info")
    private String commment;

    @Column(name = "reviewId")
    private Long reviewId;

    public Comment(){}

    public Long getId() {
        return cId;
    }

    public void setId(Long id) {
        this.cId = id;
    }

    public String getCommment() {
        return commment;
    }

    public void setCommment(String commment) {
        this.commment = commment;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }
}
