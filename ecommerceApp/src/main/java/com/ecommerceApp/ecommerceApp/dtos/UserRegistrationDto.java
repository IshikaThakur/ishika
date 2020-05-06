package com.ecommerceApp.ecommerceApp.dtos;
import com.ecommerceApp.ecommerceApp.validators.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserRegistrationDto {
    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    private String middleName;

    @NotNull
    @NotEmpty
    private String lastName;

    @Email
    @NotEmpty(message = "{email.notempty}")
    private String email;


    @NotNull
    @ValidPassword
    private String password;


    @NotNull
    @ValidPassword
    private String confirmPassword;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}