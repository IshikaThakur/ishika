package com.ecommerceApp.ecommerceApp.Repositories;

import com.ecommerceApp.ecommerceApp.entities.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends CrudRepository<Orders,Long> {
    @Query(value = "select customer_id from orders where ids=:id", nativeQuery = true)
    Long findCustomer(@Param(value = "id")Long id);
}
