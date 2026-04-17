package com.example.inventariocqrs.domain;

public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(ProductoId id, int disponible, int solicitado) {
        super("Stock insuficiente para " + id.valor() + ". Disponible=" + disponible + ", solicitado=" + solicitado);
    }
}
