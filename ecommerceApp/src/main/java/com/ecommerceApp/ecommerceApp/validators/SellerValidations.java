package com.ecommerceApp.ecommerceApp.validators;


import com.ecommerceApp.ecommerceApp.Repositories.SellerRepository;
import com.ecommerceApp.ecommerceApp.dtos.SellerRegistrationDto;
import com.ecommerceApp.ecommerceApp.entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;

public class SellerValidations {
    @Autowired
    SellerRepository sellerRepository;
    public boolean isEmailUnique(String email){
        Seller seller = sellerRepository.findByEmail(email);
        if(seller != null)
            return false;

        return true;
    }
    public boolean isGSTUnique(String GST){
        Seller seller = sellerRepository.findByGST(GST);
        if(seller != null)
            return false;

        return true;
    }
    public boolean isCompanyNameUnique(String name){
        Seller seller = sellerRepository.findByCompanyName(name);
        if(seller != null)
            return false;

        return true;
    }
    public String checkIfUnique(SellerRegistrationDto sellerRegistrationDto){
        if(!isEmailUnique(sellerRegistrationDto.getEmail())){
            return "Email already exits";
        }
        else if(!isGSTUnique(sellerRegistrationDto.getGST())){
            return "GST already exists";
        }
        else if(!isCompanyNameUnique(sellerRegistrationDto.getCompanyName())){
            return "Company name already exits ";
        }
        else{
            return "unique";
        }
    }
}