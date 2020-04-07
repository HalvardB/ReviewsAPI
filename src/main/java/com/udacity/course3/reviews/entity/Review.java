package com.udacity.course3.reviews.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "REVIEWS")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long rId;

    @Column(name = "product_id")
    private Long productId;

//    @OneToOne
//    @JoinColumn(name = "c_id")
//    private Comment comment;


    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
