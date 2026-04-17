package com.example.inventariocqrs.domain;

import java.util.Objects;
import java.util.UUID;

public record ProductoId(String valor) {

    public ProductoId {
        Objects.requireNonNull(valor, "ProductoId no puede ser nulo");
    }

    public static ProductoId nuevo() {
        return new ProductoId(UUID.randomUUID().toString());
    }
}
