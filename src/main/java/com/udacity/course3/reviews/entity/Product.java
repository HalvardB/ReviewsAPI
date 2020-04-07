package com.udacity.course3.reviews.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    @Column(name = "name")
    private String name;

    // @OneToMany
    // @JoinColumn(name = "r_id")
    // private List<Review> reviews = new ArrayList<>();

    public Product(){}

    public Long getId() {
        return pId;
    }

    public void setId(Long id) {
        this.pId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

     */
}
