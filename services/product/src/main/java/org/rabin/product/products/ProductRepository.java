package org.rabin.product.products;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * @author : rabin
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByIdInOrderById(List<Integer> productIds);
}
