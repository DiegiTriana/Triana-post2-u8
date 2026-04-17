package com.example.inventariocqrs.command.repository;

import com.example.inventariocqrs.adapter.persistence.ProductoJpaEntity;
import com.example.inventariocqrs.adapter.persistence.ProductoJpaSpringRepository;
import com.example.inventariocqrs.domain.Producto;
import com.example.inventariocqrs.domain.ProductoId;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoWriteRepositoryJpaAdapter implements ProductoWriteRepository {

    private final ProductoJpaSpringRepository jpa;

    public ProductoWriteRepositoryJpaAdapter(ProductoJpaSpringRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public void guardar(Producto producto) {
        jpa.save(toEntity(producto));
    }

    @Override
    public Optional<Producto> buscarPorId(ProductoId id) {
        return jpa.findById(id.valor()).map(this::toDomain);
    }

    @Override
    public void eliminar(ProductoId id) {
        jpa.deleteById(id.valor());
    }

    private ProductoJpaEntity toEntity(Producto producto) {
        return new ProductoJpaEntity(
            producto.getId().valor(),
            producto.getNombre(),
            producto.getCategoria(),
            producto.getPrecioUnitario(),
            producto.getStockDisponible()
        );
    }

    private Producto toDomain(ProductoJpaEntity e) {
        return new Producto(
            new ProductoId(e.getId()),
            e.getNombre(),
            e.getCategoria(),
            e.getPrecioUnitario(),
            e.getStockDisponible()
        );
    }
}
