package com.ecommerceApp.ecommerceApp.entities;

import javax.persistence.*;

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_USER_ID")
    private Users users;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Column(name = "IS_WISHLIST_ITEM")
    private Boolean is_wishlist_item;

    @OneToOne
    @JoinColumn(name = "PRODUCT_VARIATION_ID")
    private ProductVariation productVariation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return users;
    }

    public void setUser(Users user) {
        this.users = users;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getIs_wishlist_item() {
        return is_wishlist_item;
    }

    public void setIs_wishlist_item(Boolean is_wishlist_item) {
        this.is_wishlist_item = is_wishlist_item;
    }

    public ProductVariation getProductVariation() {
        return productVariation;
    }

    public void setProductVariation(ProductVariation productVariation) {
        this.productVariation = productVariation;
    }
}