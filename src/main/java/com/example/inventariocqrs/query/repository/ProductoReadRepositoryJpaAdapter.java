package com.example.inventariocqrs.query.repository;

import com.example.inventariocqrs.adapter.persistence.ProductoJpaEntity;
import com.example.inventariocqrs.adapter.persistence.ProductoJpaSpringRepository;
import com.example.inventariocqrs.query.model.ProductoView;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoReadRepositoryJpaAdapter implements ProductoReadRepository {

    private final ProductoJpaSpringRepository jpa;

    public ProductoReadRepositoryJpaAdapter(ProductoJpaSpringRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Optional<ProductoView> buscarPorId(String id) {
        return jpa.findById(id).map(this::toView);
    }

    @Override
    public List<ProductoView> buscarTodos() {
        return jpa.findAll().stream().map(this::toView).toList();
    }

    private ProductoView toView(ProductoJpaEntity e) {
        return new ProductoView(
            e.getId(),
            e.getNombre(),
            e.getCategoria(),
            e.getPrecioUnitario(),
            e.getStockDisponible(),
            ProductoView.calcularEstado(e.getStockDisponible())
        );
    }
}
