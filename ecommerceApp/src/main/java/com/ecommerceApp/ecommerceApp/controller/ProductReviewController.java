package com.ecommerceApp.ecommerceApp.controller;

import com.ecommerceApp.ecommerceApp.dtos.AddressDto;
import com.ecommerceApp.ecommerceApp.dtos.ProductReviewDto;
import com.ecommerceApp.ecommerceApp.services.ProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;

@RestController
public class ProductReviewController {

    @Autowired
    ProductReviewService productReviewService;

    @PostMapping(value = "/customer/add/reveiew")
    public String  addNewAddress(@Valid @RequestBody ProductReviewDto productReviewDto, HttpServletRequest request){
        Principal principal = request.getUserPrincipal();
        String username = principal.getName();
        return productReviewService.addProductReview(productReviewDto, username);
    }
    @GetMapping(value = "/customer/view/productReview/{id}")
    public ResponseEntity getProductReviewByProduct(@PathVariable("id") Long id,String username)
    {
       return productReviewService.getProductReviewByProductId(id,username);
    }
}