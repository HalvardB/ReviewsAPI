package com.udacity.course3.reviews.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long rId;

    @Column(name = "product_id")
    private Long productId;

    @OneToOne
    @JoinColumn(name = "c_id")
    private Comment comment;

    public Review() {
    }

    public Long getId() {
        return rId;
    }

    public void setId(Long id) {
        this.rId = id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
