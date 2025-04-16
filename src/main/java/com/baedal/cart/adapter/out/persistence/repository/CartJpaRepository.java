package com.baedal.cart.adapter.out.persistence.repository;


import com.baedal.cart.adapter.out.persistence.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartJpaRepository extends JpaRepository<CartEntity, Long> {
    // JPA 기본 기능을 제공
}
