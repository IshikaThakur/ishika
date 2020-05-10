package com.ecommerceApp.ecommerceApp.auditing;

import com.ecommerceApp.ecommerceApp.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;



import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Autowired
    UserService userService;

    @Override
    public Optional<String> getCurrentAuditor() {
        /*Optional<String>currentUser=Optional.empty();
         String principal=userService.getCurrentLoggedInUser();
         currentUser=Optional.of(principal);
        return currentUser;
     }*/
        return Optional.ofNullable("Ishika").filter(s -> !s.isEmpty());

    }

}