package com.example.inventariocqrs.adapter.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class ProductoJpaEntity {

    @Id
    private String id;

    private String nombre;
    private String categoria;
    private BigDecimal precioUnitario;
    private int stockDisponible;

    public ProductoJpaEntity() {
    }

    public ProductoJpaEntity(String id, String nombre, String categoria, BigDecimal precioUnitario, int stockDisponible) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
        this.stockDisponible = stockDisponible;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }
}
