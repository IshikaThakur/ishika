package com.ecommerceApp.ecommerceApp.Repositories;

import com.ecommerceApp.ecommerceApp.entities.Customer;
import com.ecommerceApp.ecommerceApp.entities.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends CrudRepository<Product,Long> {

    Product findByName(String name);

    List<Product> findAll(Pageable pageable);

    List<Product> findByBrandAndCategoryId(String brand, Long id, Pageable pageable);

    List<Product> findByBrand(String brand, Pageable pageable);

    Set<Product> findByBrand(Long categoryId);

    List<Product> findByCategoryId(Long id, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "delete from product where id = :p_id", nativeQuery = true)
    void deleteProductById(@Param("p_id") Long p_id);

    @Query(value = "select name,brand from Product where createdDate= :CURRENT_DATE",nativeQuery = true)
    List<Product> findAllWithCreationDate();
}
