package com.example.inventariocqrs.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJpaSpringRepository extends JpaRepository<ProductoJpaEntity, String> {
}
