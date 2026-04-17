package com.example.inventariocqrs.query.handler;

import com.example.inventariocqrs.query.ListarProductosQuery;
import com.example.inventariocqrs.query.model.ProductoView;
import com.example.inventariocqrs.query.repository.ProductoReadRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ListarProductosQueryHandler {

    private final ProductoReadRepository readRepo;

    public ListarProductosQueryHandler(ProductoReadRepository readRepo) {
        this.readRepo = readRepo;
    }

    public List<ProductoView> handle(ListarProductosQuery query) {
        return readRepo.buscarTodos().stream()
            .filter(p -> query.soloDisponibles() ? p.stockDisponible() > 0 : true)
            .toList();
    }
}
